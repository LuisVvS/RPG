package mundo;

import java.util.*;

public class Jogo {
    public static void main(String[] args) {

        Scanner acao = new Scanner(System.in);
        Inventario v = new Inventario(2);
        Random rand = new Random();
        int habilidade = 0;

        // Lista de armas do jogo
        List<Armas> armas = new ArrayList<Armas>() {
            {
                add(new Armas("Espada", 15));
                add(new Armas("Espada da galaxia", 30));
            }
        };

        // lista de monstros gerados durante as fases
        List<Enemy> nomes = new ArrayList<Enemy>() {
            {
                add(new Enemy("Ogro", 15));
                add(new Enemy("Goblin", 7));
                add(new Enemy("Guardiao", 20));
                add(new Enemy("Vampiro", 12));
                add(new Enemy("Fantasma", 10));
            }
        };

        // exibir a funcao menu
        try {
            if (menu()) {
                // exibe breve historia sobre o jogo
                historia();
                // perguntar qual o nome do usuario
                System.out.println("Qual o nome do seu usuario? ");
                String n = acao.next();
                // cria player
                Player p = new Player(n, 20);
                int fase = 1;
                // seta a arma no inventario
                // pego um indice na arraylist de armas pego o valor nela e passo pro inventario
                v.setArma(armas.get(1));
                // começo o loop até ele escolher uma opção ou o sistema pegar alguma execção
                do {
                    System.out.println("Qual a habilidade você vai querer? ");
                    System.out.println("-1- Berserk ");
                    System.out.println(
                            "Berserk: Ao ativar esta habilidade, o player da o dano total da sua arma, mais metade do dano total");
                    System.out.println("-2- Heimdall");
                    System.out.println(
                            "Heimdall: Ao ativar esta habilidade o player adiciona 20 de proteção a sua vida.");
                    habilidade = acao.nextInt();

                } while (habilidade != 1 && habilidade != 2);

                // loop de fase
                do {
                    // pego um inimigo aleatorio da arraylist
                    Enemy e = nomes.get(rand.nextInt(nomes.size()));

                    // reiniciando o adversario para que ele apareca nas fases posteriores
                    e.reiniciar();

                    System.out.println(">>>>>> level: " + fase + " <<<<<<");
                    System.out.println("--------------------------------------------");
                    System.out.println("\n>> Um " + e.nome + " apareceu na sua frente <<\n");

                    // combate
                    combate(p, e, v, acao, rand, habilidade);

                    // exibir tela de morte
                    if (p.getVida() > e.getVida()) {
                        // Adicionar moedas a cada morte de monstro
                        // geto uma moeda entre 1 a 5
                        int mod = rand.nextInt(1, 5);
                        System.out.println("Você ganhou " + mod + " moedas!");
                        // e passo essa moeda gerada e guardada na variavel mod pelo setmoeda
                        p.setMoeda(p.getMoeda() + mod);

                        // gero um xp entre 2 e 4
                        int xp = rand.nextInt(2, 4);
                        System.out.println("Você ganhou " + xp + " de xp");
                        // seto o xp para o usuario
                        p.setXP(p.getXP() + xp);
                        // chamo a função de subir de nivel
                        p.levelup();

                        System.out.println(e.tela());
                    } else {
                        System.out.println(p.tela());
                    }

                    // exibir perguta de proxima fase
                    if (e.getVida() <= 0) {
                        if (continuar()) {
                            fase += 1;
                        } else {
                            break;
                        }
                    }

                    // ceritifica que o vendedor apareca a cada 5 fases
                    if (fase % 5 == 0 && p.getVida() > 0) {
                        Vendedor vendedor = new Vendedor();
                        vendedor.venda(v, p);

                    }
                    // quando chega a fase 15 eu aciono o boss
                    if (fase == 15) {
                        System.out.println("\nVocê vê algo brilhante a frente.....parece ser o fim da jornada");
                        System.out.println("Deseja se curar ? ");
                        // caso a resposta do player seja sim ele se cura caso contrario ele só continua
                        // no caminho
                        String resposta = acao.next();
                        if (resposta.toLowerCase().equals("sim") || resposta.toLowerCase().equals("s")) {
                            p.curar(v);
                        }

                        System.out.println("Boa sorte!");
                        Boss cao = new Boss("Cão", 200);

                        // loop para combate
                        do {

                            // menu de combate
                            System.out.println("--------------------Ações--------------------");
                            System.out.println("[1] atacar [2] curar [3] Inventario [4]Habilidade");

                            int ac = acao.nextInt();

                            // seleciono as acoes do player
                            switch (ac) {
                                case 1:
                                    // gero um numero aleatorio entre 0 e o dano da arma que está no inventario do
                                    // player
                                    int dano = rand.nextInt(v.getArma().getDano());
                                    // pego o dano e somo ao dano total para mostrar no score
                                    p.setDtotal(dano + p.getDtotal());
                                    // multiplico o dano pela forca e somo mais o dano dado pelo player
                                    // transformo em inteiro porque ele retorna double e o metodo ataque() aceita
                                    // inteiro
                                    p.ataque((int) (dano + (dano * p.getForca())), cao);
                                    break;

                                case 2:
                                    // curo o player pelas poções no inv
                                    p.curar(v);
                                    break;

                                case 3:
                                    // acesso o inventario e selecionei o continue para que o player pudesse
                                    // continuar na batalha sem tomar dano ao acessar o inv
                                    v.Acessar(p);
                                    continue;

                                case 4:
                                    // aciono as habilidades do player caso ele tenha pontos verifico qual ele
                                    // escolheu e aciono elas
                                    if (p.getHabilidade() >= 1) {
                                        if (habilidade == 1) {
                                            p.berserk(cao, v);
                                        } else {
                                            if (habilidade == 2) {
                                                p.heimdall();
                                            }
                                        }
                                    } else {
                                        System.out.println("Você não tem pontos de habilidade para consumir");
                                    }
                                    break;

                                default:
                                    System.out.println("Este valor não existe e sua rodada foi perdida");

                            }

                            // inimigo ataca se não estiver com a vida zerada
                            if (cao.getVida() > 0) {
                                cao.ataca(p);
                                cao.especial(p);
                            }

                            // e logo em seguida é mostrado na tela os status de cada combatente
                            System.out.println("==================================================");
                            System.out.println("Player: " + p.getNome() + " | Vida: " + p.getVida());
                            System.out.println("Nivel: " + p.getLevel() + "\n");
                            System.out.println(cao.toString());
                            System.out.println("==================================================");
                            // loop funciona enquanto o player ou o cao estiverem com vida
                        } while (p.getVida() > 0 && cao.getVida() > 0);
                        break;
                    }

                } while (p.getVida() > 0);
                // fase termina acima

                // mostra score do player
                System.out.println(p.score(fase - 1));
                acao.close();
            }

        } catch (InputMismatchException e) {
            System.out.println("Não foi");
        }
    }

    // exibo o menu inicial do jogo
    public static boolean menu() {
        Scanner sc = new Scanner(System.in);

        try {
            // mostro o menu
            System.out.println("\n--------ola--------");
            System.out.println("---seja bem-vindo---");
            System.out.println("-Voce deseja jogar?-");
            System.out.println("[1] sim [2] nao");
            System.out.println("-------------------");

            int numero = sc.nextInt();
            // caso ele queira jogar, eu retorno true
            if (numero == 1) {
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Este valor não existe");
            return false;
        }
    }

    // funcao que pergunta se o usuario deseja continuar para a proxima fase
    public static boolean continuar() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Continuar para a proxima fase? ");
            System.out.println("[1]sim   [2]não");
            int numero = sc.nextInt();
            // pergunto se ele deseja continuar para a proxima fase caso seja sim retorno
            // true
            if (numero == 1) {
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Este valor não existe");
            return false;
        }
    }

    public static void historia() {
        // historia
        System.out.println("Bem vindo viajante!");
        System.out.println("A filha de um pastor de ovelhas foi sequestrada e levada para uma caverna misteriosa");
        System.out.println("E você foi contratado(a) para resgata-la com vida.");
    }

    public static void combate(Player p, Enemy e, Inventario v, Scanner acao, Random rand, int habilidade) {
        // loop para combate
        do {

            // menu de combate
            System.out.println("--------------------Ações--------------------");
            System.out.println("[1] atacar [2] curar [3] Inventario [4]Habilidade");

            int ac = acao.nextInt();

            // seleciono as acoes do player
            switch (ac) {
                case 1:
                    // gero um numero aleatorio entre 0 e o dano da arma que está no inventario do
                    // player
                    int dano = rand.nextInt(v.getArma().getDano());
                    // pego o dano e somo ao dano total para mostrar no score
                    p.setDtotal(dano + p.getDtotal());
                    // multiplico o dano pela forca e somo mais o dano dado pelo player
                    // transformo em inteiro porque ele retorna double e o metodo ataque() aceita
                    // inteiro
                    p.ataque((int) (dano + (dano * p.getForca())), e);
                    break;

                case 2:
                    // curo o player pelas poções no inv
                    p.curar(v);
                    break;

                case 3:
                    // acesso o inventario e selecionei o continue para que o player pudesse
                    // continuar na batalha sem tomar dano ao acessar o inv
                    v.Acessar(p);
                    continue;

                case 4:
                    // aciono as habilidades do player caso ele tenha pontos verifico qual ele
                    // escolheu e aciono elas
                    if (p.getHabilidade() >= 1) {
                        if (habilidade == 1) {
                            p.berserk(e, v);
                        } else {
                            if (habilidade == 2) {
                                p.heimdall();
                            }
                        }
                    } else {
                        System.out.println("Você não tem pontos de habilidade para consumir");
                    }
                    break;

                default:
                    System.out.println("Este valor não existe e sua rodada foi perdida");

            }

            // inimigo ataca se não estiver com a vida zerada
            // e o vampiro utiliza uma habilidade
            if (e.getVida() > 0) {
                if (e.perk()) {
                    e.setVida(e.getVida() + 3);
                    e.setHabilidade(e.getHabilidade() - 1);
                    System.out.println("O vampiro usou sua habilidade e se curou");
                } else {
                    e.atacar(rand.nextInt(1, 10), p);
                }
            }

            // e logo em seguida é mostrado na tela os status de cada combatente
            System.out.println("==================================================");
            System.out.println("Player: " + p.getNome() + " | Vida: " + p.getVida());
            System.out.println("Nivel: " + p.getLevel() + "\n");
            System.out.println(e.toString());
            System.out.println("==================================================");

        } while (p.getVida() > 0 && e.getVida() > 0);
    }
}

//aparentemente consertei o problema de ficar negativo a quantidade de moedas compradas (verificar)
//adicionar o ataque especial nos status de dano
//gastar poção quando o player dizer que sim na pergunta antes do boss
// adicionar ao score xp e level alcançado
// melhorar o estilo tenho esses dois links do github
// que geram tabelas em java https://github.com/vdmeer/asciitable
// https://github.com/JakeWharton/picnic
// preciso verificar os trys e catchs do sistema, coloquei o loop todo do game
// em um try.
// fazer uma historia melhor