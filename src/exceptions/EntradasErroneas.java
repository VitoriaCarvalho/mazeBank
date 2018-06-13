package exceptions;

import java.math.BigDecimal;
import java.util.Scanner;

public class EntradasErroneas {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Método para validar entradas de números inteiros
	 * @return valor inteiro após a conversão
	 */
	public static int inputInt () {
		String valor;
		int valorFinal = 0;
		do {			
			valor = scanner.nextLine();
			try {				
				valorFinal = Integer.parseInt(valor);
				return valorFinal;
			} catch (Exception e) {
				System.err.println("Entrada Inválida. Digite novamente!");
			}
		} while (true);
	}
	
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
	 * Método para validar entrada de CPF ou RG
	 * @return valor Long caso a conversão tenha sido efetuada com sucesso
	 */
	public static String validaID(String message) {
		String valor;
		Long valorFinal;
		do {
			System.out.println(message);
			valor = scanner.next().toString();
			//valorFinal = valor;
			try {				
				valorFinal = Long.parseLong(valor);
				return valor;
			} catch (Exception e) {
				System.err.println("Número de identificação inválido. Digite novamente!");
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
				dataValida = scanner.next().toString();
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
	
	public static String validaNumeros() {
		String num;
		Long valor;
		
		do {
			try {
				num = scanner.next().toString();
				valor = Long.parseLong(num);
				return num;
			} catch (Exception e) {
				System.err.println("Telefone inválido. Digite novamente!");
			}
			
		} while (true);
	}
}
