package contas;

import java.math.BigDecimal;

import banco.Banco;
import banco.Cambio;
import exceptions.EntradasErroneas;
import exceptions.NegativeValueException;
import exceptions.TaPobreException;
import exceptions.TransferenciaRecursivaException;

/**
 * Classe que contém as possíveis ações de uma conta corrente no sistema.
 * @author vitoria and Jederson and Açucena and João Victor
 *
 */
public class ContaCorrente extends Conta implements Transferencia_Saque {
	private BigDecimal divida;
	
	public BigDecimal getDivida() {
		return divida;
	}

	public void setDivida(BigDecimal divida) {
		this.divida = divida;
	}

	@Override
	public boolean sacar(BigDecimal valor) throws TaPobreException, NegativeValueException {	
		if (getSaldo().compareTo(valor) >= 0) {			
			setSaldo(getSaldo().subtract(valor));
			return true;
		} else if (getSaldo().compareTo(valor) < 0) {
			throw new TaPobreException ("Saldo insuficiente!");
		} else {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		}
	}

	@Override
	public boolean transfere(Conta conta, BigDecimal valor) throws TaPobreException, NegativeValueException, TransferenciaRecursivaException {
		if (this.equals(conta)) {
			throw new TransferenciaRecursivaException("Transferências entre a mesma conta são inválidas!");
		} else if (getSaldo().compareTo(valor) >= 0) {
			this.setSaldo(this.getSaldo().subtract(valor));
			conta.setSaldo(conta.getSaldo().add(valor));
			return true;
		} else if (getSaldo().compareTo(valor) < 0) {
			throw new TaPobreException ("Saldo insuficiente!");
		} else if (valor.compareTo(new BigDecimal("0")) >= 0) {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		} else {
			return false;
		}
	}

	@Override
	public void menu() {
		String opcao = null;
		BigDecimal valor;
		
		do {			
			try {
				System.out.println("+-----------------------------------+");
				System.out.println("|          Conta Corrente           |");
				System.out.println("+-----------------------------------+");
				System.out.println("| 1 - Depositar                     |");
				System.out.println("| 2 - Sacar                         |");
				System.out.println("| 3 - Transferir                    |");
				System.out.println("| 4 - Ver Saldo                     |");
				System.out.println("| 5 - Emprestimo Consignado         |");
				System.out.println("| 6 - Emprestimo Não Consignado (NC)|");
				System.out.println("| 7 - Debitar Empŕestimo NC         |");
				System.out.println("| 0 - Sair                          |");
				System.out.println("+-----------------------------------+");
				opcao = EntradasErroneas.validaNumeros();
				
				switch (opcao) {
				case "1":
					System.out.println("Informe o valor a se depositar: ");
					valor = new BigDecimal(EntradasErroneas.inputBigDecimal());
					valor = Cambio.converteParaReal(valor);
					this.deposita(valor);
					System.out.println("Valor convertido para real.");
					break;
				case "2":
					System.out.println("Informe o valor do saque: ");
					valor = new BigDecimal(EntradasErroneas.inputBigDecimal());
					this.sacar(valor);
					System.out.println("R$ " + valor + " convertido para " + Cambio.converteDeReal(valor));
					break;
				case "3":
					System.out.println("Informe o número da conta destino: ");
					String num = EntradasErroneas.scanner.nextLine().toString();
					System.out.println("Informe o número da agencia: ");
					String ag = EntradasErroneas.scanner.nextLine().toString();
					
					for (Conta contas : Banco.contas) {
						if (contas.getNumConta().equals(num) && contas.getNumAgencia().equals(ag)) {
							if (contas instanceof ContaCorrente || contas instanceof ContaPoupanca) {
								System.out.println("Informe o valor a ser trasnferido: ");
								valor = new BigDecimal(EntradasErroneas.inputBigDecimal());
								this.transfere(contas, valor);
								break;
							} else {							
								System.err.println("Desculpe, conta salário não pode receber transferência!");
							}
						}
					}
					break;
				case "4":
					System.out.println("Consulta de saldo:");
					System.out.println(this.toString());
					break;
				case "5":
					this.emprestimoConsignado();
					break;
				case "6":
					this.emprestimoNaoConsignado();
					break;
				case "7":
					this.debitarEmprestimo();
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

	/**
	 * Método que concede um empréstimo consignado a um cliente, caso o mesmo possua uma conta salário anexada  
	 */
	private void emprestimoConsignado() {
		
		for (Conta conta : Banco.contas) {
			if (conta instanceof ContaSalario) {
				if (((ContaSalario) conta).getContaAnexada().equals(this)) {
					System.out.println("Valor do empréstimo: ");
					BigDecimal valor = new BigDecimal(EntradasErroneas.inputBigDecimal());
					((ContaSalario) conta).setDivida(valor);
					System.out.println("Empréstimo consignado realizado! A dívida será debitada da sua conta salário.");
					return;
				}
			}
		}
		
		System.out.println("Você não tem conta salário associada, o empréstimo consignado não pode ser realizado!");
	}
	
	/**
	 * Método que concede um empréstimo não consignado a um cliente  
	 */
	private void emprestimoNaoConsignado() {
		System.out.println("Informe o valor do empréstimo: ");
		this.setDivida(new BigDecimal(EntradasErroneas.inputBigDecimal()));
	}
	
	/**
	 * Método para realizar o pagamento da dívida do empréstimo não consignado
	 */
	private void debitarEmprestimo() {
		
		if (this.getDivida().compareTo(new BigDecimal("0")) > 0) {
			System.out.println("Sua dívida é de: R$ " + this.getDivida());
			if (this.getSaldo().compareTo(this.getDivida()) >= 0) {
				this.setSaldo(this.getSaldo().subtract(this.getDivida()));
				this.setDivida(new BigDecimal("0"));
				System.out.println("Dívida paga!");
			} else {
				System.out.println("Seu saldo é insuficiente para pagar a dívida!");
			} 
		} else {
			System.out.println("Você não possui dívidas!");
		}
		
	}
}
