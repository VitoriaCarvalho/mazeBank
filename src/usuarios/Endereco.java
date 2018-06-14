package usuarios;

import java.io.Serializable;

/**
 * Classe que contém os atributos que descrevem o endereço de um usuário.
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class Endereco implements Serializable {
	protected String rua;
	protected String bairro;
	protected String numero;
	protected String cidade;
	protected String uf;
	
	public Endereco () {}
	
	/**
	 * @param rua
	 * @param bairro
	 * @param numero
	 * @param cidade
	 * @param uf
	 */
	public Endereco(String rua, String bairro, String numero, String cidade, String uf) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
	}

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}
	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
}
