package exceptions;

/**
 * Exceção para entrada de valores negativos
 * @author vitoria, Jederson, Acucena e Joao Victor
 */
public class NegativeValueException extends Exception {
	private static final long serialVersionUID = -4596000100030514801L;
	
	/**
	 * @param mensagem
	 */
	public NegativeValueException(String mensagem) {
		super(mensagem);
	}
}
