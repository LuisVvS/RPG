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
      
      int dano = rand.nextInt(5,10);

      d += (int) dano + (dano * this.getForca());
      n.setVida(n.getVida() - d);
      // o if abaixo evita que a vida fique negativa, porque quando ela fica abaixo de
      // 0 eu seto para 0
      if (n.getVida() < 0) {
        n.setVida(0);
      }
    } else {

      int dano = rand.nextInt(3,7);

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

}