package banco;

import java.math.BigDecimal;

import exceptions.EntradasErroneas;
import usuarios.Endereco;
import usuarios.Gerente;
import usuarios.Usuario;

/**
 * @author vitoria
 *
 */
public class MenuGerente {
	static int opcao = 0;
	public static void menuGerente() {
		
		do {
			System.out.println("+------------------------+");
			System.out.println("|         Gerência       |");
			System.out.println("+------------------------+");
			System.out.println("| 1 - Gerenciar clientes |");
			System.out.println("| 2 - Gerenciar gerentes |");
			System.out.println("| 0 - Sair               |");
			System.out.println("+------------------------+");
			opcao = EntradasErroneas.inputInt();
			
			switch (opcao) {
			case 1:
				gerenciaClientes();
				break;
			case 2:
				gerenciaGerentes();
				break;
			case 0:
				
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}

	private static void gerenciaGerentes() {
		do {
			System.out.println("+------------------------+");
			System.out.println("|         Gerência       |");
			System.out.println("+------------------------+");
			System.out.println("| 1 - Cadastrar gerente  |");
			System.out.println("| 2 - Remover gerente    |");
			System.out.println("| 3 - Atualizar gerente  |");
			System.out.println("| 4 - Buscar gerente     |");
			System.out.println("| 5 - Listar gerente     |");
			System.out.println("| 0 - Sair               |");
			System.out.println("+------------------------+");
			opcao = EntradasErroneas.inputInt();
			
			switch (opcao) {
			case 1:
				cadastrarGerente ();
				break;
			case  2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 0:
				
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}

	private static void gerenciaClientes() {
		do {
			System.out.println("+--------------------------------+");
			System.out.println("|      Gerência de clientes      |");
			System.out.println("+--------------------------------+");
			System.out.println("| 1 - Cadastrar cliente          |");
			System.out.println("| 2 - Remover cliente            |");
			System.out.println("| 3 - Atualizar cliente          |");
			System.out.println("| 4 - Buscar cliente             |");
			System.out.println("| 5 - Listar cliente             |");
			System.out.println("| 6 - Depositar em conta salário |");
			System.out.println("| 0 - Sair                       |");
			System.out.println("+--------------------------------+");
			opcao = EntradasErroneas.inputInt();
			
			switch (opcao) {
			case 1:
				
				break;
			case  2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 0:
				
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}
	
	public static Usuario cadastroUsuario () {
		String nome;
		int cpf, rg;
		
		System.out.println("Nome: ");
		nome = EntradasErroneas.scanner.next().toString();
		
		System.out.println("CPF: ");
		cpf = EntradasErroneas.scanner.nextInt();
		
		System.out.println("RG: ");
		rg = EntradasErroneas.scanner.nextInt();
		
		Endereco end = new Endereco(); 
	
		System.out.println("Rua: ");
		end.setRua(EntradasErroneas.scanner.next().toString());
		
		System.out.println("Bairro: ");
		end.setBairro(EntradasErroneas.scanner.next().toString());
		
		System.out.println("Número: ");
		end.setNumero(EntradasErroneas.scanner.nextInt());
		
		System.out.println("Cidade: ");
		end.setCidade(EntradasErroneas.scanner.next().toString());
		
		System.out.println("UF: ");
		end.setUf(EntradasErroneas.scanner.next().toString());
		
		return new Usuario(nome, cpf, rg, end);
	}
		
	public static void cadastrarGerente() {
		String login, senha;
		
		do {
			System.out.println("Login: ");
			login = EntradasErroneas.scanner.next().toString();
			if (!Login.verificaLogin(login)) break;
		} while (true);
		
		System.out.println("Senha: ");
		senha = EntradasErroneas.scanner.next().toString();
		
		System.out.println("Salário: ");
		BigDecimal salario = new BigDecimal(EntradasErroneas.inputBigDecimal());
		
		Usuario usuario = cadastroUsuario();
		
		Gerente gerente =  new Gerente(usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getEndereco(), salario, login, senha);
		
		Banco.usuarios.add(gerente);
		
		System.out.println("Gerente cadastrado!");
	}

	public static void removerGerente() {
		System.out.println("Login do membro a ser removido: ");
		String login = EntradasErroneas.scanner.next().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					Banco.usuarios.remove(gerente);
					return;
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");
	}

	/**
	 * Fazer menu de dados a serem alterados
	 */
	public static void alterarGerente() {
		System.out.println("Login do membro que deseja alterar os dados: ");
		String login = EntradasErroneas.scanner.next().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					Banco.usuarios.remove(gerente);
					return;
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");	
	}
	
	/**
	 * usar toString de usuário
	 */
	public static void buscarGerente () {
		System.out.println("Login do membro que deseja buscar os dados: ");
		String login = EntradasErroneas.scanner.next().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					Banco.usuarios.remove(gerente);
					return;
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");
	}
}
