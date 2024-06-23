package mundo;

import java.util.*;

public class Vendedor {
    protected String nome;
    protected int EstoqueP = 10;

    public void venda(Inventario inventario, Player p) {
        Scanner sc = new Scanner(System.in);
        int bot;
        System.out.println("\n-----UM VENDEDOR APARECEU NA SUA FRENTE!-----");
        do {
            System.out.println("\n----------Bem vindo Viajante!----------");
            System.out.println("[1] Poção de cura: " + this.EstoqueP);
            System.out.println("[2] " );
            System.out.println("[0] Sair");
            System.out.println("suas moedas: " + p.getMoeda());
            bot = sc.nextInt();

            switch (bot) {
                case 1:
                    System.out.println("\nQuantas você deseja comprar? ");
                    int quant = sc.nextInt();
                    if (quant > this.EstoqueP && quant <= p.getMoeda()) {
                        System.out.println("\nEsta quantia é invalida");
                    } else {
                        inventario.setPocao(quant + inventario.getPocao());
                        p.setMoeda(p.getMoeda() - quant);
                        System.out.println("\nVenda feita com sucesso");
                        this.EstoqueP -= quant;
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Essa opção não existe");
            }

        } while (bot != 0);

    }
}
