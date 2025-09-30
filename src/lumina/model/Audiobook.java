package lumina.model;

import java.time.Duration;

public class Audiobook extends Livros{
	
	private Duration duracao;
	
	public Audiobook(int id, String nome, int categoria, String autor, Float preco, Duration duracao) {
		super(id, nome, categoria, autor, preco, 0); // estoque 0, pois é digital
		this.duracao = duracao;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
	}
	
	@Override
	public void visualizar() {
        super.visualizar();
        long h = duracao.toHours();
        long m = duracao.toMinutesPart();
        long s = duracao.toSecondsPart();
        System.out.printf("Duração do Audiobook: %02d:%02d:%02d%n", h, m, s);
	}
	
	
	
}
