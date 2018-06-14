package usuarios;

import java.math.BigDecimal;

/**
 * Classe que representa um gerente de um banco
 * @author vitoria and Jederson
 *
 */
public class Gerente extends Usuario {
	private BigDecimal salario;
	private String login;
	private String senha;
	
	public Gerente () {}
	/**
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param telefone
	 * @param dataNasc
	 * @param endereco
	 * @param salario
	 * @param login
	 * @param senha
	 */
	public Gerente(String nome, String cpf, String rg, String telefone, String dataNasc, Endereco endereco, BigDecimal salario, String login, String senha) {
		super(nome, cpf, rg, telefone, dataNasc, endereco);
		this.salario = salario;
		this.login = login;
		this.senha = senha;
	}
	/**
	 * @return the salario
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}



	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}



	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}



	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}



	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
