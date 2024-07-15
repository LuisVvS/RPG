package mundo;

import java.util.*;

public class Player extends Metodos {
    protected String nome;
    protected int level, vida, vmax, dtotal, xp, moeda = 10;
    protected int habilidade = 1;
    protected double forca, saude;

    public Player(String nome, int vida) {
        this.nome = nome;
        this.level = 0;
        this.vida = vida;
        this.vmax = vida;
    }

    // ataco o adversario
    public void ataque(Inventario v, Enemy n) {
        Random rand = new Random();
        // gero um numero aleatorio entre 0 e o dano da arma que está no inventario do
        // player
        int dano = rand.nextInt(6,v.getArma().getDano());

        // multiplico o dano pela forca e somo mais o dano dado pelo player
        // transformo em inteiro porque ele retorna double e o metodo ataque() aceita
        // inteiro
        int d = (int) (dano + (dano * this.getForca()));

        // pego o dano e somo ao dano total para mostrar no score
        this.setDtotal(d + this.getDtotal());

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

    // mostro a tela de morte caso a vida do player esteja negativa ou igual a 0
    public String tela() {
        if (this.vida <= 0) {
            return "\n///////\n"
                    + "O player " + this.nome + " esta morto!\n" +
                    "/////////";
        } else {
            return "";
        }
    }

    // mostro o score como o nome, o total de fases passadas (recebida por
    // parametro) e o dano total aplicado
    public String score(int x) {
        return "\nScore do Player: " + this.nome + "\n" +
                "______________________\n" +
                "-fases passadas: " + x + "\n" +
                "______________________\n" +
                "-dano : " + this.dtotal + "\n" +
                "__________________\n" +
                "-Xp acumulados: " + this.xp + "\n" +
                "__________________\n" +
                "-Levels: " + this.level + "\n" +
                "__________________\n";
    }

    // metodo para level
    public void levelup() {
        Scanner sc = new Scanner(System.in);
        // variavel usada para escolher qual atributo voce deseja aumentar
        int att = 0;
        // se o xp for maior ou igual ao proximo nivel ele sobre de nivel ex:
        // tenho level 2 + 1 = 3
        // 3*10 == 30 || 30 seria o numero necessario para chegar a level 3
        // então se o xp for maior ou igual a 30, ele sobre pro level 3
        // e não existe a possibilidade dele passar do nivel 2 pro 4 de uma vez
        if (this.xp >= (this.level + 1) * 10) {

            System.out.println("Parabens, você subiu de level!");
            System.out.println("Level anterior: " + this.level);
            // seto o level como o xp dividido por 10 ex: 20/10 == 2 de level
            this.level = this.xp / 10;
            System.out.println("Level atual: " + this.level);
            // utilizo a variavel att para fazer um loop até ele decidir qual atributo
            // deseja aumentar
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
            // caso 1 ele aumenta saude em 5% e forca em 20%
            if (att == 1) {
                // mostro a saude e a força antes
                System.out.println("Sua força antes: " + this.forca);
                System.out.println("Sua saude antes: " + this.saude);
                // aumento força e saude
                // uso double para conseguir multiplicar a forca com o ataque e dar mais dano
                // a medida que minha forca aumenta
                this.saude += 0.05;
                this.forca += 0.2;
                // mostro a saude e a força depois
                System.out.println("Sua força atual: " + this.forca);
                System.out.println("Sua saude atual: " + this.saude);
            } else {
                // caso 2 ele aumenta forca em 5% e saude em 20%
                if (att == 2) {
                    // mostro a saude e a força antes
                    System.out.println("Sua força antes: " + this.forca);
                    System.out.println("Sua saude antes: " + this.saude);
                    this.forca += 0.05;
                    this.saude += 0.2;
                    // mostro a saude e a força depois
                    System.out.println("Sua força atual: " + this.forca);
                    System.out.println("Sua saude atual: " + this.saude);
                    // aumento a vida em porcentagem da vida max
                    this.vida += this.vmax * this.saude;
                    // aumento a vida maxima para que o player possa curar até o a vida aumentada
                    this.vmax += this.vmax * this.saude;
                }
            }
        }
    }

    // habilidade
    public void berserk(Enemy e, Inventario v) {
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

    public void heimdall() {
        // try na tentativa de aumentar a vida do usuario, em mais 20 (tipo uma
        // proteção)
        try {
            this.setVida(this.getVida() + 20);
            System.out.println("Foi adicionado 20 de proteção a vida do Player");
            // tiro 1 da habilidade
            this.habilidade -= 1;
        } catch (InputMismatchException y) {
            System.out.println();
        }

    }

    // getters e settes
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public double getForca() {
        return forca;
    }

    public void setSaude(double saude) {
        this.saude = saude;
    }

    public double getSaude() {
        return saude;
    }
}