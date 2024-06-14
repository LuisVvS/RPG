package mundo;

import java.util.*;
public class Jogo {
    public static void main(String[] args) {
        

        Player p = new Player("Luis", 0, 20);
        Enemy e = new Enemy("Ogro", 100, 100);
        Inventario v = new Inventario(2);
        Random rand = new Random();

        //criando a array que vai armazenar as armas do jogo
        List<Armas> armas  = new ArrayList<Armas>();     
        //adicionando armas pro jogo armas.add(new Armas("Espada de madeira", 10));
        armas.add(new Armas("Adaga", 20)); 
        armas.add(new Armas("Arco", 15)); 
        armas.add(new Armas("Lança", 30));
        armas.add(new Armas("Espada Obisidian", 50));  

        do{
            System.out.println(p.toString());
            System.out.println(e.toString());       
    
            e.atacar(rand.nextInt(10), p);
            p.curar(v);
            p.ataque(rand.nextInt(10), e);

        }while(p.vida !=0 || e.vida!=0);

        System.out.println(p.toString());
        System.out.println(e.toString());
        
        v.Acessar();
    }    
}
// definir um jeito de aparecer que o usuario morreu quando a vida dos dois (player e inimigos chegarem ao fim)
//definir um menu de opções de atacar e se curar
//focar no pvp por enquanto, depois vamos implementar outras features