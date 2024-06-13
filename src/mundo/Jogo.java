package mundo;

import java.util.*;

public class Jogo {
    public static void main(String[] args) {
        
        Player p = new Player("Luis", 0, 20);
        Enemy e = new Enemy("Ogro", 100, 100);
        //criando a array que vai armazenar as armas do jogo
        List<Armas> armas  = new ArrayList<Armas>();     
        //adicionando armas pro jogo
        armas.add(new Armas("Espada de madeira", 10));
        armas.add(new Armas("Adaga", 20)); 
        armas.add(new Armas("Arco", 15)); 
        armas.add(new Armas("Lança", 30));
        armas.add(new Armas("Espada Obisidian", 50));



        System.out.println(p.toString());
        System.out.println(e.toString());       
        
        e.atacar(10, p);
        p.curar(5);

        System.out.println(p.toString());
        System.out.println(e.toString());

        Inventario v = new Inventario(armas.get(0), 2);
        v.mostra();
    }    
}
