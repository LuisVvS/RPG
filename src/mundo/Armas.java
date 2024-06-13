package mundo;

public class Armas {
    protected String nome;
    protected int dano;

    public Armas(String nome, int dano){
        this.nome=nome;
        this.dano=dano;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getNome(){
        return nome;
    }

    public void setDano(int dano){
        this.dano=dano;
    }
    public int getDano(){
        return dano;
    }

    public String toString(){
        return "A arma: " + this.nome + " ,causa dano de: "+ this.dano;
    }
}
