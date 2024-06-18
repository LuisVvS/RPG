package mundo;

import java.util.*;

public class Teste {

   public static void main(String[] args) {
    
    Random rand = new Random();
    
    int fase=1;
    int vida = 10;
    
        List<Integer> numeros = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(5);
                add(10);
                add(3);
                add(8);
            }
        };

    do{
        int numero_aleatorio = numeros.get(rand.nextInt(numeros.size()));
        System.out.println(numero_aleatorio);
        vida -=1;
    }while(vida > 0);

   } 
}
