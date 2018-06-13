package contas;

import java.math.BigDecimal;

import exceptions.EntradasErroneas;
import exceptions.TaPobreException;

/**
 * Nesta classe o método de depósito pode ser utilizado apenas pelo gerente, intermediando o empregador.
 * @author vitoria and Jederson 
 */
public class ContaSalario extends Conta {
	private ContaCorrente contaAnexada;
	
	/**
	 * A ação transferência em conta salário é restrita apenas à conta corrente de mesmo titular e deve ser transferido o valor completo da conta
	 * @return true caso a operação seja bem sucedida
	 */
	public boolean transfere() throws TaPobreException {
		if (getSaldo().compareTo(new BigDecimal("0")) > 0) {
			contaAnexada.setSaldo(contaAnexada.getSaldo().add(getSaldo()));
			this.setSaldo(new BigDecimal("0"));
			return true;
		} else {
			throw new TaPobreException("Não há saldo disponível nessa conta!");
		}
	}

	/**
	 * @return the contaAnexada
	 */
	public ContaCorrente getContaAnexada() {
		return contaAnexada;
	}
	
	@Override
	public void menu() {
		String opcao;
		
		do {			
			try {
				System.out.println("+-----------------------------+");
				System.out.println("|        Conta Salário        |");
				System.out.println("+-----------------------------+");
				System.out.println("| 1 - Transferir              |");
				System.out.println("| 2 - Ver Saldo               |");
				System.out.println("| 0 - Sair                    |");
				System.out.println("+-----------------------------+");
				opcao = EntradasErroneas.validaNumeros();
				
				switch (opcao) {
				case "1":
					System.out.println("\nTransferência para a conta corrente anexada:\n");
					this.transfere();
					break;
				case "2":
					System.out.println("\nConsulta de saldo:\n");
					System.out.println(this.toString());
					break;
				case "0":
					break;
				default:
					System.err.println("Opção incorreta. Tente novamente!");
					break;
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (true);
	}
}
