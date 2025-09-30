package lumina;

import java.util.InputMismatchException;
import java.util.Scanner;

import lumina.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	//private static final ContaController contaController = new ContaController();
					// aqui é a classe, a proxima é o objeto		
	
	public static void main(String[] args) {
		
		
		int op=0;
		
		//criarContasTeste();
		
		while(true) { // verificar onde tenho que fechar essa chave
		//System.out.println("****************************************************************************");
		System.out.println("");
		System.out.println("\tLumina - Sua varinha é um livro, sua magia é o conhecimento. ");
		System.out.println("");
		System.out.println("****************************************************************************");
		System.out.println("");
		System.out.println("\t\t 1 - Cadastrar Livro");
		System.out.println("\t\t 2 - Listar todos os Livros");
		System.out.println("\t\t 3 - Buscar Livro por ID");
		System.out.println("\t\t 4 - Atualizar Dados do Livro");
		System.out.println("\t\t 5 - Apagar Livro");
		System.out.println("\t\t 6 - Procurar Livro pelo Título");
		System.out.println("\t\t 0 - Sair");
		System.out.println("");
		System.out.println("****************************************************************************");
		System.out.println("Entre com a opção desejada:");
		
		try {
		op = leia.nextInt();
		leia.nextLine();

		if (op == 0) {
			System.out.println("\n Gringotes o Banco das Bruxas - O lugar mais seguro!");
			leia.close();
			System.exit(0);
			}else if(op >= 6 ) {
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
			
			case 2: System.out.println("Listar todaos os Livros");
			

			break;
			
			case 3: System.out.println("Buscar Livro por ID");

			break;
			
			case 4: System.out.println(" Atualizar Dados do Livro");

			break;
			
			case 5: System.out.println("Apagar Livro");

			break;
			
			case 6: System.out.println("Sacar");

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
