package mundo;

import java.util.*;

public class Enemy extends Player {
    
    public Enemy(String nome, int level, int vida){
        super(nome,level, vida);
        vmax = vida;
    }

    public void setVida(int vida){
        this.vida=vida;
    }
    public int getVida(){
        return vida;
    }
    
    public void atacar(int d,Player n){
        System.out.printf("O %s está atacando e causou %d de dano \n", this.nome, d);
        System.out.println("------------------------------------------------\n"); 
        n.setVida(n.getVida()-d);
        if(n.getVida() < 0){
            n.setVida(0);
        }
    }
    public void reiniciar(){
        this.vida = vmax;  
    }
    
    @Override
    public String toString(){
        return "/////////////////\n" 
        + "O " + this.nome + 
        "\n ><> status de vida: "+ this.vida + " <><\n" + 
        "------------------------------------------------\n";
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
