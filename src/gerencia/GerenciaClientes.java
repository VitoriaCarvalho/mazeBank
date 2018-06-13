package gerencia;

import java.math.BigDecimal;

import banco.Banco;
import contas.Conta;
import contas.ContaSalario;
import exceptions.EntradasErroneas;
import exceptions.NegativeValueException;
import usuarios.Cliente;
import usuarios.Endereco;
import usuarios.Usuario;

public class GerenciaClientes {
	public static void gerenciaClientes() {
		String opcao;
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
			opcao = EntradasErroneas.validaNumeros();
			
			switch (opcao) {
			case "1":
				cadastrarCliente();
				break;
			case  "2":
				removerCliente();
				break;
			case "3":
				atualizarCliente();
				break;
			case "4":
				buscarCliente();
				break;
			case "5":
				listarClientes();
				break;
			case "6":
				depositarEmContaSalario();
				break;
			default:
				System.out.println("Opção incorreta. Tente novamente!");
				break;
			}
		} while (!opcao.equals("0"));
	}
	
	/**
	 * Método para cadastrar clientes no mazeBank.
	 */
	public static void cadastrarCliente() {
		
		Usuario usuario = MenuGerente.cadastroUsuario();
		
		Cliente cliente =  new Cliente(usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getTelefone(), usuario.getDataNasc(), usuario.getEndereco(), EntradasErroneas.validaData("Data de entrada do mazeBank no formato dd/mm/aaaa: "));
		
		Banco.usuarios.add(cliente);
		
		System.out.println("Cliente cadastrado!");
	}
	
	/**
	 * Método para atualizar os dados de um cliente.
	 */
	public static void atualizarCliente() {
		
		System.out.println("CPF do cliente ao qual deseja atualizar os dados: ");
		String cpf = EntradasErroneas.scanner.nextLine().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				if (cliente.getCpf().equals(cpf)) {
					System.out.println("---------------------------------------------");
					System.out.println("------------ Alteração dos dados ------------");
					System.out.println("---------------------------------------------");
					System.out.println("\nCliente: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCpf());
					System.out.println("RG: " + cliente.getRg());
					System.out.println("Data de nascimento: " + cliente.getDataNasc());
					System.out.println("Data de entrada: " + cliente.getDataEntrada());
					System.out.println("---------------------------------------------");
					String op;
					
					System.out.println("Deseja alterar seu endereço? Digite 1 para sim ou outro número para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						
						Endereco end = new Endereco();
						System.out.println("Rua: ");
						end.setRua(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("Bairro: ");
						end.setBairro(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("Número: ");
						end.setNumero(EntradasErroneas.validaNumeros());
						System.out.println("Cidade: ");
						end.setCidade(EntradasErroneas.scanner.nextLine().toString());
						System.out.println("UF: ");
						end.setUf(EntradasErroneas.scanner.nextLine().toString());
						
						cliente.setEndereco(end);
					}
					
					System.out.println("Deseja alterar seu telefone? Digite 1 para sim ou 2 para não: ");
					op = EntradasErroneas.validaNumeros();
					if (op.equals("1")) {
						System.out.println("Novo telefone: ");
						cliente.setTelefone(EntradasErroneas.validaNumeros());
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
		String cpf = EntradasErroneas.scanner.nextLine().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				if (cliente.getCpf().equals(cpf)) {
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
		String cpf = EntradasErroneas.scanner.nextLine().toString();
		for (Usuario usuario: Banco.usuarios) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				if (cliente.getCpf().equals(cpf)) {
					for (Conta conta : Banco.contas) {
						if (conta.getTitular().equals(cliente)) {
							Banco.contas.remove(conta);
						}
					}
					Banco.usuarios.remove(cliente);
					return;
				}
			}
		}
		System.out.println("O login informado não pertence a nenhum cliente cadastrado no mazeBank!");
	}
	
	public static void depositarEmContaSalario() {
		System.out.println("Número da conta que deseja buscar: ");
		String num = EntradasErroneas.validaNumeros();
		System.out.println("Número da agência: ");
		String ag = EntradasErroneas.validaNumeros();
		
		for (Conta conta : Banco.contas) {
			if (conta.getNumConta().equals(num) && conta.getNumAgencia().equals(ag)) {
				if (conta instanceof ContaSalario) {
					ContaSalario cs = (ContaSalario) conta;
					do {
						System.out.println("Informe o valor a ser depositado: ");
						try {
							cs.deposita(new BigDecimal(EntradasErroneas.inputBigDecimal()));
							break;
						} catch (NegativeValueException e) {
							System.err.println(e.getMessage());
						}
					} while (true);
					return;
				}
			}
		}
		
		System.out.println("Conta inexistente!");
	}
}