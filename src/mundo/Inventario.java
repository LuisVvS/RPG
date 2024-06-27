package mundo;

import java.util.*;

public class Inventario {
    protected Armas arma;
    protected int pocao;

    public Inventario(int pocao) {
        this.pocao = pocao;
    }

    public void setArma(Armas arma) {
        this.arma = arma;
    }

    public Armas getArma() {
        return arma;
    }

    public void setPocao(int pocao) {
        this.pocao = pocao;
    }

    public int getPocao() {
        return pocao;
    }

    public void Acessar(Player p) {

        Scanner opcao = new Scanner(System.in);
        int op;
        try {
            do {
                System.out.println("-----Inventario do player-----");
                System.out.println("_______________________________");
                System.out.println("Arma: " + this.arma.getNome());
                System.out.println(" Numero de pocoes: " + this.pocao);
                System.out.println("Moedas: "+ p.getMoeda());
                System.out.println("Pontos da Habilidade: "+ p.getHabilidade());
                System.out.println("_______________________________");
                System.out.println("[1] Descrição Arma [2] Sair");
                op = opcao.nextInt();
                switch (op) {
                    case 1:
                        System.out.println(this.arma.toString());
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Essa opção é invalida");
                }

            } while (op != 2);
        } catch (Exception e) {
            System.out.println("Este valor não existe");
        }

    }

}
