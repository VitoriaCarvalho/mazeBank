package gerencia;

import java.math.BigDecimal;

import banco.Banco;
import banco.Login;
import exceptions.EntradasErroneas;
import usuarios.Cliente;
import usuarios.Endereco;
import usuarios.Gerente;
import usuarios.Usuario;

/**
 * Classe responsável por realizar as funções de gerenciamento de gerentes no sistema.
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class GerenciaGerentes {
	
	/**
	 * Método que faz a interação entre o gerente logado no sistema e as funções de gerenciamento de gerentes.
	 */
	public static void gerenciaGerentes() {
		String opcao;
		do {
			System.out.println("+------------------------+");
			System.out.println("|  Gerência de gerentes  |");
			System.out.println("+------------------------+");
			System.out.println("| 1 - Cadastrar gerente  |");
			System.out.println("| 2 - Remover gerente    |");
			System.out.println("| 3 - Atualizar gerente  |");
			System.out.println("| 4 - Buscar gerente     |");
			System.out.println("| 5 - Listar gerentes    |");
			System.out.println("| 0 - Sair               |");
			System.out.println("+------------------------+");
			opcao = EntradasErroneas.validaNumeros();
			
			switch (opcao) {
			case "1":
				cadastrarGerente ();
				break;
			case  "2":
				removerGerente();
				break;
			case "3":
				atualizarGerente();
				break;
			case "4":
				buscarGerente();
				break;
			case "5":
				listarGerentes();
				break;
			case "0":
				break;
			default:
				System.err.println("Opção incorreta. Tente novamente!");
				break;
			}
		} while (!opcao.equals("0"));
	}
	
	/**
	 * Método responsável por realizar o cadastro de um gerente no sistema.
	 */
	public static void cadastrarGerente() {
		String login, senha;
		
		do {
			System.out.println("Login: ");
			login = EntradasErroneas.scanner.nextLine().toString();
			if (!Login.verificaLogin(login)) {
				break;
			} else {
				System.err.println("\n\nO login informado já existe!\n\n");
			}
		} while (true);
		
		System.out.println("Senha: ");
		senha = EntradasErroneas.scanner.nextLine().toString();
		
		System.out.println("Salário: ");
		BigDecimal salario = new BigDecimal(EntradasErroneas.inputBigDecimal());
		
		Usuario usuario = MenuGerente.cadastroUsuario("gerente");
		
		if (!EntradasErroneas.verificaMaiorIdade(usuario.getDataNasc())) {
			System.err.println("\n\nUsuário menor de idade!\nPara possuir cadastro o gerente precisa ter 18 anos ou mais.\n\n");
			return;
		}
		
		Gerente gerente =  new Gerente(usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getTelefone(), usuario.getDataNasc(), usuario.getEndereco(), salario, login, senha);
		
		Banco.usuarios.add(gerente);
		
		System.out.println("Gerente cadastrado!");
	}

	/**
	 * Método para remover um gerente cadastrado, exceto o administrador.
	 */
	public static void removerGerente() {
		System.out.println("Login do membro a ser removido: ");
		String login = EntradasErroneas.scanner.nextLine().toString();
		if (!login.equals("master")) {			
			for (Usuario usuario: Banco.usuarios) {
				if (usuario instanceof Gerente) {
					Gerente gerente = (Gerente) usuario;
					if (gerente.getLogin().equals(login)) {
						Banco.usuarios.remove(gerente);
						return;
					}
				}
			}
		} else if(login.equals("master")) {
			System.err.println("\nVocê não pode remover o administrador !!!\n\n");
			return;
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");
	}

	/**
	 * Método para atualizar os dados do gerente.
	 */
	public static void atualizarGerente() {
		System.out.println("Login do membro que deseja alterar os dados: ");
		String login = EntradasErroneas.scanner.nextLine().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					System.out.println("---------------------------------------------");
					System.out.println("------------ Alteração dos dados ------------");
					System.out.println("---------------------------------------------");
					System.out.println("\nGerente: " + gerente.getNome());
					System.out.println("CPF: " + gerente.getCpf());
					System.out.println("RG: " + gerente.getRg());
					System.out.println("Data de nascimento: " + gerente.getDataNasc());
					System.out.println("---------------------------------------------");
					String op;
					
					System.out.println("Deseja alterar seu endereço? Digite 1 para sim ou qualquer outro número para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						
						Endereco end = new Endereco();
						System.out.println("Rua: ");
						end.setRua(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("Bairro: ");
						end.setBairro(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("Número: ");
						end.setNumero(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("Cidade: ");
						end.setCidade(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("UF: ");
						end.setBairro(EntradasErroneas.scanner.nextLine().toString());
						
						gerente.setEndereco(end);
					}
					
					System.out.println("Deseja alterar seu salário? Digite 1 para sim ou qualquer outro número para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						System.out.println("Novo salário: ");
						gerente.setSalario(new BigDecimal(EntradasErroneas.inputBigDecimal()));
					}
					
					System.out.println("Deseja alterar seu telefone? Digite 1 para sim ou qualquer outro número para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						System.out.println("Novo telefone: ");
						gerente.setTelefone(EntradasErroneas.validaNumeros());
					}
					
					System.out.println("Deseja alterar seu login? Digite 1 para sim ou qualquer outro número para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						String l;
						do {
							System.out.println("Novo login: ");
							l = EntradasErroneas.scanner.nextLine().toString();
							if (!Login.verificaLogin(l)) break;
							System.err.println("\nLogin existente!\n");
						} while (true);
						
						gerente.setLogin(l);
					}
					
					System.out.println("Deseja alterar sua senha? Digite 1 para sim ou qualquer outro número para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						System.out.println("Senha: ");
						gerente.setSenha(EntradasErroneas.scanner.nextLine().toString());
					}
					
					System.out.println("------------ DADOS ATUALIZADOS ------------\n");
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");	
	}
	
	/**
	 * Método para buscar um dado gerente e mostrar os dados, caso ele exista na lista de gerentes.
	 */
	public static void buscarGerente () {
		System.out.println("Login do gerente que deseja obter informações: ");
		String login = EntradasErroneas.scanner.nextLine().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					System.out.println(gerente.toString());
					return;
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");
	}

	/**
	 * Método para listar todos os gerentes cadastrados no mazeBank.
	 */
	public static void listarGerentes() {
		System.out.println("\n+------------------------------------------------------+");
		System.out.println("|                  GERENTES CADASTRADOS                |");
		System.out.println("+------------------------------------------------------+");
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (!gerente.getLogin().equals("master")) {					
					System.out.println(gerente.toString());
					System.out.println("Login: " + gerente.getLogin());
					System.out.println(gerente.toString());
					System.out.println("Salário: R$ " + gerente.getSalario());
				} 
			}
		}
		System.out.println("+------------------------------------------------------+");
	}
}
