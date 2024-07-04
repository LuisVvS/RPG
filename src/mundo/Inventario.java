package mundo;

import java.util.*;

public class Inventario {
    protected Armas arma;
    protected int pocao;
    //getters e setters
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
    //recebo um objeto do tipo player por parametro
    public void Acessar(Player p) {
        //crio um scanner e uma variavel para utilizar na hora de escolher ação no inventario 
        Scanner opcao = new Scanner(System.in);
        int op;
        try {
            do {
                //exibir inventario com vida, aema pocao, moeda, habilidade, level e xp do player
                //ofereco tamebm as opções de pegar a desc. da arma ou sair do inventario
                System.out.println("-----Inventario do player-----");
                System.out.println("_______________________________");
                System.out.println("Vida do Player: " +p.getVida());
                System.out.println("Arma: " + this.arma.getNome());
                System.out.println(" Numero de pocoes: " + this.pocao);
                System.out.println("Moedas: "+ p.getMoeda());
                System.out.println("Pontos da Habilidade: "+ p.getHabilidade());
                System.out.println("Nivel: "+ p.getLevel());
                System.out.println("XP: "+ p.getXP());
                System.out.println("_______________________________");
                System.out.println("[1] Descrição Arma [2] Sair");
                op = opcao.nextInt();
                switch (op) {
                    //mostro a descrição da arma
                    case 1:
                        System.out.println(this.arma.toString());
                        break;
                        //saio do inv
                    case 2:
                        break;
                    default:
                        System.out.println("Essa opção é invalida");
                }

            } while (op != 2);
        } catch (InputMismatchException e) {
            System.out.println("Este valor não existe");
        }

    }

}
