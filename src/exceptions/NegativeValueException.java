package exceptions;

public class NegativeValueException extends Exception {
	private static final long serialVersionUID = -4596000100030514801L;
	
	/**
	 * Exceção para entrada de valores negativos
	 * @param mensagem
	 */
	public NegativeValueException(String mensagem) {
		super(mensagem);
	}
}
