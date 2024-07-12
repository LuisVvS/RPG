package mundo;

import java.util.*;

public class Elfo extends Player {

    public Elfo(String nome, int vida) {
        super(nome, vida);
    }

    // ataco o adversario
    @Override
    public void ataque(Inventario v, Enemy n) {
        Random rand = new Random();

        int d = v.getArma().getDano();
        d += (int)(d * this.getForca());
        System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, d);
        // seto a vida do meu inimigo como a vida dele menos o dano que foi gerado e
        // recebido por parametro
        n.setVida(n.getVida() - d);
        // o if abaixo evita que a vida fique negativa, porque quando ela fica abaixo de
        // 0 eu seto para 0
        if (n.getVida() < 0) {
            n.setVida(0);
        }
    }
}
