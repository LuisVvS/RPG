package mundo;

import java.util.*;
public class Jogo {
    public static void main(String[] args) {
        
        Scanner acao = new Scanner(System.in);

        Enemy e = new Enemy("Ogro", 100, 30);
        Inventario v = new Inventario(2);
        Random rand = new Random();

        //criando a array que vai armazenar as armas do jogo
        List<Armas> armas  = new ArrayList<Armas>();     
        //adicionando armas pro jogo armas.add(new Armas("Espada de madeira", 10));
        armas.add(new Armas("Adaga", 20)); 
        armas.add(new Armas("Arco", 15)); 
        armas.add(new Armas("Lança", 30));
        armas.add(new Armas("Espada Obisidian", 50));  
       
        //exibir a funcao menu
        if(menu()){
            //perguntar qual o nome do usuario
            System.out.println("Qual o nome do seu usuario? ");
            String n = acao.next();
            Player p = new Player(n, 0, 20);
            //loop para combate 
        do{
            //menu de combate 
            System.out.println("--------Ações-------");
            System.out.println("[1] atacar [2] curar");
            int ac = acao.nextInt();
            //seleciono as acoes do player 
            switch (ac) {
                case 1:
                    p.ataque(rand.nextInt(1,10), e);
                    break;
            
                case 2:
                    p.curar(v);
                    break;
            }
            //inimigo ataca e logo em seguida é mostrado na tela os status de cada um
            e.atacar(rand.nextInt(1,10), p);
            System.out.println(p.toString());
            System.out.println(e.toString());

        }while(p.getVida() > 0 && e.getVida() > 0);
        //exibir tela de morte 
        if(p.getVida() > e.getVida()){
            System.out.println(e.tela());            
        }else{
            System.out.println(p.tela());            
        }
        acao.close(); 
        } 
    }


    public static boolean menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("----------ola--------");
        System.out.println("----seja bem-vindo---");
        System.out.println("-Voce deseja jogar?-");
        System.out.println("[1] sim [2] nao");
        int numero = sc.nextInt();
        
        if(numero == 1){
            return true;
        }else{
            return false;
        }
    }
}
//implementar o sistema de rounds das partidas 1v1 
//organizar melhor o output dos usuarios