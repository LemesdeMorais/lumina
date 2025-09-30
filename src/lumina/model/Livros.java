package lumina.model;

public abstract class Livros {

	private int id;
	private String nome;
	private int categoria;
	private String autor;
	private Float preco;
	private int estoque;
	
	public Livros(int id, String nome, int categoria, String autor, Float preco, int estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.autor = autor;
		this.preco = preco;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	private static String categoriaDescricao(int categoria) {
		return switch (categoria) {
		case 1 -> "AudioBook";
		case 2 -> "Livro Fisico";
		default -> "Desconhecida !";
		};
	}
	
	
	public void visualizar() {
			
		
		System.out.println("\n****************************************");
		System.out.println("\tDados do Livro");
		System.out.println("****************************************");
		System.out.printf("ID do Livro: %s%n", this.id);
		System.out.printf("Título do Livro: %s%n", this.nome);
		System.out.printf("Categoria do Livro: %s%n", Livros.categoriaDescricao(categoria));
		System.out.printf("Autor do Livro:  %s%n", autor);
		System.out.printf("Preço do Livro %.2f%n", this.preco);
		System.out.printf("Estoque do Livro: %d%n", this.estoque);
	}
	
	
	
	
	
	
}
