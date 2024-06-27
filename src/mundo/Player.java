package mundo;

import java.util.InputMismatchException;

public class Player {
    protected String nome;
    protected int level, dano, vida, vmax, dtotal, moeda = 30;
    protected int habilidade = 1;

    public Player(String nome, int level, int vida) {
        this.nome = nome;
        this.level = level;
        this.vida = vida;
        this.vmax = vida;
    }

    public void ataque(int d, Enemy n) {
        System.out.println("\n------------------------------------------------\n");
        System.out.printf("O player %s está atacando e causou %d de dano \n", this.nome, d);
        n.setVida(n.getVida() - d);
        if (n.getVida() < 0) {
            n.setVida(0);
        }
    }

    public void curar(Inventario inv) {
        if (inv.pocao > 0) {
            if (vida < vmax) {
                System.out.printf("O player %s está se curando e curou %d de vida \n", this.nome,
                        this.vmax - this.vida);
                this.setVida(this.vida += (this.vmax - this.vida));
                inv.pocao -= 1;
            } else {
                System.out.println("A vida do player ja esta no maximo \n");
            }
        } else {
            System.out.println("O player não tem pocoes para se curar! \n pocoes podem ser compradas com mercadores");
        }
    }

    public String tela() {
        if (this.vida <= 0) {
            return "\n///////\n"
                    + "O player " + this.nome + " esta morto!\n" +
                    "/////////";
        } else {
            return "";
        }
    }

    public String score(int x) {
        return "\nScore do Player: " + this.nome + "\n" +
                "______________________\n" +
                "-fases passadas: " + x + "\n" +
                "______________________\n" +
                "-dano : " + this.dtotal + "\n" +
                "__________________\n";
    }

    @Override
    public String toString() {
        return "O player: " + this.nome +
                "\n ><> status de vida: " + this.vida + " <><";
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setDtotal(int dtotal) {
        this.dtotal = dtotal;
    }

    public int getDtotal() {
        return dtotal;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void berserk(Enemy e, Inventario v) {
        try {
            int berserk = v.getArma().getDano() + (v.getArma().getDano() / 2);
            this.ataque(berserk, e);
            this.setHabilidade(this.getHabilidade() - 1);
        } catch (InputMismatchException y) {
            System.out.println();
        }
    }

    public void heimdall() {
        try {
            this.setVida(this.getVida() + 20);
            System.out.println("Foi adicionado 20 de proteção a vida do Player");
            this.habilidade -= 1;
        } catch (InputMismatchException y) {
            System.out.println();
        }

    }
}