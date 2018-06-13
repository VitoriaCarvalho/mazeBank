package usuarios;

import java.util.Date;

/**
 * Classe que representa um cliente de um banco
 * @author vitoria
 *
 */
public class Cliente extends Usuario {
	private String dataEntrada;
	
	public Cliente () {}

	/**
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param endereco
	 * @param telefone
	 * @param dataNasc
	 * @param login
	 * @param senha
	 * @param dataEntrada
	 */
	public Cliente(String nome, String cpf, String rg, String telefone, String dataNasc, Endereco endereco, String dataEntrada) {
		super(nome, cpf, rg, telefone, dataNasc, endereco);
		this.dataEntrada = dataEntrada;
		
	}

	/**
	 * @return the dataEntrada
	 */
	public String getDataEntrada() {
		return dataEntrada;
	}

	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
}
