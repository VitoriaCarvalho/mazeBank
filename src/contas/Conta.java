package contas;

import java.math.BigDecimal;

import banco.Banco;
import exceptions.EntradasErroneas;
import exceptions.NegativeValueException;
import usuarios.Cliente;
import usuarios.Usuario;

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
	 * Método que cria a interface do entre o cliente e a sua conta
	 */
	public abstract void menu ();
	
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
	
	/**
	 * @param titular the titular to set
	 */
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	/**
	 * @param numAgencia the numAgencia to set
	 */
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

	/**
	 * @param numConta the numConta to set
	 */
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n+--------------------------------+\n");
		sb.append("Número da conta: " + numConta + "\n");
		sb.append("Número da agência: " + numAgencia + "\n");
		sb.append("Titular: " + getTitular() + "\n");
		sb.append("Saldo da conta: R$ " + saldo + "\n");
		sb.append("+--------------------------------+\n");
		return sb.toString();
	}	

	public void cadastrarConta() {
		
		String cpf = EntradasErroneas.validaID("CPF do cliente: ");
		int flag = 0;
		Cliente cliente = null;
		
		for (Usuario users : Banco.usuarios) {
			if (users.getCpf().equals(cpf)) {
				if (users instanceof Cliente) {
					cliente = (Cliente) users;
					flag = 1;
					break;
				}
			}
		}
		
		if (flag == 0) {
			System.out.println("Desculpe, a conta não pode ser aberta porque o cliente não existe.\n"
					+ "Realize seu cadastro e depois crie a conta!");
			return;
		}
		
		System.out.println("Número da conta: ");
		this.numConta = EntradasErroneas.validaNumeros();
		
		System.out.println("Número da agência: ");
		this.numAgencia = EntradasErroneas.validaNumeros();
		
		this.titular = cliente;
		
		this.saldo = new BigDecimal("0");
	}
	
}
