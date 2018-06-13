package usuarios;

import java.util.Date;

public class Usuario {
	private String nome;
	private int cpf;
	private int rg;
	private Endereco endereco;

	public Usuario () {}
	
	/**
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param endereco
	 */
	public Usuario(String nome, int cpf, int rg, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
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
		sb.append("Rua: " + endereco.rua + "\n");
		sb.append("Bairro: " + endereco.bairro + "\n");
		sb.append("Número: " + endereco.numero + "\n");
		sb.append("Cidade: " + endereco.cidade + "\n");
		sb.append("UF: " + endereco.uf + "\n");
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
	public int getCpf() {
		return cpf;
	}
	
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * @return the rg
	 */
	public int getRg() {
		return rg;
	}
	
	/**
	 * @param rg the rg to set
	 */
	public void setRg(int rg) {
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
}
