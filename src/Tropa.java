/**
 * Created by dam on 22/11/16.
 */
public class Tropa extends Carta{
    private int ataque;

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public Tropa(String nombre, int elixir, int vida, int ataque) {
        super(nombre, elixir, vida);
        this.ataque = ataque;
    }
}
