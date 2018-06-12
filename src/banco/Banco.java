package banco;

import java.util.ArrayList;
import contas.*;
import exceptions.EntradasErroneas;
import usuarios.Gerente;
import usuarios.Usuario;

public class Banco {
	public static ArrayList<Conta> contas;
	public static ArrayList<Usuario> usuarios;
	
	public static void main(String[] args) {
		int opcao = 0;
		contas = new ArrayList<>();
		usuarios = new ArrayList<>();
		
		/**
		 * Este objeto representa o administrador do sistema
		 */
		Gerente admin = new Gerente("Master", 0, 0, null, null, "master", "123");
		usuarios.add(admin);
		
		do {
			System.out.println("+-------------------------+");
			System.out.println("|         MazeBank        |");
			System.out.println("+-------------------------+");
			System.out.println("| 1 - Entrar como gerente |");
			System.out.println("| 2 - Entrar como cliente |");
			System.out.println("| 0 - Sair                |");
			System.out.println("+-------------------------+");
			opcao = EntradasErroneas.inputInt();
			
			switch (opcao) {
			case 1:
				if (Login.loginGerente()) {
					MenuGerente.menuGerente();
				} else {
					System.err.println("Acesso negado!");
				}
				break;
			case 2:
				
				break;
			case 0:
				System.out.println("Programa encerrado. Obrigado por utilizar o MazeBank :)");
				break;
			default:
				System.err.println("Opção inválida! Tente novamente.");
				break;
			}
			
		} while (opcao != 0);
	}
}
