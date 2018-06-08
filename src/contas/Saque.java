package contas;

import exceptions.TaPobreException;

public interface Saque {
	public boolean sacar (double valor) throws TaPobreException;
}
