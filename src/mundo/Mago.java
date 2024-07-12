package mundo;

import java.util.Scanner;

public class Mago extends Player {

  public Mago(String nome, int vida) {
    super(nome, vida);
  }

  @Override
  public void ataque(Inventario v, Enemy n) {
    int d = 0;
    Scanner dd = new Scanner(System.in);

    System.out.println("[1] Bola de Fogo | [2] Raio");
    int dan = dd.nextInt();

    if (dan == 1) {
      d += (int) 10 + (10 * this.getForca());
      n.setVida(n.getVida() - d);
      // o if abaixo evita que a vida fique negativa, porque quando ela fica abaixo de
      // 0 eu seto para 0
      if (n.getVida() < 0) {
        n.setVida(0);
      }
    } else {
      d += (int) 7 + (7 * this.getForca());
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

}