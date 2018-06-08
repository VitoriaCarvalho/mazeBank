package contas;

import exceptions.TaPobreException;

public class ContaCorrente extends Conta implements Saque {
	

	@Override
	public boolean sacar(double valor) throws TaPobreException {
		if (getSaldo() >= valor) {			
			setSaldo(getSaldo() - valor);
			return true;
		} else {
			throw new TaPobreException ("Saldo insuficiente!");
		}
	}

	@Override
	public boolean deposita(double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfere(Conta conta, double valor) throws TaPobreException {
		if (getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
			return true;
		} else {
			throw new TaPobreException ("Saldo insuficiente!");
		}
	}
}
