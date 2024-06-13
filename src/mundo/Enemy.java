package mundo;

import java.util.*;

public class Enemy extends Player {
    
    public Enemy(String nome, int vida, int level, int dano){
        super(nome, vida, level, dano);
    }

    @Override
    public void ataque(Player int v){
        this.dano = this.dano -v;
    } 

}
