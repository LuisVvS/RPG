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
        // gero um numero aleatorio entre metade do dano total da arma e o dano da arma que está no inventario do
        // player
        int d = v.getArma().getDano();
        
        int dano = rand.nextInt((d/2), d);
        // multiplico o dano pela forca e somo mais o dano dado pelo player
        // transformo em inteiro porque ele retorna double e o metodo ataque() aceita
        // inteiro
        dano += (int) (dano * this.getForca());

        // pego o dano e somo ao dano total para mostrar no score
        this.setDtotal(dano + this.getDtotal());

        System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, dano);
        // seto a vida do meu inimigo como a vida dele menos o dano que foi gerado e
        // recebido por parametro
        n.setVida(n.getVida() - dano);
        // o if abaixo evita que a vida fique negativa, porque quando ela fica abaixo de
        // 0 eu seto para 0
        if (n.getVida() < 0) {
            n.setVida(0);
        }
    }

    public int setarHabilidade() {
        Scanner acao = new Scanner(System.in);
        int habilidade;

        do {
            System.out.println("Qual a habilidade você vai querer? ");
            System.out.println("-1- Berserk ");
            System.out.println(
                    "Berserk: Ao ativar esta habilidade, o player da o dano total da sua arma, mais metade do dano total");
            System.out.println("-2- Laminas do Caos ");
            System.out.println(
                    "Laminas do Caos - Ao ativar esta habilidade voce da o dobro de dano");
            habilidade = acao.nextInt();

        } while (habilidade != 1 && habilidade != 2);
        return habilidade;

    }

    // habilidade
    public void Habilidade1(Enemy e, Inventario v) {
        // try na tentativa de gerar um ataque pegando o dano da arma e somando + 50% do
        // dano dela mesma
        try {
            int berserk = v.getArma().getDano() + (v.getArma().getDano() / 2);

            int d = (int) (berserk + (berserk * this.getForca()));

            System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, d);
            e.setVida(e.getVida() - d);

            // pego o dano e somo ao dano total para mostrar no score
            this.setDtotal(d + this.getDtotal());

            if (e.getVida() < 0) {
                e.setVida(0);
            }

            // diminuo a habilidade dele
            this.setHabilidade(this.getHabilidade() - 1);
        } catch (InputMismatchException y) {
            System.out.println();
        }
    }

    public void Habilidade2(Enemy e, Inventario v) {
        // dobro o dano da arma mais a força
        try {
            //seto a vida do inimigo como o dano total da arma menos a porcentagem da força com o dano total, isso tudo x2
            int d = ((v.getArma().getDano() + (int) (v.getArma().getDano() * this.getForca())))*2;

            e.setVida(e.getVida() - d);
            System.out.println("Você deu " + d + " de dano");
            this.getDtotal(this.getDtotal()+d);

            if (e.getVida() < 0) {
                e.setVida(0);
            }

            // tiro 1 da habilidade
            this.habilidade -= 1;
        } catch (InputMismatchException y) {
            System.out.println();
        }
    }

}