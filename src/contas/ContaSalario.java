package contas;

import exceptions.NegativeValueException;
import exceptions.TaPobreException;

public class ContaSalario extends Conta{
	private ContaCorrente contaAnexada;

	/**
	 * Nesta classe esta operação pode apenas ser utilizada pelo gerente intermediando o empregador 
	 */
	@Override
	public boolean deposita(double valor) throws NegativeValueException {
		if (valor > 0) {			
			this.setSaldo(this.getSaldo() + valor);
			return true;
		} else {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		}
	}
	
	/**
	 * A ação transferência em conta salário é restrita apenas à conta corrente de mesmo titular e deve ser transferido o valor completo da conta
	 */
	public boolean transfere() throws TaPobreException {
		if (getSaldo() > 0) {
			contaAnexada.setSaldo(contaAnexada.getSaldo() + this.getSaldo());
			this.setSaldo(0);
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
