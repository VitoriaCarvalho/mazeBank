package exceptions;

/**
 * Exceção para situação em que o cliente tenta tranferir valores de uma conta para ela mesma
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class TransferenciaRecursivaException extends Exception {
	private static final long serialVersionUID = -1483421050972270741L;

	/**
	 * @param mensagem
	 */
	public TransferenciaRecursivaException(String mensagem) {
		super(mensagem);
	}
}
