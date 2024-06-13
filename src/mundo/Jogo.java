package mundo;

public class Jogo {
    public static void main(String[] args) {
        Player p = new Player("Luis", 0, 20);
        p.ataque();
        p.curar(12);
    }    
}
