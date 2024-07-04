package mundo;

import java.util.*;

import java.io.*;

public class Enemy extends Player {
    
    protected int habilidade;
    public Enemy(String nome, int vida) {
        super(nome, vida);
        vmax = vida;
        habilidade=3;
    }
    //crio a string para deixar a cor vermelha
    public static final String ANSI_RED = "	\u001B[31m";
   //crio a string para resetar e deixar da cor padrão 
    public static final String ANSI_RESET = "\u001B[0m";

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }
    //recebo um dano e um player por paremetro
    public void atacar(int d, Player n) {
        System.out.printf("O %s está atacando e causou %d de dano \n", this.nome, d);
        //tiro a vida do player conforme o dano
        n.setVida(n.getVida() - d);
        //e caso a vida chege a negativo colo em zero
        if (n.getVida() < 0) {
            n.setVida(0);
        }
    }
    //coloco a vida do inimigo de novo no maximo e a habilidade tambem
    public void reiniciar() {
        this.vida = vmax;
        this.habilidade += 3;
    }

    @Override
    //status de vida e o nome do inimigo
    public String toString() {
        return "Inimigo: " + this.nome + " | Vida: " + this.vida;
    }

    @Override
    //mostro a tela de morte do inimigo com uma cor vermelha
    public String tela() {

        if (this.vida <= 0) {
            //coloco depois o ansi_red o que eu quero que fique vermelho
            //e depois do ansi reset tudo fica com cor normal, 
            //fazendo com que o vermelho so se aplique a palavra
            return "\n"
                    + ">>" + ANSI_RED + "O " + this.nome + " esta morto!" + ANSI_RESET;

        } else {
            return "";
        }
    }
    //habilidade do vampiro
    public boolean perk() {
        //caso o nome do monstro seja vampiro e a vida dele esteja abaixo de 50% eu retorno true 
        if (this.nome == "Vampiro" && this.vida < (this.vmax / 2)) {
            //se a habilidade for maior que ou igual a 1 eu retorno true
            if (this.habilidade >= 1) {
                return true;
            }
        }
        return false;
    }
}
