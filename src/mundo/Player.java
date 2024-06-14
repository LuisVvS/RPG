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
         System.out.println("###########################################");        
        System.out.printf("O player %s está atacando e deu %d de dano \n", this.nome, d);
        n.setVida(n.getVida()-d);
    }


    public void curar(Inventario inv){
        if(inv.pocao > 0){
            if(vida < vmax){
                System.out.println("###########################################"); 
                System.out.printf("O player %s está se curando e curou %d de vida \n", this.nome, this.vmax-this.vida);
                this.setVida(this.vida += (this.vmax-this.vida));
                inv.pocao-=1;
            }else{
                System.out.println("###########################################");                                                                
                System.out.println("A vida do player ja esta no maximo \n");
                 System.out.println("###########################################");                
            }
        }else{
            System.out.println("O player não tem pocoes para se curar! \n pocoes podem ser compradas com mercadores");
        }
    }


    public String toString(){
        return "\nO player: " + this.nome + 
        "\n status de vida: "+ this.vida + "\n vida maxima: " + this.vmax ;
    }

    public void setVida(int vida){
        this.vida=vida;
    }

    public int getVida(){
        return vida;
    }
}