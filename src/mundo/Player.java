package mundo;


public class Player {
    protected String nome;
    protected int level,vmax, vida, dano;
    
    public Player(String nome, int level, int vmax, int vida, int dano){
        this.nome=nome;
        this.level=level;
        this.vmax=vmax;
        this.vida=vida;
        this.dano=dano;
    }    


    public void ataque(){
        System.out.printf("O player %s está atacando", this.nome);
    }

    public void curar(int pocao){
        System.out.printf("O player %s está se curando", this.nome);
        if(vida < vmax){
            vida+=pocao;
        }else{
            System.out.println("A vida do player ja esta no maximo");
        }
        
    }

}

//construir uma logica para a vida maxima e a vida do player, e arrumar o que fazer no projeto tambem
