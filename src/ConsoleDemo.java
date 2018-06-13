import java.io.Console;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

import exceptions.EntradasErroneas;

public class ConsoleDemo {

   public static void main(String[] args) {      
      /*Console cnsl = null;
      String alpha = null;
      
      try {
      
         // creates a console object
         cnsl = System.console();

         // if console is not null
         if (cnsl != null) {
            
            // read line from the user input
            alpha = cnsl.readLine("Name: ");
            
            // prints
            System.out.println("Name is: " + alpha);
            
            // read password into the char array
            char[] pwd = cnsl.readPassword("Password: ");
            
            StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Password is: ");
			stringBuilder.append(pwd);
			// prints
            System.out.println(stringBuilder.toString());
         } else {
        	 System.out.println("Não foi possível instanciar um terminal");
         }
         
      } catch(Exception ex) {
         
         // if any error occurs
         ex.printStackTrace();  
      }
   }*/
	   
	   //String cpf;
	   
	   /*do {
		   try {
			   System.out.println("Informe o cpf: ");
			   cpf = EntradasErroneas.scanner.next().toString();   
			   if (cpf.length() == 11) {
				   Long.parseLong(cpf);
				   //Integer.parseInt(cpf);
				   System.out.println("CPF válido!");
				   return;
			   }
		   } catch(Exception e) {
			   System.out.println("CPF inválido!");
		   }
	   } while (true);*/
	   
	   do {
		   try {
			   System.out.println("Informe o CPF: ");
			   Long cpf = EntradasErroneas.scanner.nextLong();
			   if (validaCpf(cpf)) {
				   System.out.println("CPF válido!");
				   return;
			   }
		   } catch (Exception e) {
			   System.err.println("\nCPF inválido!\n");
		   }
		   
	   } while (true);
	   
   }
   
   public static boolean validaCpf(Long cpf) {
	   
	   Long x = cpf;
	   Integer[] c = new Integer[11];
	   int cont = 10, soma1 = 0, soma2 = 0;
	   double resto1, resto2;
	   
	   while (x > 0) {
		c[cont] = (int) (x%10);
		x = x/10;
		cont--;
	   }
	   
	   if (invalidosConhecidos(c)) return false;
	   
	   int aux = 10;
	   
	   for (int i = 0; i < 9; i++) {
		   soma1 += c[i]*aux;
		   aux--;
	   }
	   resto1 = (soma1*10)%11;
	   if (resto1 == 10) resto1 = 0;
	   
	   aux = 11;
	   for (int i = 0; i < 10; i++) {
		   soma2 += c[i]*aux;
		   aux--;
	   }
	   resto2 = (soma2*10)%11;
	   if (resto1 == 10) resto1 = 0;
	   
	   if (resto1 == c[9] && resto2 == c[10]) return true;
	   return false;
   }
   
   public static boolean invalidosConhecidos(Integer[] c) {
	   //if (c[0] == c[1] && c[1] == c[2] && c[2] == c[3]] && c[3] == c[4] && c[4] == c[5] && c[5] == c[6] && c[6] == c[7] && c[7] == c[8] && c[8] == c[9] && c[0] == c[1] && )
	   int cont=0;
	   for (int i = 0; i < c.length; i++) {
		   if (c[i] == c[0]) cont++;
	   }
	   if (cont == c.length) return true;
	   return false;
   }
}