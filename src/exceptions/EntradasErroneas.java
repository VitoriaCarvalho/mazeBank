package exceptions;

import java.math.BigDecimal;
import java.util.Scanner;

public class EntradasErroneas {
	public static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt () {
		String valor;
		int valorFinal = 0;
		do {			
			valor = scanner.nextLine();
			try {				
				valorFinal = Integer.parseInt(valor);
				return valorFinal;
			} catch (Exception e) {
				System.err.println("Entrada Inválida!");
			}
		} while (true);
	}
	
	public static String inputBigDecimal() {
		String valor;
		BigDecimal valorFinal;
		do {			
			valor = scanner.nextLine();
			try {				
				valorFinal = new BigDecimal(valor);
				return valor;
			} catch (Exception e) {
				System.err.println("Entrada Inválida!");
			}
		} while (true);
	}
}
