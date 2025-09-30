package lumina.model;

import java.time.LocalDateTime;

public class Venda {
    private int id;
    private int idLivro;
    private String titulo;
    private int quantidade;
    private float precoUnitario;
    private float total;
    private LocalDateTime dataHora = LocalDateTime.now();

    public Venda(int id, int idLivro, String titulo, int quantidade, float precoUnitario) {
        this.id = id;
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.total = quantidade * precoUnitario;
    }

    public int getId() { return id; }
    public int getIdLivro() { return idLivro; }
    public String getTitulo() { return titulo; }
    public int getQuantidade() { return quantidade; }
    public float getPrecoUnitario() { return precoUnitario; }
    public float getTotal() { return total; }
    public LocalDateTime getDataHora() { return dataHora; }

    public void visualizar() {
        System.out.println("\n********************** VENDA **********************");
        System.out.printf("Venda %d - %s%n", id, dataHora);
        System.out.printf("Livro: [%d] %s%n", idLivro, titulo);
        System.out.printf("Qtd: %d  %nPreço unit.: R$ %.2f%n", quantidade, precoUnitario);
        System.out.printf("Total: R$ %.2f%n", total);
        System.out.println("******************************************************");
    }
}
