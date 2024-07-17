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
            System.out.println("1- saeth uchafswm");
            System.out.println(
                    "Saeth uchafswm - Esta habilidade lança uma flecha que lança 3x o dano total da arma, mas gasta dois pontos de habilidade");
            System.out.println("2- Malha Elfica");
            System.out.println(
                    "Malha Elfica - Te da 30 de proteção");
            habilidade = acao.nextInt();

        } while (habilidade != 1 && habilidade != 2);
        return habilidade;

    }

    @Override
    // habilidade
    public void Habilidade1(Enemy e, Inventario v) {
        // try na tentativa de gerar um ataque pegando o dano da arma e somando + 50% do
        // dano dela mesma
        try {
            int perk = v.getArma().getDano() * 3;
            System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, perk);
            e.setVida(e.getVida() - perk);

            // pego o dano e somo ao dano total para mostrar no score
            this.setDtotal(perk + this.getDtotal());

            if (e.getVida() < 0) {
                e.setVida(0);
            }

            // diminuo a habilidade dele
            this.setHabilidade(this.getHabilidade() - 2);
        } catch (InputMismatchException y) {
            System.out.println();
        }
    }

    @Override
    public void Habilidade2(Enemy e, Inventario v) {
        // o Player devolve o dano que o adversario deu nele ate aquele momento
        try {
            this.setVida(this.getVida() + 30);
            System.out.println("O Player " + this.nome + " se protegeu com 30 de armadura ");
        } catch (InputMismatchException y) {
            System.out.println();
        }
    }

}
