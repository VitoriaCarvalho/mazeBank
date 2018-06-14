/**
 * 
 */
package serializacao;

import java.io.*;
import java.util.ArrayList;

import banco.Banco;

/**
 * Classe responsável pelo salvamento e recuperação dos dados no banco armazenados
 * @author vitoria, Jederson, Acucena e Joao Victor
 *
 */
public class Serializacao {
	
	/**
	 * Método que efetua serialização das listas de contas e usuários do banco
	 */
	public static void serializar () {
		
		try {
			FileOutputStream cfos = new FileOutputStream("contas.mz");
			FileOutputStream ufos = new FileOutputStream("usuarios.mz");
			
			ObjectOutputStream coos = new ObjectOutputStream(cfos);
			ObjectOutputStream uoos = new ObjectOutputStream(ufos);
			
			coos.writeObject(Banco.contas);
			uoos.writeObject(Banco.usuarios);
			
			coos.close();
			uoos.close();
			
			cfos.close();
			ufos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Método que efetua deserialização das listas de contas e usuários do banco
	 */
	public static void deserializar () {
		try {
			FileInputStream cfis = new FileInputStream("contas.mz");
			FileInputStream ufis = new FileInputStream("usuarios.mz");
			
			ObjectInputStream cois = new ObjectInputStream(cfis);
			ObjectInputStream uois = new ObjectInputStream(ufis);
			
			Banco.contas = (ArrayList) cois.readObject();
			Banco.usuarios = (ArrayList) uois.readObject();
			
			cfis.close();
			ufis.close();
			
			cois.close();
			uois.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
            c.printStackTrace();
            return;
		}
	}
}
