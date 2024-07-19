package mundo;

import java.util.Random;

public class Boss extends Enemy {
    protected int des = 1;

    public Boss(String nome, int vida) {
        super(nome, vida);
        vmax = vida;
    }

    // especial
    // caso a vida do inimigo esteja abaixo de 15% e ele possa usar o especial
    public void especial(Player p) {
        // reduz 90% da vida do player
        if (this.vida < vmax * 0.15 && this.des > 0) {
            p.setVida(p.getVida() - (int) (p.getVida() * 0.9));
            // subtrai 1 da variavel para ele usar o especial
            this.des -= 1;
            // avisa que o inimigo esta dando dano
            System.out.printf("O %s está atacando e causou %d de dano \n", this.nome, (int)(p.getVida() * 0.9));
        }
    }

    public void atacar(Player p) {
        // gera um dano aleatorio entre 10% da vida max do player e 50%
        Random rand = new Random();
        double dan = p.vmax * 0.1;
        int c = p.vmax / 2;
        // transformo os danos em numeros inteiros
        int dano = rand.nextInt((int) dan, (int) c);
        this.dtotal+=dano;

        // avisa que o inimigo esta dando dano
        System.out.printf("O %s está atacando e causou %d de dano \n", this.nome, dano);
        // seta a vida do player conforme o dano que o inimigo dar e se for negativa
        // seta para 0
        p.setVida(p.getVida() - dano);
        if (p.getVida() < 0) {
            p.setVida(0);
        }
    }

    public void cura() {
        int count = 3;
        //objeto aleatorio
        Random rand = new Random();
        //se a vida do inimigo esta abaixo de 50% ele cura entre 10% e 30% da vida max
        if (this.vida < this.vmax * 0.5 && count > 0) {
            double d = this.vmax * 0.1;
            double c = this.vmax * 0.3;
            int dez = (int) d;
            int cinq = (int) c;

            int cura = rand.nextInt(dez, cinq);
            //curo a vida dele com a variavel cura que guarda o valor mencionado acima
            this.setVida(this.vida + cura);
            System.out.println("O cão curou " + cura + " de vida");
            count -= 1;
            System.out.println(count);
        }
    
    }
}