package mundo;

import java.util.*;
import java.io.*;

public class Enemy extends Player {

    public Enemy(String nome, int level, int vida) {
        super(nome, level, vida);
        vmax = vida;
    }

    public static final String ANSI_RED = "	\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void atacar(int d, Player n) {
        System.out.printf("O %s está atacando e causou %d de dano \n", this.nome, d);
        System.out.println("------------------------------------------------\n");
        n.setVida(n.getVida() - d);
        if (n.getVida() < 0) {
            n.setVida(0);
        }
    }

    public void reiniciar() {
        this.vida = vmax;
    }

    @Override
    public String toString() {
        return "/////////////////\n"
                + "O " + this.nome +
                "\n ><> status de vida: " + this.vida + " <><\n" +
                "------------------------------------------------\n";
    }

    @Override
    public String tela() {

        if (this.vida <= 0) {
            return "\n"
                    + ">>" + ANSI_RED + "O " + this.nome + " esta morto!" + ANSI_RESET;

        } else {
            return "";
        }
    }
}
