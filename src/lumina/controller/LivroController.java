package lumina.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lumina.model.Livros;
import lumina.model.Venda;
import lumina.repository.LivroRepository;

public class LivroController implements LivroRepository{
	
	private List<Livros> listarLivros = new ArrayList<Livros>();
	private final List<Venda> historico = new ArrayList<>();
	private int seqVenda = 0;
	int id = 0;
	private String nome;

	@Override
	public void listarTodos() {
		for(Livros livros: listarLivros) {
			livros.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Livros livro) {
		listarLivros.add(livro); 
		System.out.println("\nLivro Cadastrado com sucesso! ");
		
	}

	@Override
	public void atualizar(Livros livro) {
		var buscarLivros = buscarNaCollection(livro.getId());
				
				if(buscarLivros != null) {
					listarLivros.set(listarLivros.indexOf(buscarLivros),livro);
					System.out.printf("\nO Livro ID: %d foi atualizado com sucesso! %n", livro.getId());
				}else {
					System.out.printf("\nO Livro ID %d não foi encontrado! %n", livro.getId());
				}
		
	}

	@Override
	public void procurarPorId(int id) {

		var livros = buscarNaCollection(id);
		if(livros != null) {
			livros.visualizar();
		}else {
			System.out.printf("\nO Livro ID: %d não foi encontrado! %n", id);
		}
		
	}

	@Override
	public void deletar(int id) {
		var livros = buscarNaCollection(id);
				
				if(livros != null) {
					if(listarLivros.remove(livros) == true) {
						System.out.printf("\nO Livro ID número: %d foi deletado com sucesso! %n", id);
					}
				}else {
					System.out.printf("\nO Livro ID número: %d não foi encontrado! %n", id);
				}
		
	}

	@Override
	public void listarPorTitulo(String titulo) {
	    if (titulo == null || titulo.isBlank()) {
	        System.out.println("\nTítulo inválido.");
	        return;
	    }

	    String query = titulo.toUpperCase(java.util.Locale.ROOT);

	    java.util.List<Livros> listarTitulos = listarLivros.stream()
	        .filter(l -> l.getNome() != null
	                  && l.getNome().toUpperCase(java.util.Locale.ROOT).contains(query))
	        .collect(java.util.stream.Collectors.toList());

	    if (listarTitulos.isEmpty()) {
	        System.out.printf("%nNenhum Livro foi encontrado com o Título: %s%n", titulo);
	        return;
	    }

	    for (Livros livros : listarTitulos) {
	        livros.visualizar();
	    }
	}
	@Override
	public void listarPorCategoria(int categoria) {
		List<Livros> listarCategoria = listarLivros.stream()
				.filter(l -> l.getCategoria()== categoria)
				.collect(Collectors.toList());
		if(listarCategoria.isEmpty()) {
			System.out.printf("\nNenhum Livro foi encontrado com a Categoria: %s", categoriaDescricao(categoria));
			
			return;
		}
		
		for(Livros livros : listarCategoria) {
			livros.visualizar();
		}
		
	}
	private String categoriaDescricao(int categoria) {
	    switch (categoria) {
	        case 1: return "Audiobook";
	        case 2: return "Livro Físico";
	        default: return "Desconhecida";
	    }
	}

	@Override
	public void listarPorAutor(String autor) {


		List<Livros> listarAutores = listarLivros.stream()
				.filter(a -> a.getAutor().toUpperCase().contains(autor.toUpperCase()))
				.collect(Collectors.toList());
		if(listarAutores.isEmpty()) {
			System.out.printf("\nNenhum Livro foi encontrado com Autor: %s", autor);
		}
		
		for(Livros livros : listarAutores) {
			livros.visualizar();
		}
		
	}

	@Override
	public void qntEstoque(int estoque) {
		
		if (estoque < 0) {
	        System.out.println("\nQuantidade inválida.");
	        return;
	    }
	    int atualizados = 0;
	    for (Livros l : listarLivros) {
	        if (l.getCategoria() == 2) {
	            l.setEstoque(estoque);
	            atualizados++;
	        }
	    }
	    System.out.printf("\nEstoque definido para %d em %d livro(s) físico(s).%n", estoque, atualizados);
		
		
		
	}

	@Override
	public void venda(int idLivro) {
	    final int quantidade = 1; // vendendo 1 unidade por padrão

	    Livros l = buscarNaCollection(idLivro);
	    if (l == null) {
	        System.out.printf("\nLivro ID %d não encontrado.%n", idLivro);
	        return;
	    }

	    if (l.getCategoria() == 2) {
	        if (l.getEstoque() < quantidade) {
	            System.out.printf("\nEstoque insuficiente. Atual: %d | Solicitado: %d%n",
	                    l.getEstoque(), quantidade);
	            return;
	        }
	        l.setEstoque(l.getEstoque() - quantidade);           // baixa do estoque
	        listarLivros.set(listarLivros.indexOf(l), l);         // persiste a alteração
	    }

	    Venda v = new Venda(++seqVenda, l.getId(), l.getNome(), quantidade, l.getPreco());
		historico.add(v);
	    System.out.println("\nVenda registrada com sucesso!");
	    v.visualizar();
	}

	
	public boolean registrarVenda(int idLivro, int quantidade) {
	    if (quantidade <= 0) {
	        System.out.println("\nQuantidade deve ser maior que zero.");
	        return false;
	    }

	    Livros l = buscarNaCollection(idLivro);
	    if (l == null) {
	        System.out.printf("\nLivro ID %d não encontrado.%n", idLivro);
	        return false;
	    }

	  
	    if (l.getCategoria() == 2) {
	        if (l.getEstoque() < quantidade) {
	            System.out.printf("\nEstoque insuficiente. Atual: %d | Solicitado: %d%n",
	                    l.getEstoque(), quantidade);
	            return false;
	        }
	        l.setEstoque(l.getEstoque() - quantidade);      
	        listarLivros.set(listarLivros.indexOf(l), l);      
	    }

	    Venda v = new Venda(++seqVenda, l.getId(), l.getNome(), quantidade, l.getPreco());
	    historico.add(v);

	    System.out.println("\nVenda registrada com sucesso!");
	    v.visualizar();
	    return true;
	}
		
	
	
	public int gerarId() {
		return ++id;
	}
	

	public Livros buscarNaCollection(int id) {
		for(var livros : listarLivros) {
			if (livros.getId() == id) {
				return livros;
		}
	}
	return null;
	}

	@Override
	public void historico (int historico) {
		
		if (this.historico == null || this.historico.isEmpty()) {
	        System.out.println("\nAinda não há vendas registradas.");
	        return;
	    }

	    float soma = 0f;
	    System.out.println("**************** HISTÓRICO DE VENDAS****************");
	    for (Venda v : this.historico) {
	        v.visualizar();
	        soma += v.getTotal();
	    }
	    System.out.printf("\nTOTAL FATURADO: R$ %.2f%n", soma);
		
	}
	
}
