package banco;

import exceptions.EntradasErroneas;
import usuarios.Gerente;
import usuarios.Usuario;

/**
 * Classe responsável por realizar o login de um gerente no banco
 * @author vitoria and jederson
 *
 */
public class Login {
	
	/**
	 * Método que possibilita o acesso de um gerente
	 * @return
	 */
	public static boolean loginGerente () {
		System.out.println("+-----------------------+");
		System.out.println("|         Acesso        |");
		System.out.println("+-----------------------+");
		System.out.print("Login: ");
		String login = EntradasErroneas.scanner.nextLine().toString();
		System.out.println("Senha: ");
		String senha = EntradasErroneas.scanner.nextLine().toString();
		System.out.println("+-----------------------+");
		for (Usuario usuario : Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Método responsável por verificar se um login já existe
	 * @param login
	 * @param senha
	 * @return true, caso o login já exista e false, caso não exista.
	 */
	public static boolean verificaLogin (String login) {
		for (Usuario usuario : Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					return true;
				}
			}
		}
		return false;
	}
}
