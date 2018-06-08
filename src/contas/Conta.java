package contas;

import exceptions.TaPobreException;

public abstract class Conta {
	private Cliente titular;
	private double saldo;
	private String numAgencia;
	private String numConta;
	
	public Conta () {}
		
	/**
	 * @param titular
	 * @param saldo
	 * @param numAgencia
	 * @param numConta
	 */
	public Conta(Cliente titular, double saldo, String numAgencia, String numConta) {
		super();
		this.titular = titular;
		this.saldo = saldo;
		this.numAgencia = numAgencia;
		this.numConta = numConta;
	}
	
	/**
	 * Ação para realizar deposito, ou seja, somar do saldo o valor a ser depositado 
	 * @param valor
	 * @return true caso tenha dado certo o depósito
	 */
	public abstract boolean deposita (double valor);
	
	/**
	 * Ação que realiza transferência de valores entre duas contas, ou seja,
	 * subtrai o valor de uma e somar o mesmo valor na outra
	 * @param conta
	 * @param valor
	 * @return true caso tenha dado certo a transferência
	 * @throws TaPobreException
	 */
	public abstract boolean transfere (Conta conta, double valor) throws TaPobreException;

	/**
	 * @return the saldo
	 */
	protected double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the titular
	 */
	protected Cliente getTitular() {
		return titular;
	}

	/**
	 * @return the numAgencia
	 */
	protected String getNumAgencia() {
		return numAgencia;
	}

	/**
	 * @return the numConta
	 */
	protected String getNumConta() {
		return numConta;
	}	
}
