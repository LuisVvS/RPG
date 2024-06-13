package mundo;
public class Player {
    protected String nome;
    protected int level, dano, vida, vmax;
    
    public Player(String nome, int level, int vida){
        this.nome=nome;
        this.level=level;
        this.vida=vida;
        this.vmax = vida;
        }


    public void ataque(int d,Enemy n){
        System.out.printf("O player %s está atacando", this.nome);
        n.setVida(n.getVida()-d);
    }

    public void curar(int pocao){
        System.out.printf("O player %s está se curando", this.nome);
        if(vida < vmax){
            this.setVida(pocao +  this.vida);
        }else{
            System.out.println("A vida do player ja esta no maximo");
        }
    }

    public String toString(){
        return "O player: " + this.nome + 
        " status de vida: "+ this.vida + " level: " + this.level + " vida maxima: " + this.vmax ;
    }

    public void setVida(int vida){
        this.vida=vida;
    }

    public int getVida(){
        return vida;
    }
}
//construir uma logica para a vida maxima e a vida do player, e arrumar o que fazer no projeto tambem