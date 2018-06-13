package gerencia;

import exceptions.EntradasErroneas;
import usuarios.Endereco;
import usuarios.Usuario;

/**
 * @author vitoria
 *
 */
public class MenuGerente {
	static String opcao = null;
	public static void menuGerente() {
		
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
			case "0":
				
				break;
			default:
				break;
			}
		} while (!opcao.equals("0"));
	}

	

	
	
	public static Usuario cadastroUsuario () {
		String nome, cpf, rg, tel, dataNasc;
		
		System.out.println("Nome: ");
		nome = EntradasErroneas.scanner.nextLine().toString();
		
		cpf = EntradasErroneas.validaID("CPF com 11 números, sem caracteres de separação: ");
		
		rg = EntradasErroneas.validaID("RG, sem caracteres de separação: ");
		
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
