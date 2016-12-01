/**
 * Created by dam on 22/11/16.
 */
public class Estructura extends Carta{
    private int defensa;

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public Estructura(String nombre, int elixir, int vida, int defensa) {
        super(nombre, elixir, vida);
        this.defensa = defensa;
    }

    @Override
    public int accion() {
        return this.defensa+8;
    }
}
