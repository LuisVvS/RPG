package mundo;

import java.util.*;

public class Vendedor {
    protected String nome;
    HashMap<String, Integer> estoque = new HashMap<String, Integer>();

    // recebo por parametro um objeto do inventario e player para conseguir acessar
    // a arma, poções
    // e os pontos de habilidade
    //e mostro pro player
    public void venda(Inventario inventario, Player p) {
        // crio uma hashmap para colocar os itens no estoque e seus respectivos valores
        estoque.put("Pocao", 10);
        estoque.put("Habilidade", 1);

        Scanner sc = new Scanner(System.in);
        int bot;
        // armazeno esses valores em variaveis para ficar mais facil de manipular depois
        int poc = estoque.get("Pocao");
        int hab = estoque.get("Habilidade");
        // tela de venda
        System.out.println("\n-----UM VENDEDOR APARECEU NA SUA FRENTE!-----");
        // loop para que o usuario consiga comprar itens até ele escolher a opção 0 e
        // sair
        do {
            System.out.println("\n----------Bem vindo Viajante!----------");
            System.out.println("[1] Poção de cura |1$ cada| : " + poc);
            System.out.println("[2] Pontos de habilidade |30$| : " + hab);
            System.out.println("[0] Sair");
            System.out.println("suas moedas: " + p.getMoeda());
            bot = sc.nextInt();
            // switch and case para que ele consiga escolher as opções
            switch (bot) {
                case 1:
                    // pergunto a quantidade
                    System.out.println("\nQuantas você deseja comprar? ");
                    int quant = sc.nextInt();
                    // faço a verificação para saber se a quantidade que o usuario pediu é menor doq
                    // o estoque
                    // e a quantidade de moedas é suficiente
                    if (poc < quant || quant > p.getMoeda()) {
                        System.out.println("\nEsta quantia é invalida");
                    } else {
                        // caso a quantidade o if acima seja falso
                        // eu coloco a quantidade de poção no inventario conforme a quantidade
                        inventario.setPocao(quant + inventario.getPocao());
                        // retiro a quantidade de moedas conforme a quant. de poções
                        p.setMoeda(p.getMoeda() - quant);
                        System.out.println("\nVenda feita com sucesso");
                        // retiro as poções do estoque
                        poc -= quant;
                    }
                    break;
                case 2:
                    //verifica se a quantidade de moedas é suficiente
                    if (30 > p.getMoeda()) {
                        System.out.println("\nVocê não tem moedas o suficiente");
                    } else {
                        //verifico se a a quantidade de habilidades que ele tem no inventario são maiores do que 2
                        // não gosto da ideia do player ter mais de 2 pontos de habilidade
                        //o jogo fica muito desbalanceado
                        if (p.getHabilidade() >= 2) {
                            System.out.println("Você atingiu o maximo de habilidades permitidas por player");
                        } else {
                            // adicionar compra do item ao inventario de player
                            p.setHabilidade(1 + p.getHabilidade());
                            // diminuir habilidade da loja do vendedor
                            hab -= 1;
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
