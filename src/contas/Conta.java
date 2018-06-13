package contas;

import java.math.BigDecimal;

import exceptions.NegativeValueException;
import usuarios.Cliente;

/**
 * 
 * @author vitoria
 *
 */
public abstract class Conta {
	private Cliente titular;
	private BigDecimal saldo;
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
	public Conta(Cliente titular, BigDecimal saldo, String numAgencia, String numConta, String senha) {
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
	public boolean deposita(BigDecimal valor) throws NegativeValueException {
		if (valor.compareTo(new BigDecimal("0")) > 0) {			
			this.setSaldo(this.getSaldo().add(valor));
			return true;
		} else {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		}
	}

	/**
	 * @return the saldo
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the titular
	 */
	public Cliente getTitular() {
		return titular;
	}

	/**
	 * @return the numAgencia
	 */
	public String getNumAgencia() {
		return numAgencia;
	}

	/**
	 * @return the numConta
	 */
	public String getNumConta() {
		return numConta;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}	
}
