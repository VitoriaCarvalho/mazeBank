package usuarios;

import java.io.Serializable;

/**
 * Classe que representa um usuário do banco, contendo os atributos que o identificam. 
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class Usuario implements Serializable {
	private String nome, cpf, rg, telefone, dataNasc;
	private Endereco endereco;

	public Usuario () {}
	
	/**
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param endereco
	 * @param telefone
	 * @param dataNasc
	 */
	public Usuario(String nome, String cpf, String rg, String telefone, String dataNasc, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n+------------------------------------------------------+\n");
		sb.append("Nome: " + this.nome + "\n");
		sb.append("CPF: " + this.cpf + "\n");
		sb.append("RG: " + this.rg + "\n");
		sb.append("Data de nascimento: " + this.dataNasc + "\n");
		sb.append("Rua: " + this.endereco.getRua() + "\n");
		sb.append("Bairro: " + this.endereco.getBairro() + "\n");
		sb.append("Número: " + this.endereco.getNumero() + "\n");
		sb.append("Cidade: " + this.endereco.getCidade() + "\n");
		sb.append("UF: " + this.endereco.getUf() + "\n");
		sb.append("Telefone: " + this.telefone);
		sb.append("\n+------------------------------------------------------+\n");
		return sb.toString();
		/*return "\n+------------------------------------------------------+\n" +
				"Nome: " + this.nome + "\n" + "CPF: " + this.cpf + "\n" +
				"RG: " + this.rg + "\n" + "Data de nascimento: " + this.dataNasc + "\n" +
				"Rua: " + this.endereco.getRua() + "\n" + "Bairro: " + this.endereco.getBairro() + "\n" +
				"Número: " + this.endereco.getNumero() + "\n" + "Cidade: " + this.endereco.getCidade() + "\n" +
				"UF: " + this.endereco.getUf() + "\n" + "Telefone: " + this.telefone;*/
				
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	
	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * @return the dataNasc
	 */
	public String getDataNasc() {
		return dataNasc;
	}

	/**
	 * @param dataNasc the dataNasc to set
	 */
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
}
