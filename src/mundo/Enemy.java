package mundo;

import java.util.*;

public class Enemy extends Player {
    
    public Enemy(String nome, int level, int vida){
        super(nome,level, vida );
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

    @Override
    public String tela(){
        if(this.vida <= 0){
            return"\n#####\n" 
                + "O " + this.nome + " esta morto!\n" + 
            "######";

        }else{
            return ""; 
        }
    }
}
