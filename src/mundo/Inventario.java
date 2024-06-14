package mundo;

import java.util.ArrayList;

public class Inventario {
    protected Armas arma;
    protected int pocao;
    

    public Inventario(int pocao){
        this.pocao=pocao;
    }
    
    public void Acessar(){
        System.out.println("-----Inventario do player-----");
        System.out.println("_______________________________");
        System.out.println("Arma: " + this.arma);
        System.out.println(" Numero de pocoes: " + this.pocao);
        System.out.println("_______________________________");
    }

}
