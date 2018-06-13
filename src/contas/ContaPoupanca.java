package contas;

import java.math.BigDecimal;

import banco.Banco;
import banco.Cambio;
import exceptions.*;

public class ContaPoupanca extends Conta implements Transferencia_Saque {
	
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
		} else if (valor.compareTo(new BigDecimal("0")) < 0) {
			throw new NegativeValueException("Valor negativo é inválido para esta operação!");
		} else {
			return false;
		}
	}
	
	/**
	 * Apresenta o rendimento mensal da conta, com base no saldo atual
	 * A taxa de rendimento da poupança no MazeBank é de 0,5% 
	 */
	public void rendimento () {
		if (getSaldo().compareTo(new BigDecimal("0")) > 0) {
			System.out.println("Se seu saldo continuar inalterado, em um mês seu rendimento será de R$" + getSaldo().multiply(new BigDecimal("0.005")));
		} else {
			System.err.println("Não existe saldo nessa conta!");
		}
	}
	
	@Override
	public void menu() {
		String opcao;
		BigDecimal valor;
		
		do {			
			try {
				System.out.println("+-----------------------------+");
				System.out.println("|        Conta Poupança       |");
				System.out.println("+-----------------------------+");
				System.out.println("| 1 - Depositar               |");
				System.out.println("| 2 - Sacar                   |");
				System.out.println("| 3 - Transferir              |");
				System.out.println("| 4 - Ver Saldo               |");
				System.out.println("| 5 - Verificar rendimento    |");
				System.out.println("| 0 - Sair                    |");
				System.out.println("+-----------------------------+");
				opcao = EntradasErroneas.validaNumeros();
				
				switch (opcao) {
				case "1":
					System.out.println("Informe o valor a se depositar: ");
					valor = new BigDecimal(EntradasErroneas.inputBigDecimal());
					valor = Cambio.converteParaReal(valor);
					System.out.println("Valor convertido para real.");
					this.deposita(valor);
					break;
				case "2":
					System.out.println("Informe o valor do saque: ");
					valor = new BigDecimal(EntradasErroneas.inputBigDecimal());
					System.out.println("R$ " + valor + " convertido para " + Cambio.converteDeReal(valor));
					this.sacar(valor);
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
					System.out.println("\nConsulta de saldo:\n");
					System.out.println(this.toString());
					break;
				case "5":
					System.out.println("\nVerificar rendimento:\n");
					rendimento();
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
		} while (true);
	}
	
	
}
