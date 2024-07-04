package mundo;

public class Armas {
    protected String nome;
    protected int dano;

    public Armas(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }
    //utilizo para mostrar a descrição da arma no invetario
    public String toString() {
        return "\nA descrição de item : " + 
        "\nNome: " +  this.nome 
        + "\ndano : " + this.dano+"\n";
    }
}
