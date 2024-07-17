package mundo;

import java.util.*;

public class Anao extends Player {

    public Anao(String nome, int vida) {
        super(nome, vida);
    }

    // ataco o adversario
    @Override
    public void ataque(Inventario v, Enemy n) {
        Random rand = new Random();

        int d = v.getArma().getDano();
        d += (int) (d * this.getForca());
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

    public int setarHabilidade() {
        Scanner acao = new Scanner(System.in);
        int habilidade;

        do {
            System.out.println("Qual a habilidade você vai querer? ");
            System.out.println("1- Berserk");
            System.out.println(
                    "Berserk: Ao ativar esta habilidade, o player da o dano total da sua arma, mais metade do dano total");
            System.out.println("2- Palavras de Khuzdul");
            System.out.println(
                    "Palavras de Khuzdul: Dano da arma com o dobro do dano e o dobra a força");
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
            System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, berserk);
            e.setVida(e.getVida() - berserk);

            // pego o dano e somo ao dano total para mostrar no score
            this.setDtotal(berserk + this.getDtotal());

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

        double f = 0;

        try {
            int dano = v.getArma().getDano()*2;            

            if (this.forca == 0.0) {
                f = this.getForca() + 0.2;
            } else {
                f =  this.getForca() * 2;
            }

            int d = (int) (dano + (v.getArma().getDano() * f));
            e.setVida(e.getVida() - (d));
            System.out.println("O Player "+ this.nome + " deu "+ d + " de dano");
            // tiro 1 da habilidade
            this.habilidade -= 1;
        } catch (InputMismatchException y) {
            System.out.println();
        }
    }

}
