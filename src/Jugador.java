import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam on 22/11/16.
 */
public class Jugador implements Comparable<Jugador>{
    private String usuario;
    private String password;
    private int trofeos;
    private List <Carta> cartasObtenidas = new ArrayList<>();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    public List<Carta> getCartasObtenidas() {
        return cartasObtenidas;
    }

    public void setCartasObtenidas(List<Carta> cartasObtenidas) {
        this.cartasObtenidas = cartasObtenidas;
    }

    public Jugador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.trofeos = 0;
    }

    @Override
    public int compareTo(Jugador o) {
        if (trofeos > o.getTrofeos()) {
            return -1;
        } else if (trofeos < o.getTrofeos()) {
            return 1;
        } else {
            return 0;
        }
    }
}
