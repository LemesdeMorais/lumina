package lumina.model;

public class LivroFisico extends Livros{
	
	int peso;
	
	
	public LivroFisico(int id, String nome, int categoria, String autor, Float preco, int estoque, int peso) {
		super(id, nome, categoria, autor, preco, estoque);
		if (peso <= 0) {
			throw new IllegalArgumentException("Peso deve ser positivo!");
		}
		this.peso = peso;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("Peso deve ser positivo!");
		}
		this.peso = peso;
	}

	public float calcularFrete(float precoPorKg) {
		float kg = this.peso / 1000f;
		return kg * precoPorKg;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("O valor do frete é de R$ %.2f%n" , this.calcularFrete(peso));
	}
	

	


	
	

}
