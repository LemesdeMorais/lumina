package lumina.repository;

import lumina.model.Livros;

public interface LivroRepository {

	//métodos do CRUD
	public void listarTodos();
	public void cadastrar(Livros livro);
	public void atualizar(Livros livro);
	public void procurarPorId(int id);
	public void deletar(int id);
	public void listarPorTitulo(String titulo);
	public void listarPorCategoria(String categoria);
	public void listarPorAutor(String autor);
	
	//Metodos da Livraria
	public void qntEstoque(int estoque);
	public void venda(int venda);
	public void historico(int historico);
	
	
	
	
	/* Atualizar quantidade em estoque");
		System.out.println("\t\t 10 - Registrar venda de Livro");
		System.out.println("\t\t 11 - Histórico de Vendas");*/

}
