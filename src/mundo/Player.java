package mundo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    protected String nome;
    protected int level, vida, vmax, dtotal, xp, moeda = 30;
    protected int habilidade = 1;
    protected double forca, saude;

    public Player(String nome, int level, int vida) {
        this.nome = nome;
        this.level = level;
        this.vida = vida;
        this.vmax = vida;
    }

    public void ataque(int d, Enemy n) {
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

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public int getXP() {
        return xp;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }

    public void setForca(double forca){
        this.forca=forca;
    }
    public double getForca(){
        return forca;
    }

    public void setSaude(double saude){
        this.saude=saude;
    }
    public double getSaude(){
        return saude;
    }

    public void levelup() {
        Scanner sc = new Scanner(System.in);
        int att = 0;

        if (this.xp >= (this.level + 1) * 10) {

            System.out.println("Parabens, você subiu de level!");
            System.out.println("Level anterior: " + this.level);
            this.level = this.xp / 10;
            System.out.println("Level atual: " + this.level);

            try {
                do {
                    System.out.println("Qual atributo você deseja aumentar? ");
                    System.out.println("[1] Força");
                    System.out.println("[2] Saude");
                    att = sc.nextInt();
                } while (att != 1 && att != 2);

            } catch (InputMismatchException y) {
                System.out.println("Este não é um valor valido");
            }

            if (att == 1) {
                System.out.println("Sua força antes: " + this.forca);
                System.out.println("Sua saude antes: " + this.saude);
                this.saude += 0.05;
                this.forca += 0.2;
                System.out.println("Sua força atual: " + this.forca);
                System.out.println("Sua saude atual: " + this.saude);
            } else {
                if (att == 2) {
                    System.out.println("Sua força antes: " + this.forca);
                    System.out.println("Sua saude antes: " + this.saude);
                    this.forca += 0.05;
                    this.saude += 0.2;
                    System.out.println("Sua força atual: " + this.forca);
                    System.out.println("Sua saude atual: " + this.saude);
                    this.vida += this.vmax*this.saude ;
                }
            }
        }
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