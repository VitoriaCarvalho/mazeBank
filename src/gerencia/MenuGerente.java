package gerencia;

import banco.Banco;
import exceptions.EntradasErroneas;
import usuarios.Cliente;
import usuarios.Endereco;
import usuarios.Gerente;
import usuarios.Usuario;


/**
 * Classe responsável por fazer a interação entre o gerente logado no sistema e as ações de gerência.
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class MenuGerente {
	
	/**
	 * Menu principal das funções de gerência, é ele que utiliza os métodos das classes de gerência de clientes, de gerentes e de contas.
	 */
	public static void menuGerente() {		
		String opcao;
		do {
			System.out.println("+------------------------+");
			System.out.println("|        Gerência        |");
			System.out.println("+------------------------+");
			System.out.println("| 1 - Gerenciar clientes |");
			System.out.println("| 2 - Gerenciar gerentes |");
			System.out.println("| 3 - Criar contas       |");
			System.out.println("| 0 - Sair               |");
			System.out.println("+------------------------+");
			opcao = EntradasErroneas.validaNumeros();
			
			switch (opcao) {
			case "1":
				GerenciaClientes.gerenciaClientes();
				break;
			case "2":
				GerenciaGerentes.gerenciaGerentes();
				break;
			case "3":
				GerenciaContas.gerenciaContas();
				break;
			case "0":
				
				break;
			default:
				break;
			}
		} while (!opcao.equals("0"));
	}

	

	
	/**
	 * Método responsável por cadastrar um usuário, seja ele cliente ou gerente.
	 * @param tipo de conta a ser gerada
	 * @return Objeto do tipo Usuario
	 */
	public static Usuario cadastroUsuario (String tipo) {
		String nome, cpf, rg, tel, dataNasc;
		
		System.out.println("Nome: ");
		nome = EntradasErroneas.scanner.nextLine().toString();
		

		int flag;
		do {
			cpf = EntradasErroneas.validaCPF("CPF com 11 números, sem caracteres de separação: ");
			
			flag = 0;
			for (Usuario user : Banco.usuarios) {
				if (user.getCpf().equals(cpf)) {
					if (tipo.equals("cliente")) {
						if (user instanceof Cliente) {
							System.out.println("\nEste CPF já percetence a um " + tipo + " cadastrado no banco!\n");
							flag = 1;
							break;
						}
					} else if (tipo.equals("gerente")) {
						if (user instanceof Gerente) {
							System.out.println("\nEste CPF já percetence a um " + tipo + " cadastrado no banco!\n");
							flag = 1;
							break;
						}
					}
				}
			}
		} while (flag == 1);
		
		
		do {
			rg = EntradasErroneas.validaRG("RG, sem caracteres de separação: ");
			
			flag = 0;
			for (Usuario user : Banco.usuarios) {
				if (user.getRg().equals(rg)) {
					if (tipo.equals("cliente")) {
						if (user instanceof Cliente) {
							System.out.println("\nEste RG já percetence a um " + tipo + " cadastrado no banco!\n");
							flag = 1;
							break;
						}
					} else if (tipo.equals("gerente")) {
						if (user instanceof Gerente) {
							System.out.println("\nEste RG já percetence a um " + tipo + " cadastrado no banco!\n");
							flag = 1;
							break;
						}
					}
				} 
			}
		} while (flag == 1);
		
		dataNasc = EntradasErroneas.validaData("Informe a data de nascimento no formato dd/mm/aaaa: ");
		
		Endereco end = new Endereco(); 
		
		System.out.println("Telefone: ");
		tel = EntradasErroneas.validaNumeros();
		
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
		
		return new Usuario(nome, cpf, rg, tel, dataNasc, end);
	}
}
