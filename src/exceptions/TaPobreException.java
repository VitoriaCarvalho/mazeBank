package exceptions;

public class TaPobreException extends Exception {
	private static final long serialVersionUID = -6615064593661377944L;

	/**
	 * Exceção para entradas de valores superiores ao saldo em conta
	 * @param mensagem
	 */
	public TaPobreException(String mensagem) {
		super(mensagem);
	}
}
