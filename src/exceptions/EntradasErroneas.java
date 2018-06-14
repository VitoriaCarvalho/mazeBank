package exceptions;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Essa classe contém métodos para tratamento de entradas errôneas.
 * @author vitoria and Jederson
 *
 */
public class EntradasErroneas {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Método para validar entradas de objetos BigDecimal
	 * @return valor em BigDecimal, após a instância ser feita com sucesso
	 */
	public static String inputBigDecimal() {
		String valor;
		BigDecimal valorFinal;
		do {			
			valor = scanner.nextLine();
			try {				
				valorFinal = new BigDecimal(valor);
				return valor;
			} catch (Exception e) {
				System.err.println("Entrada Inválida. Digite novamente!");
			}
		} while (true);
	}
	
	/**
	 * Método para validar entrada de RG
	 * @return valor Long caso a conversão tenha sido efetuada com sucesso
	 * @param message
	 */
	public static String validaRG(String message) {
		String valor;
		Long valorFinal;
		do {
			System.out.println(message);
			valor = scanner.nextLine().toString();
			//valorFinal = valor;
			try {				
				valorFinal = Long.parseLong(valor);
				return valor;
			} catch (Exception e) {
				System.err.println("\nNúmero de identificação inválido. Digite novamente!\n");
			}
		} while (true);
	}
	
	/**
	 * Método para validar entrada de CPF
	 * @return valor Long caso a conversão tenha sido efetuada com sucesso
	 * @param message
	 */
	public static String validaCPF(String message) {
		String valor;
		Long valorFinal;
		do {
			System.out.println(message);
			valor = scanner.nextLine().toString();
			//valorFinal = valor;
			try {
				if (valor.length() == 11) {
					valorFinal = Long.parseLong(valor);
					return valor;
				} else {
					System.err.println("\nNúmero de identificação inválido. Digite novamente!\n");
				}
			} catch (Exception e) {
				System.err.println("\nNúmero de identificação inválido. Digite novamente!\n");
			}
		} while (true);
	}
	
	/**
	 * Método para validar datas no formato dd/mm/aaaa
	 * @return Uma string contendo a data válida
	 */
	public static String validaData(String message) {
		String[] data;
		String dataValida;
		int dia, mes, ano;
		
		do {
			try {
				System.out.println(message);
				dataValida = scanner.nextLine().toString();
				data = dataValida.split("/");
				
				dia = Integer.parseInt(data[0]);
				mes = Integer.parseInt(data[1]);
				ano = Integer.parseInt(data[2]);
				
				if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900 && ano <= 2018) {
					return dataValida;
				} else {
					System.err.println("\nData inválida. Tente novamente!\n");
					continue;
				}
			} catch (Exception e) {
				System.err.println("\nData inválida. Tente novamente!\n");
			}
		} while (true);
		
	}
	
	/**
	 * Método permite verificar, através da data de nascimento passada por parâmetro, se o usuário é ou não maior de idade, garantindo que ele só poderá realizar o cadastro se possuir mais de 18 anos de idade.
	 * @param data
	 * @return true se o resultado for maior ou igual a 18, e false se for menor.
	 */
	public static boolean verificaMaiorIdade(String data) {
		String[] dataNasc;
		int ano;
		
		dataNasc = data.split("/");
		ano = Integer.parseInt(dataNasc[2]);
		
		if ((2018 - ano) >= 18) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método para validar entradas de Strings que representam números inteiros
	 * @return String com o número da entrada
	 */
	public static String validaNumeros() {
		String num;
		Long valor;
		
		do {
			try {
				num = scanner.nextLine().toString();
				valor = Long.parseLong(num);
				return num;
			} catch (Exception e) {
				System.err.println("\nEntrada inválida. Digite novamente!\n");
			}
			
		} while (true);
	}
}
