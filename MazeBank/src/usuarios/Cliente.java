package usuarios;

/**
 * Classe que representa um cliente de um banco
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class Cliente extends Usuario {
	private String dataEntrada;
	
	public Cliente () {}

	/**
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param telefone
	 * @param dataNasc
	 * @param endereco
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
