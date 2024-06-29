package mundo;

import java.util.*;

public class Teste {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int xp = 42;
      int level = 0;

      
      if(xp >= (level + 1)*10){
         System.out.println("Foi");
         level =xp/10;
         System.out.println(level);
      }else{
         System.out.println("Nao foi");
      }

      //int att = 0;
      //do {
      //   System.out.println("Qual atributo você deseja aumentar? ");
      //   System.out.println("[1] Força");
      //   System.out.println("[2] Saude");
      //   att = sc.nextInt();
      //} while (att != 1 && att != 2);

      //if (att == 1) {
      //   forca += 0.3;
      //} else {
      //   if (att == 2) {
      //     saude += 0.3;
      //   }
      //}
   }
}
