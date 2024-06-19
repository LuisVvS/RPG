package mundo;

import java.util.*;

public class Jogo {
    public static void main(String[] args) {

        Scanner acao = new Scanner(System.in);
        Inventario v = new Inventario(2);
        Random rand = new Random();

        // lista de monstros gerados durante as fases
        List<Enemy> nomes = new ArrayList<Enemy>() {
            {
                add(new Enemy("Ogro", 2, 10));
                add(new Enemy("Goblin", 1, 10));
                add(new Enemy("Guardiao", 3, 10));
            }
        };

        // exibir a funcao menu
        if (menu()) {

            // perguntar qual o nome do usuario
            System.out.println("Qual o nome do seu usuario? ");
            String n = acao.next();
            Player p = new Player(n, 0, 20);
            int fase = 1;

            // loop de fase
            do {

                Enemy e = nomes.get(rand.nextInt(nomes.size()));

                // reiniciando o adversario para que ele apareca nas fases posteriores
                e.reiniciar();
                System.out.println("--------------------------------------------");

                System.out.println("\n>> Um " + e.nome + " apareceu na sua frente <<\n");
                // loop para combate
                do {
                    System.out.println(">>>>>> Fase: " + fase + " <<<<<<");

                    // menu de combate
                    System.out.println("--------Ações--------");
                    System.out.println("[1] atacar [2] curar");
                    int ac = acao.nextInt();

                    // seleciono as acoes do player
                    switch (ac) {
                        case 1:
                            int dano = rand.nextInt(5, 10);
                            p.setDtotal(dano + p.getDtotal());
                            p.ataque(dano, e);
                            break;

                        case 2:
                            p.curar(v);
                            break;
                    }
                    // inimigo ataca se não estiver com a vida zerada
                    //e logo em seguida é mostrado na tela os status de cada combatente
                    if (e.getVida() > 0) {
                        e.atacar(rand.nextInt(1, 10), p);
                    }
                    System.out.println(p.toString());
                    System.out.println(e.toString());

                } while (p.getVida() > 0 && e.getVida() > 0);

                // exibir tela de morte
                if (p.getVida() > e.getVida()) {
                    System.out.println(e.tela());
                } else {
                    System.out.println(p.tela());
                }

                // exibir pergutnta de proxima fase
                if (e.getVida() <= 0) {
                    if (continuar()) {
                        fase += 1;
                        continue;
                    } else {
                        break;
                    }
                }

            } while (p.getVida() > 0);
            // fase termina acima

            // mostra score do player
            System.out.println(p.score(fase - 1));
            acao.close();
        }
    }

    // exibo o menu inicial do jogo
    public static boolean menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--------ola--------");
        System.out.println("---seja bem-vindo---");
        System.out.println("-Voce deseja jogar?-");
        System.out.println("[1] sim [2] nao");
        System.out.println("-------------------");
        int numero = sc.nextInt();

        if (numero == 1) {
            return true;
        } else {
            return false;
        }
    }

    // funcao que pergunta se o usuario deseja continuar para a proxima fase
    public static boolean continuar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Continuar para a proxima fase? ");
        System.out.println("[1]sim   [2]não");
        int numero = sc.nextInt();

        if (numero == 1) {
            return true;
        } else {
            return false;
        }
    }
}

// organizar melhor o output dos usuarios
// pegas as exceções
// inventario e trabalhar na verificacao da quantidade de poções e armas que
// possuem no inventario
// trabalhar na compra de itens