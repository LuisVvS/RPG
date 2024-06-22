package mundo;

import java.util.*;

public class Vendedor {
    protected String nome;
    protected int EstoqueP = 10;

    public void venda(Inventario inventario) {
        Scanner sc = new Scanner(System.in);
        int bot;
        System.out.println("\n-----UM VENDEDOR APARECEU NA SUA FRENTE!-----");
        do {
            System.out.println("\n----------Bem vindo Viajante!----------");
            System.out.println("[1] Poções: " + this.EstoqueP);
            System.out.println("[0] Sair");
            bot = sc.nextInt();

            switch (bot) {
                case 1:
                    System.out.println("\nQuantas você deseja comprar? ");
                    int quant = sc.nextInt();
                    if (quant > this.EstoqueP) {
                        System.out.println("\nEsta quantia esta fora de estoque no momento!");
                    } else {
                        inventario.setPocao(quant + inventario.getPocao());
                        System.out.println("\nVenda feita com sucesso");
                        this.EstoqueP -= quant;
                    }
                    break;
                default:
                    System.out.println("Essa opção não existe");
            }

        } while (bot != 0);

    }
}
