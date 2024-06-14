package mundo;

import java.util.*;

public class Enemy extends Player {
    
    public Enemy(String nome, int level, int vida){
        super(nome, vida, level );
    }

    public String toString(){
        return "\nO inimigo: "+ this.nome + " vida: " + this.vida;
    }

    public void setVida(int vida){
        this.vida=vida;
    }
    public int getVida(){
        return vida;
    }
    
    public void atacar(int d,Player n){
        System.out.printf("O %s está atacando e causou %d de dano \n", this.nome, d);

        n.setVida(n.getVida()-d);
    }
}
