package lumina;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Scanner;

import lumina.controller.LivroController;
import lumina.model.Audiobook;
import lumina.model.LivroFisico;
import lumina.model.Livros;
import lumina.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final LivroController livroController = new LivroController();
					// aqui é a classe, a proxima é o objeto		
	
	public static void main(String[] args) {
		

		int op=0;
		
		//criar teste
		/*LivroFisico lf = new LivroFisico(1, "Harry", 1, "JK", 50.00f,3, 8);
		lf.visualizar();
		
		Audiobook ab = new Audiobook(2, "Como fazer Amigos e Influenciar Pessoas", 2, "Dale Carnegille", 70.00f,Duration.ofHours(90));
		ab.visualizar();*/
		
		
		
		while(true) { // verificar onde tenho que fechar essa chave
		System.out.println("****************************************************************************");
		System.out.println("");
		System.out.println("\tLumina - Sua varinha é um livro, sua magia é o conhecimento. ");
		System.out.println("");
		System.out.println("****************************************************************************");
		System.out.println("");
		System.out.println("\t\t 1 - Cadastrar Livro");
		System.out.println("\t\t 2 - Listar todos os Livros");
		System.out.println("\t\t 3 - Listar  os Livros por Categoria");
		System.out.println("\t\t 4 - Buscar Livro por ID");
		System.out.println("\t\t 5 - Atualizar Dados do Livro");
		System.out.println("\t\t 6 - Apagar Livro");
		System.out.println("\t\t 7 - Procurar Livro pelo Título");
		System.out.println("\t\t 8 - Procurar Livro pelo Autor");
		System.out.println("\t\t 9 - Registrar venda de Livro");
		System.out.println("\t\t 10 - Histórico de Vendas");
		System.out.println("\t\t 0 - Sair");
		System.out.println("");
		System.out.println("****************************************************************************");
		System.out.println("Entre com a opção desejada:");
		
		try {
		op = leia.nextInt();
		leia.nextLine();

		if (op == 0) {
			System.out.println("\n Lumina - Sua varinha é um livro, sua magia é o conhecimento!");
			leia.close();
			System.exit(0);
			}else if(op >= 10 || op < 0 ) {
				System.out.println("\n Opção inválida! Tente novamente.");
				}
		}catch (InputMismatchException e) {
			System.out.println("ERRO! Entrada inválida. Tente novamente.");
			leia.next();
		}

		
		
		switch (op) {
			case 1: System.out.println("Cadastrar Livro");
			cadastrarLivros();
			keyPress();
			break;
			
			case 2: System.out.println("Listar todos os Livros");
			listarLivros();
			keyPress();
			break;
			
			case 3: System.out.println("Buscar Livro por Categoria");
			listarPorCategoria();
			keyPress();
			break;
			
			case 4: System.out.println("Buscar Livro por ID");
			procurarPorId();
			keyPress();
			break;
			
			case 5: System.out.println(" Atualizar Dados do Livro");
			atualizarLivro();
			keyPress();
			break;
			
			case 6: System.out.println("Apagar Livro");
			deletarLivro();
			keyPress();
			break;
			
			case 7: System.out.println("Procurar Livro pelo Título");
			listarPorTitulo();
			keyPress();
			break;
			
			case 8: System.out.println("Procurar Livro pelo Autor");
			listarPorAutor();
			keyPress();
			break;
			
			case 9: System.out.println("Registrar venda de Livro");
			keyPress();
			break;
			
			case 10: System.out.println("Historico de Vendas");
			keyPress();
			break;

		}
		
		
		sobre();
	
		}
	
}

	public static void sobre(){
		System.out.println("\n****************************************************************************"
				+ 			"\n\tProjeto desenvolvito por:\n"
				+ 			"\tRafaela Lemes - Dev Full Stack\n "
				+ 			"\tgithub.com/lemesdemorais\n"
				+ 			"\n****************************************************************************");		
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressiona Enter para continuar...");
		leia.nextLine();
		}
	
	private static void listarLivros() {
		livroController.listarTodos();
		
	}
	
	
	private static void cadastrarLivros() {

		System.out.print("Digite o Titulo do Livro:  ");
		String nome = leia.nextLine();

		System.out.print("Digite o Autor do Livro: ");
		String autor = leia.nextLine();

		System.out.print("Digite a Categoria do Livro (1 - AudioBook | 2 - Livro Físico): ");
		int categoria = leia.nextInt();

		System.out.print("Digite o preço: ");
		float preco = leia.nextFloat();
		


		int idGerado = livroController.gerarId();

		if (categoria == 1) { 

			 System.out.print("Digite a duração (HH:MM ou HH:MM:SS): ");

			 System.out.print("Horas: ");
			    int horas = leia.nextInt();
			    System.out.print("Minutos: ");
			    int minutos = leia.nextInt();
			    leia.nextLine(); 

			    if (horas < 0 || minutos < 0) {
			        System.out.println("Valores inválidos. Usando 1h.");
			        horas = 1; minutos = 0;
			    }

		        
		        
		        java.time.Duration duracao = java.time.Duration.ofHours(horas).plusMinutes(minutos);;

		        Audiobook ab = new Audiobook(idGerado, nome, categoria, autor, preco, duracao);
	

		        livroController.cadastrar(ab);

			} else if (categoria == 2) {
	
			    System.out.print("Digite o estoque do Livro: ");
			     int estoque = leia.nextInt();
			    leia.nextLine(); 
	
			    System.out.print("Digite o peso (em gramas): ");
			   int peso = leia.nextInt();
			    leia.nextLine(); 

			    LivroFisico lf = new LivroFisico(
			        idGerado, nome, categoria, autor, Float.valueOf(preco), estoque, peso
			    );
			    livroController.cadastrar(lf);
			}
		
		}
	
	private static void procurarPorId() {
		System.out.print("Digite o ID do Livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		livroController.procurarPorId(id);
	}
	
	private static void deletarLivro() {
		System.out.print("Digite o ID do Livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		Livros livro = livroController.buscarNaCollection(id);

		if (livro != null) {

			System.out.print("\nTem certeza que deseja excluir esse Livro? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				livroController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nA conta número %d não foi encontrada!", livro);
		}
	}
	
	
	private static void atualizarLivro() {

		System.out.print("Digite o ID do Livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		Livros livro = livroController.buscarNaCollection(id);

		if (livro != null) {

	        float precoAtual = livro.getPreco();

	        System.out.printf("Valor Atual: R$ %.2f%nNovo Valor (ENTER para manter): ", precoAtual);
	        String entrada = leia.nextLine().trim();

	        if (!entrada.isEmpty()) {
	            try {
	                // aceita vírgula como separador decimal
	                float novoPreco = Float.parseFloat(entrada.replace(',', '.'));
	                livro.setPreco(novoPreco);
	            } catch (NumberFormatException e) {
	                System.out.println("Valor inválido. Mantendo preço atual.");
	            }
	        }

	        // OPCIONAL: atualizar estoque apenas para Livro Físico (categoria 2)
	        if (livro.getCategoria() == 2) {
	            System.out.printf("Estoque Atual: %d%nNovo Estoque (ENTER para manter): ", livro.getEstoque());
	            String inEstoque = leia.nextLine().trim();
	            if (!inEstoque.isEmpty()) {
	                try {
	                    int novoEstoque = Integer.parseInt(inEstoque);
	                    if (novoEstoque >= 0) {
	                        livro.setEstoque(novoEstoque);
	                    } else {
	                        System.out.println("Estoque inválido. Mantendo valor atual.");
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Entrada inválida. Mantendo estoque atual.");
	                }
	            }
	        }

	        // grava a alteração
	        livroController.atualizar(livro);

	    } else {
	        System.out.printf("%nO Livro %d não foi encontrado!%n", id);
	    }
	}
	
	private static void listarPorTitulo() {
		System.out.print("Digite o nome do Livro: ");
		String titulo = leia.nextLine().trim();
		if (titulo.isEmpty()) {
	        System.out.println("Título vazio. Tente novamente.");
	        return;
	    }
		livroController.listarPorTitulo(titulo);

	}
	
	private static void listarPorAutor() {
		System.out.print("Digite o nome do Autor: ");
		String autor = leia.nextLine().trim();
		if (autor.isEmpty()) {
	        System.out.println("Autor vazio. Tente novamente.");
	        return;
	    }
		livroController.listarPorAutor(autor);

	}
	
	private static void listarPorCategoria() {
		System.out.print("Digite a Categoria ( 1 - AudioBook | 2 - Livro Fisico): ");
		int categoria = leia.nextInt();
	
		livroController.listarPorCategoria(categoria);

	}
	
	
	

	
}
