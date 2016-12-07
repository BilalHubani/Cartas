/**
 * Created by dam on 22/11/16.
 */
public class Carta {
    private String nombre;
    private int elixir;
    private int vida;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getElixir() {
        return elixir;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Carta(String nombre, int elixir, int vida) {
        this.nombre = nombre;
        this.elixir = elixir;
        this.vida = vida;
    }
    public int accion(){
        return 0;
    }

    @Override
    public String toString() {
        return "" +
                "nombre='" + nombre + '\'' +
                ", elixir=" + elixir +
                ", vida=" + vida
                ;
    }
}
