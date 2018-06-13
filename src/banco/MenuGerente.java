package banco;

import java.math.BigDecimal;
import java.util.Date;

import contas.Conta;
import contas.ContaSalario;
import exceptions.EntradasErroneas;
import usuarios.Cliente;
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
			System.out.println("|  Gerência de gerentes  |");
			System.out.println("+------------------------+");
			System.out.println("| 1 - Cadastrar gerente  |");
			System.out.println("| 2 - Remover gerente    |");
			System.out.println("| 3 - Atualizar gerente  |");
			System.out.println("| 4 - Buscar gerente     |");
			System.out.println("| 5 - Listar gerentes    |");
			System.out.println("| 0 - Sair               |");
			System.out.println("+------------------------+");
			opcao = EntradasErroneas.inputInt();
			
			switch (opcao) {
			case 1:
				cadastrarGerente ();
				break;
			case  2:
				removerGerente();
				break;
			case 3:
				atualizarGerente();
				break;
			case 4:
				buscarGerente();
				break;
			case 5:
				listarGerentes();
				break;
			default:
				System.err.println("Opção incorreta. Tente novamente!");
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
				cadastrarCliente();
				break;
			case  2:
				removerCliente();
				break;
			case 3:
				atualizarCliente();
				break;
			case 4:
				buscarCliente();
				break;
			case 5:
				listarClientes();
				break;
			case 6:
				depositarEmContaSalario();
				break;
			default:
				System.out.println("Opção incorreta. Tente novamente!");
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

	/**
	 * Método para remover um gerente cadastrado, exceto o administrador.
	 */
	public static void removerGerente() {
		System.out.println("Login do membro a ser removido: ");
		String login = EntradasErroneas.scanner.next().toString();
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
			System.err.println("Você não pode remover o administrador !!!");
		}
		System.out.println("O login informado não pertence a nenhum gerente cadastrado no mazeBank!");
	}

	/**
	 * Método para atualizar os dados do gerente.
	 */
	public static void atualizarGerente() {
		System.out.println("Login do membro que deseja alterar os dados: ");
		String login = EntradasErroneas.scanner.next().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					System.out.println("---------------------------------------------");
					System.out.println("------------ Alteração dos dados ------------");
					System.out.println("---------------------------------------------");
					System.out.println("\nGerente: " + gerente.getNome() + "\n");
					System.out.println("CPF: " + gerente.getCpf() + "\n");
					System.out.println("RG: " + gerente.getRg() + "\n");
					System.out.println("---------------------------------------------");
					int op;
					
					System.out.println("Deseja alterar seu endereço? Digite 1 para sim ou 2 para não: ");
					op = EntradasErroneas.inputInt();
					if (op == 1) {
						
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
						end.setBairro(EntradasErroneas.scanner.next().toString());
						
						gerente.setEndereco(end);
					}
					
					System.out.println("Deseja alterar seu salário? Digite 1 para sim ou 2 para não: ");
					op = EntradasErroneas.inputInt();
					if (op == 1) {
						System.out.println("Novo salário: ");
						String salario = EntradasErroneas.scanner.next().toString();
						gerente.setSalario(new BigDecimal(EntradasErroneas.inputBigDecimal()));
					}
					
					System.out.println("Deseja alterar seu login? Digite 1 para sim ou 2 para não: ");
					op = EntradasErroneas.inputInt();
					if (op == 1) {
						String l;
						do {
							System.out.println("Novo login: ");
							l = EntradasErroneas.scanner.next().toString();
							if (!Login.verificaLogin(l)) break;
							System.err.println("\nLogin existente!\n");
						} while (true);
						
						gerente.setLogin(l);
					}
					
					System.out.println("Deseja alterar sua senha? Digite 1 para sim ou 2 para não: ");
					op = EntradasErroneas.inputInt();
					if (op == 1) {
						System.out.println("Senha: ");
						gerente.setSenha(EntradasErroneas.scanner.next().toString());
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
		String login = EntradasErroneas.scanner.next().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				if (gerente.getLogin().equals(login)) {
					gerente.toString();
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
		System.out.println("\n+----------------------------------------------+");
		System.out.println("|             GERENTES CADASTRADOS             |");
		System.out.println("+----------------------------------------------+");
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				System.out.println("Login: " + gerente.getLogin());
				System.out.println(gerente.toString());
				System.out.println("Salário: R$ " + gerente.getSalario());
			}
		}
		System.out.println("+----------------------------------------------+\n");
	}

	/**
	 * Método para cadastrar clientes no mazeBank.
	 */
	public static void cadastrarCliente() {
		
		Usuario usuario = cadastroUsuario();
		System.out.println("Data de entrada");
		Integer[] datas = new Integer[3];
		System.out.println("Dia: ");
		datas[0] = EntradasErroneas.inputInt();
		System.out.println("Mês: ");
		datas[1] = EntradasErroneas.inputInt();
		System.out.println("Ano: ");
		datas[2] = EntradasErroneas.inputInt();
		Date d = new Date(datas[2], datas[1], datas[0]);
		
		Cliente cliente =  new Cliente(usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getEndereco(), d);
		
		Banco.usuarios.add(cliente);
		
		System.out.println("Cliente cadastrado!");
	}
	
	/**
	 * Método para atualizar os dados de um cliente.
	 */
	public static void atualizarCliente() {
		
		System.out.println("CPF do cliente ao qual deseja atualizar os dados: ");
		int cpf = EntradasErroneas.scanner.nextInt();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				if (cliente.getCpf() == cpf) {
					System.out.println("---------------------------------------------");
					System.out.println("------------ Alteração dos dados ------------");
					System.out.println("---------------------------------------------");
					System.out.println("\nCliente: " + cliente.getNome() + "\n");
					System.out.println("CPF: " + cliente.getCpf() + "\n");
					System.out.println("RG: " + cliente.getRg() + "\n");
					System.out.println("Data de entrada: " + cliente.getDataEntrada());
					System.out.println("---------------------------------------------");
					int op;
					
					System.out.println("Deseja alterar seu endereço? Digite 1 para sim ou outro número para não: ");
					op = EntradasErroneas.inputInt();
					if (op == 1) {
						
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
						end.setBairro(EntradasErroneas.scanner.next().toString());
						
						cliente.setEndereco(end);
					}
					
					System.out.println("------------ DADOS ATUALIZADOS ------------\n");
				}
			}
		}
		System.out.println("O CPF informado não pertence a nenhum cliente cadastrado no mazeBank!");
	}
	
	/**
	 * Método para buscar um dado cliente cadastrado e mostrar suas informações.
	 */
	public static void buscarCliente() {
		System.out.println("CPF do cliente que deseja obter informações: ");
		int cpf = EntradasErroneas.scanner.nextInt();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				if (cliente.getCpf() == cpf) {
					cliente.toString();
					return;
				}
			}
		}
		System.out.println("O CPF informado não pertence a nenhum cliente cadastrado no mazeBank!");
	}
	
	/**
	 * Método para mostrar todos os clientes cadastrados no sistema.
	 */
	public static void listarClientes() {
		System.out.println("\n+----------------------------------------------+");
		System.out.println("|             CLIENTES CADASTRADOS             |");
		System.out.println("+----------------------------------------------+");
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				System.out.println(cliente.toString());
				System.out.println("Data de entrada: " + cliente.getDataEntrada());
			}
		}
		System.out.println("+----------------------------------------------+\n");
	}
	
	/**
	 * Método para remover um cliente cadastrado no sistema.
	 */
	public static void removerCliente() {
		System.out.println("CPF do cliente a ser removido: ");
		int cpf = EntradasErroneas.scanner.nextInt();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				if (cliente.getCpf() == cpf) {
					Banco.usuarios.remove(cliente);
					return;
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum cliente cadastrado no mazeBank!");
	}
	
	public static void depositarEmContaSalario() {}
}
