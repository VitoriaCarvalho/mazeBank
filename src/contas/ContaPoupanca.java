package contas;

import java.math.BigDecimal;

import exceptions.*;

public class ContaPoupanca extends Conta implements Transferencia_Saque {
	
	@Override
	public boolean sacar(BigDecimal valor) throws TaPobreException, NegativeValueException {	
		if (getSaldo().compareTo(valor) >= 0) {			
			setSaldo(getSaldo().subtract(valor));
			return true;
		} else if (getSaldo().compareTo(valor) < 0) {
			throw new TaPobreException ("Saldo insuficiente!");
		} else {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		}
	}

	@Override
	public boolean transfere(Conta conta, BigDecimal valor) throws TaPobreException, NegativeValueException, TransferenciaRecursivaException {
		if (this.equals(conta)) {
			throw new TransferenciaRecursivaException("Transferências entre a mesma conta são inválidas!");
		} else if (getSaldo().compareTo(valor) >= 0) {
			this.setSaldo(this.getSaldo().subtract(valor));
			conta.setSaldo(conta.getSaldo().add(valor));
			return true;
		} else if (getSaldo().compareTo(valor) < 0) {
			throw new TaPobreException ("Saldo insuficiente!");
		} else if (valor.compareTo(new BigDecimal("0")) < 0) {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		} else {
			return false;
		}
	}
	
	/**
	 * Apresenta o rendimento mensal da conta, com base no saldo atual
	 * A taxa de rendimento da poupança no MazeBank é de 0,5% 
	 */
	public void rendimento () {
		if (getSaldo().compareTo(new BigDecimal("0")) > 0) {
			System.out.println("Se seu saldo continuar inalterado, em um mês seu rendimento será de R$" + getSaldo().multiply(new BigDecimal("0.005")));
		} else {
			System.err.println("Não existe saldo nessa conta!");
		}
	}
}
