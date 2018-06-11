package contas;

import exceptions.NegativeValueException;
import exceptions.TaPobreException;
import exceptions.TransferenciaRecursivaException;

public class ContaCorrente extends Conta implements Transferencia_Saque {
	
	@Override
	public boolean sacar(double valor) throws TaPobreException, NegativeValueException {	
		if (getSaldo() >= valor) {			
			setSaldo(getSaldo() - valor);
			return true;
		} else if (getSaldo() < valor) {
			throw new TaPobreException ("Saldo insuficiente!");
		} else {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		}
	}

	@Override
	public boolean deposita(double valor) throws NegativeValueException {
		if (valor > 0) {			
			this.setSaldo(this.getSaldo() + valor);
			return true;
		} else {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		}
	}

	@Override
	public boolean transfere(Conta conta, double valor) throws TaPobreException, NegativeValueException, TransferenciaRecursivaException {
		if (this.equals(conta)) {
			throw new TransferenciaRecursivaException("Transferências entre a mesma conta são inválidas!");
		} else if (getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
			return true;
		} else if (getSaldo() < valor) {
			throw new TaPobreException ("Saldo insuficiente!");
		} else if (valor < 0) {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		} else {
			return false;
		}
	}
}