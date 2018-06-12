import java.io.Console;

public class ConsoleDemo {

   public static void main(String[] args) {      
      Console cnsl = null;
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
   }
}