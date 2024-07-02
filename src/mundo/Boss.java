package mundo;

import java.util.Random;

public class Boss extends Enemy {
    public Boss(String nome, int vida) {
        super(nome, vida);
        vmax = vida;
    }

    public void especial() {
    }

    @Override
    public void atacar(int d, Player p) {

    }

    public void cura() {
        int count = 1;
            Random rand = new Random();
            if (this.vida < this.vmax * 0.5 &&  count > 0) {
                double d = this.vmax * 0.1;
                double c = this.vmax * 0.5;
                int dez = (int) d;
                int cinq = (int) c;

                int cura = rand.nextInt(dez, cinq);

                this.setVida(this.vida + cura);
                System.out.println("O cão curou " + cura + " de vida");
                count -= 1;
                System.out.println(count);
            }


    }

}
