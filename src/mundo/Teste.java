package mundo;

import java.util.*;

public class Teste {

   public static void main(String[] args) {
    HashMap<String, Integer> lista = new HashMap<String,  Integer>();

    lista.put("Numero1", 2);
    int numero = lista.get("Numero1");
    System.out.println(numero);
   } 
}
