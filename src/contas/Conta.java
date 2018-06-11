package contas;

import exceptions.NegativeValueException;

/**
 * 
 * @author vitoria
 *
 */
public abstract class Conta {
	private Cliente titular;
	private double saldo;
	private String numAgencia;
	private String numConta;
	private String senha;
	
	public Conta () {}
		
	/**
	 * @param titular
	 * @param saldo
	 * @param numAgencia
	 * @param numConta
	 */
	public Conta(Cliente titular, double saldo, String numAgencia, String numConta, String senha) {
		super();
		this.titular = titular;
		this.saldo = saldo;
		this.numAgencia = numAgencia;
		this.numConta = numConta;
		this.senha = senha;
	}
	
	/**
	 * Ação para realizar deposito, ou seja, somar do saldo o valor a ser depositado 
	 * @param valor
	 * @return true caso tenha dado certo o depósito
	 * @throws NegativeValueException 
	 */
	public abstract boolean deposita (double valor) throws NegativeValueException;

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

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}	
}
