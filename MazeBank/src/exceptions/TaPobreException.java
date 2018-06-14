package exceptions;

/**
 * Exceção para entradas de valores superiores ao saldo em conta
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class TaPobreException extends Exception {
	private static final long serialVersionUID = -6615064593661377944L;

	/**
	 * @param mensagem
	 */
	public TaPobreException(String mensagem) {
		super(mensagem);
	}
}
