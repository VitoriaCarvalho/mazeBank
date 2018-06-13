package contas;

import java.math.BigDecimal;

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
}
