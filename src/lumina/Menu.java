package lumina;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Scanner;

import lumina.model.Audiobook;
import lumina.model.LivroFisico;
import lumina.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	//private static final ContaController contaController = new ContaController();
					// aqui é a classe, a proxima é o objeto		
	
	public static void main(String[] args) {
		

		int op=0;
		
		//criar teste
		LivroFisico lf = new LivroFisico(1, "Harry", 1, "JK", 50.00f,3, 8);
		lf.visualizar();
		
		Audiobook ab = new Audiobook(2, "Como fazer Amigos e Influenciar Pessoas", 2, "Dale Carnegille", 70.00f,Duration.ofHours(90));
		ab.visualizar();
		
		
		
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
		System.out.println("\t\t 9 - Atualizar quantidade em estoque");
		System.out.println("\t\t 10 - Registrar venda de Livro");
		System.out.println("\t\t 11 - Histórico de Vendas");
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
			}else if(op >= 11 ) {
				System.out.println("\n Opção inválida! Tente novamente.");
				}
		}catch (InputMismatchException e) {
			System.out.println("ERRO! Entrada inválida. Tente novamente.");
			leia.next();
		}

		
		
		switch (op) {
			case 1: System.out.println("Cadastrar Livro");
			keyPress();
			break;
			
			case 2: System.out.println("Listar todos os Livros");
			keyPress();
			break;
			
			case 3: System.out.println("Buscar Livro por Categoria");
			keyPress();
			break;
			
			case 4: System.out.println("Buscar Livro por ID");
			keyPress();
			break;
			
			case 5: System.out.println(" Atualizar Dados do Livro");
			keyPress();
			break;
			
			case 6: System.out.println("Apagar Livro");
			keyPress();
			break;
			
			case 7: System.out.println("Procurar Livro pelo Título");
			keyPress();
			break;
			
			case 8: System.out.println("Procurar Livro pelo Autor");
			keyPress();
			break;
			
			case 9: System.out.println("Atualizar quantidade no estoque");
			keyPress();
			break;
			
			case 10: System.out.println("Registrar venda de Livro");
			keyPress();
			break;
			
			case 11: System.out.println("Historico de Vendas");
			keyPress();
			break;

		}
		
		
		sobre();
	
		}
	
}

	public static void sobre(){
		System.out.println("\n****************************************************************************"
				+ 			"\n\tProjeto deselvoldito por:\n"
				+ 			"\tRafaela Lemes - Dev Full Stack\n "
				+ 			"\tgithub.com/lemesdemorais\n"
				+ 			"\n****************************************************************************");		
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressiona Enter para continuar...");
		leia.nextLine();
		}
	

	
}
