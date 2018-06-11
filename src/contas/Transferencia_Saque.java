package contas;

import exceptions.NegativeValueException;
import exceptions.TaPobreException;
import exceptions.TransferenciaRecursivaException;

public interface Transferencia_Saque {
	/**
	 * Ação que realiza a subtração de valores na conta em questão
	 * @param valor
	 * @return true se o saque for bem sucedido
	 * @throws TaPobreException
	 * @throws NegativeValueException
	 */
	public boolean sacar (double valor) throws TaPobreException, NegativeValueException;
	
	/**
	 * Ação que realiza transferência de valores entre duas contas, ou seja,
	 * subtrai o valor de uma e somar o mesmo valor na outra
	 * @param conta
	 * @param valor
	 * @return true caso tenha dado certo a transferência
	 * @throws TaPobreException
	 * @throws NegativeValueException 
	 */
	public abstract boolean transfere (Conta conta, double valor) throws TaPobreException, NegativeValueException, TransferenciaRecursivaException;
}
