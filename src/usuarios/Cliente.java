package usuarios;

import java.util.Date;

/**
 * Classe que representa um cliente de um banco
 * @author vitoria
 *
 */
public class Cliente extends Usuario {
	private Date dataEntrada;
	
	public Cliente () {}

	/**
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param endereco
	 * @param login
	 * @param senha
	 * @param dataEntrada
	 */
	public Cliente(String nome, int cpf, int rg, Endereco endereco, Date dataEntrada) {
		super(nome, cpf, rg, endereco);
		this.dataEntrada = dataEntrada;
	}

	/**
	 * @return the dataEntrada
	 */
	public Date getDataEntrada() {
		return dataEntrada;
	}

	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}
