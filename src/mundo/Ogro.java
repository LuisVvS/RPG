package mundo;

import java.util.*;

public class Ogro extends Player {
    public Ogro(String nome, int vida) {
        super(nome, vida);
    }

    @Override
    // ataco o adversario
    public void ataque(Inventario v, Enemy n) {
        Random rand = new Random();
        // gero um numero aleatorio entre 0 e o dano da arma que está no inventario do
        // player
        int dano = rand.nextInt(7, v.getArma().getDano());

        // multiplico o dano pela forca e somo mais o dano dado pelo player
        // transformo em inteiro porque ele retorna double e o metodo ataque() aceita
        // inteiro
        int d = (int) (dano + (dano * this.getForca()));

        // pego o dano e somo ao dano total para mostrar no score
        this.setDtotal(d + this.getDtotal());

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
