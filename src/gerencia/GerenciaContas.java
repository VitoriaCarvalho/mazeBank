package gerencia;

import banco.Banco;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import exceptions.EntradasErroneas;

/**
 * Classe responsável por realizar as funções de gerenciamento das contas no sistema.
 * @author vitoria and Jederson
 *
 */
public class GerenciaContas {

	/**
	 * Método que faz a interação entre o gerente logado no sistema e as funções de gerenciamento de contas.
	 */
	public static void gerenciaContas() {
		String opcao;
		do {
			System.out.println("+------------------------+");
			System.out.println("|   Gerência de contas   |");
			System.out.println("+------------------------+");
			System.out.println("| 1 - Criar conta        |");
			System.out.println("| 2 - Remover conta      |");
			System.out.println("| 3 - Buscar conta       |");
			System.out.println("| 4 - Listar contas      |");
			System.out.println("| 0 - Sair               |");
			System.out.println("+------------------------+");
			opcao = EntradasErroneas.validaNumeros();
			
			switch (opcao) {
			case "1":
				do {
					System.out.println("+------------------------+");
					System.out.println("|     Tipo de conta      |");
					System.out.println("+------------------------+");
					System.out.println("| 1 - Corrente           |");
					System.out.println("| 2 - Poupança           |");
					System.out.println("| 3 - Salário            |");
					System.out.println("| 0 - Sair               |");
					System.out.println("+------------------------+");
					opcao = EntradasErroneas.validaNumeros();
					
					if (opcao.equals("1")) {
						ContaCorrente cc = new ContaCorrente();
						cc.cadastrarConta();
						Banco.contas.add(cc);
						break;
					} else if (opcao.equals("2")) {
						ContaPoupanca cp = new ContaPoupanca();
						cp.cadastrarConta();
						Banco.contas.add(cp);
						break;
					} else if (opcao.equals("3")) {
						ContaSalario cs = new ContaSalario();
						cs.cadastrarConta();
						Banco.contas.add(cs);
						break;
					} else if (opcao.equals("0")) {
						break;
					} else {
						System.err.println("Opção incorreta. Tente novamente!");
					}
				} while (true);
				break;
			case  "2":
				removerConta();
				break;
			case "3":
				buscarConta();
				break;
			case "4":
				listarContas();
				break;
			default:
				System.err.println("Opção incorreta. Tente novamente!");
				break;
			}
		} while (!opcao.equals("0"));
	}


	/**
	 * Método responsável por remover uma conta do banco, caso exista.
	 */
	private static void removerConta() {
		System.out.println("Número da conta que deseja remover: ");
		String num = EntradasErroneas.validaNumeros();
		System.out.println("Número da agência: ");
		String ag = EntradasErroneas.validaNumeros();
		
		for (Conta contas : Banco.contas) {
			if (contas.getNumConta().equals(num) && contas.getNumAgencia().equals(ag)) {
				Banco.contas.remove(contas);
				System.out.println("Conta removida do mazeBank!");
				return;
			}
		}
		
		System.out.println("Conta inexistente! Verifique os números da conta e agência digitados.");
	}
	
	/**
	 * Método responsável por buscar uma conta e mostrar suas informações.
	 */
	private static void buscarConta() {
		System.out.println("Número da conta que deseja buscar: ");
		String num = EntradasErroneas.validaNumeros();
		System.out.println("Número da agência: ");
		String ag = EntradasErroneas.validaNumeros();
		
		for (Conta conta : Banco.contas) {
			if (conta.getNumConta().equals(num) && conta.getNumAgencia().equals(ag)) {
				if (conta instanceof ContaCorrente) {
					System.out.println("+--------------------------------+");
					System.out.println("|         Conta Corrente         |");
					System.out.println("+--------------------------------+");
					conta.toString();
				} else if (conta instanceof ContaPoupanca) {
					System.out.println("+--------------------------------+");
					System.out.println("|         Conta Poupanca         |");
					System.out.println("+--------------------------------+");
					conta.toString();
				} else if (conta instanceof ContaSalario) {
					System.out.println("+--------------------------------+");
					System.out.println("|         Conta Salario          |");
					System.out.println("+--------------------------------+");
					conta.toString();
				}
			}
		}
	}
	
	/**
	 * Método responsável por listar todas as contas, exibindo suas informações.
	 */
	private static void listarContas() {
		for (Conta conta : Banco.contas) {
			if (conta instanceof ContaCorrente) {
				System.out.println("+--------------------------------+");
				System.out.println("|         Conta Corrente         |");
				System.out.println("+--------------------------------+");
				conta.toString();
			} else if (conta instanceof ContaPoupanca) {
				System.out.println("+--------------------------------+");
				System.out.println("|         Conta Poupanca         |");
				System.out.println("+--------------------------------+");
				conta.toString();
			} else if (conta instanceof ContaSalario) {
				System.out.println("+--------------------------------+");
				System.out.println("|         Conta Salario          |");
				System.out.println("+--------------------------------+");
				conta.toString();
			}
		}
	}

}
