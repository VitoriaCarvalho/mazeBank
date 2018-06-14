package contas;

import java.math.BigDecimal;

import banco.Banco;
import exceptions.EntradasErroneas;
import exceptions.TaPobreException;
import usuarios.Cliente;
import usuarios.Usuario;

/**
 * Nesta classe o método de depósito pode ser utilizado apenas pelo gerente, intermediando o empregador.
 * @author vitoria, Jederson, Acucena e Joao Victor
 */
public class ContaSalario extends Conta {
	private ContaCorrente contaAnexada;
	private BigDecimal divida;
	
	/**
	 * A ação transferência em conta salário é restrita apenas à conta corrente de mesmo titular e deve ser transferido o valor completo da conta
	 * @return true caso a operação seja bem sucedida
	 */
	public boolean transfere() throws TaPobreException {
		if (getSaldo().compareTo(new BigDecimal("0")) > 0) {
			contaAnexada.setSaldo(contaAnexada.getSaldo().add(getSaldo()));
			this.setSaldo(new BigDecimal("0"));
			return true;
		} else {
			throw new TaPobreException("Não há saldo disponível nessa conta!");
		}
	}

	/**
	 * @return the contaAnexada
	 */
	public ContaCorrente getContaAnexada() {
		return contaAnexada;
	}
	
	/**
	 * @return the divida
	 */
	public BigDecimal getDivida() {
		return divida;
	}

	/**
	 * @param divida the divida to set
	 */
	public void setDivida(BigDecimal divida) {
		this.divida = divida;
	}

	@Override
	public void menu() {
		String opcao = null;
		
		do {			
			try {
				System.out.println("+-----------------------------+");
				System.out.println("|        Conta Salário        |");
				System.out.println("+-----------------------------+");
				System.out.println("| 1 - Transferir              |");
				System.out.println("| 2 - Ver Saldo               |");
				System.out.println("| 0 - Sair                    |");
				System.out.println("+-----------------------------+");
				opcao = EntradasErroneas.validaNumeros();
				
				switch (opcao) {
				case "1":
					System.out.println("\nTransferência para a conta corrente anexada:\n");
					this.transfere();
					break;
				case "2":
					System.out.println("\nConsulta de saldo:\n");
					System.out.println(this.toString());
					System.out.println("Dívida de empréstimo consignado: R$ " + divida);
					break;
				case "0":
					break;
				default:
					System.err.println("Opção incorreta. Tente novamente!");
					break;
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (!opcao.equals("0"));
	}
	
	@Override
	public void cadastrarConta(String tipo) {
		
		String cpf = EntradasErroneas.validaCPF("CPF do cliente: ");
		int flagCli = 0, flagCC = 0;
		
		for (Usuario users : Banco.usuarios) {
			if (users.getCpf().equals(cpf)) {
				if (users instanceof Cliente) {
					Cliente cliente = (Cliente) users;
					flagCli = 1;
					for (Conta conta : Banco.contas) {
						if (conta instanceof ContaCorrente) {
							if (conta.getTitular().equals(cliente)) {
								
								flagCC = 1;
								
								for (Conta conta1 : Banco.contas) {
									if (conta1 instanceof ContaSalario && conta1.getTitular().equals(cliente)) {
										System.out.println("Um cliente não pode possuir duas contas iguais!\n" +
												"Escolha outra agência.\n");
										return;
									}
								}
								
								do {
									System.out.println("Número da conta: ");
									this.numConta = EntradasErroneas.validaNumeros();
									if (!EntradasErroneas.VerificaSeNumContaExiste(numConta)) break;
								} while (true);
								
								System.out.println("Número da agência: ");
								this.numAgencia = EntradasErroneas.validaNumeros();
								
								System.out.println("Senha: ");
								this.senha = EntradasErroneas.scanner.nextLine().toString();
								
								this.titular = cliente;
								
								this.saldo = new BigDecimal("0");
								
								Banco.contas.add(this);
								
								break;
							}
						}
					}
					
				}
			}
		}
		
		if (flagCC == 0) {
			System.out.println("Desculpe, a conta não pode ser aberta porque o cliente não possui conta conrrente.");
		}
		
		if (flagCli == 0) {
			System.out.println("Desculpe, a conta não pode ser aberta porque o cliente não existe.\n"
					+ "Realize seu cadastro e depois crie a conta!");
		}
	}
}
