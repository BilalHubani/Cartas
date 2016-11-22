import java.util.List;

/**
 * Created by dam on 22/11/16.
 */
public class Jugador {
    private String usuario;
    private String password;
    private int trofeos;
    private List <Carta> cartasObtenidas;

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
}
