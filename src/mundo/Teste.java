package mundo;

import java.util.*;

public class Teste {

   public static void main(String[] args) {
      int opcao = 0;

      Scanner scan = new Scanner(System.in);
      do {
         System.out.println("Escolha entre dois ou um");
         opcao = scan.nextInt();
      } while (opcao != 1 && opcao != 2);

   }
}
