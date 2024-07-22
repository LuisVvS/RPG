package mundo;

import java.util.*;

public class Mago extends Player {

  public Mago(String nome, int vida) {
    super(nome, vida);
  }

  @Override
  public void ataque(Inventario v, Enemy n) {
    int d = 0;
    Random rand = new Random();
    Scanner dd = new Scanner(System.in);
    System.out.println("[1] Bola de Fogo | [2] Raio");
    int dan = dd.nextInt();

    if (dan == 1) {

      int dano = rand.nextInt(5, 10);

      d += (int) dano + (dano * this.getForca());
      n.setVida(n.getVida() - d);
      // o if abaixo evita que a vida fique negativa, porque quando ela fica abaixo de
      // 0 eu seto para 0
      if (n.getVida() < 0) {
        n.setVida(0);
      }
    } else {

      int dano = rand.nextInt(4, 7);

      d += (int) dano + (dano * this.getForca());
      if (dan == 2) {
        n.setVida(n.getVida() - d);
        // o if abaixo evita que a vida fique negativa, porque quando ela fica abaixo de
        // 0 eu seto para 0
        if (n.getVida() < 0) {
          n.setVida(0);
        }
      }
    }
    // pego o dano e somo ao dano total para mostrar no score
    this.setDtotal(d + this.getDtotal());
    System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, d);
  }

  public int setarHabilidade() {
    Scanner acao = new Scanner(System.in);
    int habilidade;

    do {
      System.out.println("Qual a habilidade você vai querer? ");
      System.out.println("-1- Vulnus");
      System.out.println(
          "Vulnus - Esta habilidade permita que o dano da sua magia seja dobrada");
      System.out.println("-2- Armadura Arcana ");
      System.out.println(
          "Armadura Arcana - Devolve todo o dano causado pelo inimigo");
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
      int perk = v.getArma().getDano() * 2;
      System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, perk);
      e.setVida(e.getVida() - perk);

      // pego o dano e somo ao dano total para mostrar no score
      this.setDtotal(perk + this.getDtotal());

      if (e.getVida() < 0) {
        e.setVida(0);
      }

      // diminuo a habilidade dele
      this.setHabilidade(this.getHabilidade() - 1);
    } catch (InputMismatchException y) {
      System.out.println();
    }
  }

  @Override
  public void Habilidade2(Enemy e, Inventario v) {
    // O player fica imune por dois turnos aos ataques do adversario
    try {
      e.setVida(e.getVida() - e.getDtotal());
      System.out.printf("O Player %s Devolveu %d: ", this.nome, e.getDtotal());

      // pego o dano e somo ao dano total para mostrar no score
      this.setDtotal(e.getDtotal() + this.getDtotal());

      if (e.getVida() < 0) {
        e.setVida(0);
      }

    } catch (InputMismatchException y) {
      System.out.println();
    }
  }

}