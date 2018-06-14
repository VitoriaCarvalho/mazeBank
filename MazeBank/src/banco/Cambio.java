package banco;

import java.math.BigDecimal;

import exceptions.EntradasErroneas;

/**
 * Classe criada para simular um sistema de câmbio de moedas. Ao receber um valor de uma das moedas presentes no menu, o sistema irá converter para real. No saque, o cliente pode optar por receber o valor convertido para uma das moedas das opções.
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class Cambio {

	
	public static String menuMoedas() {
		String op;
		System.out.println("+----------------------+");
		System.out.println("|         MOEDA        |");
		System.out.println("+----------------------+");
		System.out.println("| 1- Real              |");
		System.out.println("| 2- Dólar americano   |");
		System.out.println("| 3- Dólar canadense   |");
		System.out.println("| 4- Euro              |");
		System.out.println("| 5- Won Sul-coreano   |");
		System.out.println("+----------------------+");
		op = EntradasErroneas.validaNumeros();
		return op;
	}
	
	/**
	 * Esse método converte o valor da moeda escolhida para real.
	 * @param valor
	 * @return valor convertido para real
	 */
	public static BigDecimal converteParaReal(BigDecimal valor) {
		String opcao;
		do {
			opcao = menuMoedas();
			switch (opcao) {
			case "1":
				return valor;
			case "2":
				return valor.multiply(new BigDecimal("3.7"));
			case "3":
				return valor.multiply(new BigDecimal("2.85"));
			case "4":
				return valor.multiply(new BigDecimal("4.37"));
			case "5":
				return valor.multiply(new BigDecimal("0.003428"));
			default:
				System.err.println("Opção incorreta. Tente novamente!");
			}
		} while (Integer.parseInt(opcao) < 1 || Integer.parseInt(opcao) > 5);
		return valor;
	}
	
	/**
	 * Esse método converte o valor de real para a moeda escolhida.
	 * @param valor
	 * @return valor convertido para a moeda escolhida
	 */
	public static String converteDeReal(BigDecimal valor) {
		String opcao;
		do {
			opcao = menuMoedas();
			switch (opcao) {
			case "1":
				return "R$ " + valor.toString();
			case "2":
				return "U$ " + valor.divide(new BigDecimal("3.7"), BigDecimal.ROUND_UP).toString();
			case "3":
				return "C$ " + valor.divide(new BigDecimal("2.85"), BigDecimal.ROUND_UP);
			case "4":
				return "€ " + valor.divide(new BigDecimal("4.37"), BigDecimal.ROUND_UP);
			case "5":
				return "W " + valor.divide(new BigDecimal("0.003428"), BigDecimal.ROUND_UP);
			default:
				System.err.println("Opção incorreta. Tente novamente!");
			}
		} while (Integer.parseInt(opcao) < 1 || Integer.parseInt(opcao) > 5);
		return "R$ " + valor.toString();
	}
}
