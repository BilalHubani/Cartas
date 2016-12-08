/**
 * Created by dam on 22/11/16.
 */
public class Hechizo extends Carta{
    private int alcance;
    private Boolean ataque; //true si es modo ataque, false modo defensa

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public Boolean getAtaque() {
        return ataque;
    }

    public void setAtaque(Boolean ataque) {
        this.ataque = ataque;
    }

    public Hechizo(String nombre, int elixir, int vida, int alcance, Boolean ataque) {
        super(nombre, elixir, vida);
        this.alcance = alcance;
        this.ataque = ataque;
    }

    @Override
    public int accion() {
        // multiplico por tres debido a que afectara a 3 cartas
            return this.alcance*2/3*3;
    }

    @Override
    public String toString() {
        return "Hechizo{"  + super.toString()+
                " alcance=" + alcance +
                ", ataque=" + ataque +
                "} \n";
    }
}
