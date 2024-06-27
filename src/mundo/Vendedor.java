package mundo;

import java.util.*;

public class Vendedor {
    protected String nome;
    HashMap<String, Integer> estoque = new HashMap<String, Integer>();

    public void venda(Inventario inventario, Player p) {

        estoque.put("Pocao", 10);
        estoque.put("Habilidade", 1);

        Scanner sc = new Scanner(System.in);
        int bot;

        int poc = estoque.get("Pocao");
        int hab = estoque.get("Habilidade");

        System.out.println("\n-----UM VENDEDOR APARECEU NA SUA FRENTE!-----");
        do {
            System.out.println("\n----------Bem vindo Viajante!----------");
            System.out.println("[1] Poção de cura |1$ cada| : " + poc);
            System.out.println("[2] Pontos de habilidade |30$| : " + hab);
            System.out.println("[0] Sair");
            System.out.println("suas moedas: " + p.getMoeda());
            bot = sc.nextInt();

            switch (bot) {
                case 1:
                    System.out.println("\nQuantas você deseja comprar? ");
                    int quant = sc.nextInt();
                    if (quant > poc && quant <= p.getMoeda()) {
                        System.out.println("\nEsta quantia é invalida");
                    } else {
                        inventario.setPocao(quant + inventario.getPocao());
                        p.setMoeda(p.getMoeda() - quant);
                        System.out.println("\nVenda feita com sucesso");
                        poc -= quant;
                    }
                    break;
                case 2:
                    System.out.println("\nQuantas você deseja comprar? ");
                    int quan = sc.nextInt();

                    if (quan > hab || (quan * 30) > p.getMoeda()) {
                        System.out.println("\nEsta quantia é invalida");
                    } else {
                        if (p.getHabilidade() >= 2) {
                            System.out.println("Você atingiu o maximo de habilidades permitidas por player");
                        } else {
                            // adicionar compra do ponto ao inventario de player
                            p.setHabilidade(quan + p.getHabilidade());
                            // diminuir habilidade da loja do vendedor
                            hab -= quan;
                            // retiro a quantidade de moedas vendidas do inventario do player
                            p.setMoeda(p.getMoeda() - 30);
                            System.out.println("\nVenda feita com sucesso");
                        }
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
