package usuarios;

import java.util.Date;

public class Usuario {
	private String nome, cpf, rg, telefone, dataNasc;
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
		sb.append("Nome: " + nome + "\n");
		sb.append("CPF: " + cpf + "\n");
		sb.append("RG: " + rg + "\n");
		sb.append("Data de nascimento: " + dataNasc + "\n");
		sb.append("Rua: " + endereco.rua + "\n");
		sb.append("Bairro: " + endereco.bairro + "\n");
		sb.append("Número: " + endereco.numero + "\n");
		sb.append("Cidade: " + endereco.cidade + "\n");
		sb.append("UF: " + endereco.uf + "\n");
		sb.append("Telefone: " + telefone);
		sb.append("\n+------------------------------------------------------+\n");
		return sb.toString();
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
}
