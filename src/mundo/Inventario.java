package mundo;

public class Inventario {
    protected Armas arma;
    protected int pocao;
    

    public Inventario(Armas arma, int pocao){
        this.arma=arma;
        this.pocao=pocao;
    }

    public void mostra(){
        System.out.println("-----Inventario do player-----");
        System.out.println("_______________________________");
        System.out.println("Arma: " + this.arma);
        System.out.println(" Numero de pocoes: " + this.pocao);
        System.out.println("_______________________________");
    }

}
