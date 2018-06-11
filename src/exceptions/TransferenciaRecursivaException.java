package exceptions;

public class TransferenciaRecursivaException extends Exception {
	private static final long serialVersionUID = -1483421050972270741L;

	/**
	 * Exceção para situação em que o cliente tenta tranferir valores de uma conta para ela mesma 
	 * @param mensagem
	 */
	public TransferenciaRecursivaException(String mensagem) {
		super(mensagem);
	}
}
