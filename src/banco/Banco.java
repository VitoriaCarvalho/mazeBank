package banco;

import java.util.ArrayList;
import contas.*;
import exceptions.EntradasErroneas;
import gerencia.MenuGerente;
import usuarios.Gerente;
import usuarios.Usuario;

public class Banco {
	public static ArrayList<Conta> contas;
	public static ArrayList<Usuario> usuarios;
	
	public static void main(String[] args) {
		String opcao = null;
		contas = new ArrayList<>();
		usuarios = new ArrayList<>();
		
		/**
		 * Este objeto representa o administrador do sistema
		 */
		Gerente admin = new Gerente("Master", null, null, null, null, null, null, "master", "123");
		usuarios.add(admin);
		
		do {
			System.out.println("+-------------------------+");
			System.out.println("|         MazeBank        |");
			System.out.println("+-------------------------+");
			System.out.println("| 1 - Entrar como gerente |");
			System.out.println("| 2 - Entrar como cliente |");
			System.out.println("| 0 - Sair                |");
			System.out.println("+-------------------------+");
			opcao = EntradasErroneas.scanner.nextLine().toString();
			
			switch (opcao) {
			case "1":
				if (Login.loginGerente()) {
					MenuGerente.menuGerente();
				} else {
					System.err.println("\nAcesso negado!\n");
				}
				break;
			case "2":
				System.out.println("Número da conta que deseja buscar: ");
				String num = EntradasErroneas.validaNumeros();
				System.out.println("Número da agência: ");
				String ag = EntradasErroneas.validaNumeros();
				
				for (Conta conta : Banco.contas) {
					if (conta.getNumConta().equals(num) && conta.getNumAgencia().equals(ag)) {
						if (conta instanceof ContaCorrente) {
							ContaCorrente cc = (ContaCorrente) conta;
							cc.menu();
						} else if (conta instanceof ContaPoupanca) {
							ContaPoupanca cp = (ContaPoupanca) conta;
							cp.menu();
						} else if (conta instanceof ContaSalario) {
							ContaSalario cs = (ContaSalario) conta;
							cs.menu();
						}
					}
				}
				break;
			case "0":
				System.out.println("Programa encerrado. Obrigado por utilizar o MazeBank :)");
				break;
			default:
				System.err.println("Opção inválida! Tente novamente.");
				break;
			}
			
		} while (!opcao.equals("0"));
	}
}