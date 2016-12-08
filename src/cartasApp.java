import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dam on 22/11/16.
 */
public class cartasApp {
    public static List <Carta> cartasDisponibles= new ArrayList<Carta>();
    public static List <Jugador> jugadores= new ArrayList<Jugador>();
    public static void main(String[] args) {
        Tropa tropa1 = new Tropa("Stormtrooper",2,60,60);
        Tropa tropa2 = new Tropa("Koopa",3, 65, 80);
        Tropa tropa3 = new Tropa("Pikmin", 3, 40, 90);
        Estructura estructura1 = new Estructura("Ciudadela",5,90,40);
        Estructura estructura2 = new Estructura("Foso", 3, 70, 20);
        Estructura estructura3 = new Estructura("Torre", 4, 80,25);
        Hechizo hechizo1 = new Hechizo("Piroexplosion", 5, 30, 100, true);
        Hechizo hechizo2 = new Hechizo("Corrosion",3,30, 50, true);
        Hechizo hechizo3 = new Hechizo("Muro mexicano", 4, 30, 75, false);
        cartasDisponibles.add(tropa1);
        cartasDisponibles.add(tropa2);
        cartasDisponibles.add(tropa3);
        cartasDisponibles.add(estructura1);
        cartasDisponibles.add(estructura2);
        cartasDisponibles.add(estructura3);
        cartasDisponibles.add(hechizo1);
        cartasDisponibles.add(hechizo2);
        cartasDisponibles.add(hechizo3);
        Jugador jugador1 = new Jugador("TochterDesMondes", "1");
        Jugador jugador2 = new Jugador("Bimu", "2");
        Jugador jugador3 = new Jugador("lolrol1", "3");
        Jugador jugador4 = new Jugador("Shertock", "4");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        elegirOpcion();
    }
    public static void elegirOpcion() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = pedirEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    conseguirCartas();
                    break;
                case 2:
                    batalla();
                    break;
                case 3:
                    ranking();
                    break;
                case 4:
                    System.out.println("Gracias por jugar :)");
                    break;
                default:
                    System.out.println("Opción incorrecta!");
                    break;
            }
        } while (opcion != 4);
    }
    public static void mostrarMenu(){
        System.out.println("1. Conseguir cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking");
        System.out.println("4. Salir");
    }
    public static int pedirEntero(String mensaje) {
        // Variable para leer datos del teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Variable para guardar el nº introducido por el usuario
        int numero = 0;
        // variable para comprobar si ha habido error al introducir el nº
        boolean error;
        do {
            try {
                // mostramos el msg para el usuario para pedir dato
                System.out.println(mensaje);
                // Leemos dato del teclado y lo convertimos a entero
                numero = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada y salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
        } while (error);
        return numero;
    }
    public static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                respuesta = br.readLine();
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida");
                error = true;
            }
        } while (error);
        return respuesta;
    }
    public static void conseguirCartas(){
        Jugador player1 = pedirJugador();

        System.out.println(cartasDisponibles);
        do {
            añadirCarta(player1);
        }while(player1.getCartasObtenidas().size()<6);

        for (int i = 0; i<jugadores.size(); i++){
            System.out.println( jugadores.get(i).getUsuario());
            System.out.println(jugadores.get(i).getCartasObtenidas());
        }
    }

    public static Jugador pedirJugador(){
        Jugador player1 = null;
        String usu;
        boolean usue = true;
        do {
            usu = pedirCadena("Usuario: ");
            for (Jugador j: jugadores) {
                if (usu.equalsIgnoreCase(j.getUsuario()) && usue==true) {
                    usue = false;
                    player1 = j;
                }
            }
        }while (usue);
        String pass;
        boolean passe = true;
        do {
            pass = pedirCadena("Password: ");
            if (pass.equalsIgnoreCase(player1.getPassword()) && passe==true) {
                passe = false;
            }
        }while (passe);
        return player1;
    }

    public static void añadirCarta (Jugador player1){
        if (player1.getCartasObtenidas().size()<6){
            boolean obtener = false;
            Carta aux= null;
            String ncarta;
            System.out.println("Tienes "+player1.getCartasObtenidas().size()+" cartas en tu mazo");
            ncarta = pedirCadena("Escribe el nombre de la carta que quieres añadir a tu mazo");
            for (Carta c: cartasDisponibles){
                if (ncarta.equalsIgnoreCase(c.getNombre())) {
                    aux = c;
                    for (int i=0; i<player1.getCartasObtenidas().size();i++){
                        if (player1.getCartasObtenidas().get(i) == c){
                            System.out.println("La carta ya la tienes añadida");
                            obtener = true;
                        }
                    }
                }
            }
            if (obtener == false)
                player1.getCartasObtenidas().add(aux);
        }
    }
    public static void ranking(){
        Collections.sort(jugadores);
        //for para imprimir el ranking
        for(Jugador j: jugadores){
            System.out.println(j.getUsuario()+", trofeos: "+j.getTrofeos());
        }
    }
    public static void batalla(){
        Jugador player1 = pedirJugador();
        Jugador player2 = null;
        do {
            player2 = pedirJugador();
        }while (player1 != player2);
       while (player1.getCartasObtenidas().size()<3){
           System.out.println("No tienes sufientes cartas en tu mazo");
           añadirCarta(player1);
       }
        while (player2.getCartasObtenidas().size()<3){
            System.out.println("No tienes sufientes cartas en tu mazo");
            añadirCarta(player2);
        }
        List<Carta> cartasJugador1 = new ArrayList<>();
        List<Carta> cartasJugador2 = new ArrayList<>();

        boolean obtener = false;
        Carta aux= null;
            String ncarta;
        int sumaelixir = 0;
        int contadorcartas = 0;
        System.out.println(player1.getCartasObtenidas());
        do {
            obtener = false;
            aux= null;
            System.out.println("Tienes " + cartasJugador1.size() + " cartas en tu mazo de pelea");
            ncarta = pedirCadena("Escribe el nombre de la carta que quieres usar en la pelea");
            for (Carta c : player1.getCartasObtenidas()) {
                if (ncarta.equalsIgnoreCase(c.getNombre())) {
                    aux = c;
                    for (int i = 0; i < cartasJugador1.size(); i++) {
                        if (cartasJugador1.get(i) == c) {
                            System.out.println("La carta ya la tienes añadida");
                            obtener = true;
                        }
                    }
                }
            }
            if (obtener == false && sumaelixir + aux.getElixir() < 11) {
                cartasJugador1.add(aux);
                contadorcartas++;
                sumaelixir += aux.getElixir();
            } else {
                System.out.println("El elixir maximo permitido es 10");
            }
        }while (contadorcartas<3);
        sumaelixir = 0;
        contadorcartas = 0;
        System.out.println(player2.getCartasObtenidas());
        do {
            obtener = false;
            aux= null;
            System.out.println("Tienes " + cartasJugador2.size() + " cartas en tu mazo de pelea");
            ncarta = pedirCadena("Escribe el nombre de la carta que quieres usar en la pelea");
            for (Carta c : player2.getCartasObtenidas()) {
                if (ncarta.equalsIgnoreCase(c.getNombre())) {
                    aux = c;
                    for (int i = 0; i < cartasJugador2.size(); i++) {
                        if (cartasJugador2.get(i) == c) {
                            System.out.println("La carta ya la tienes añadida");
                            obtener = true;
                        }
                    }
                }
            }
            if (obtener == false && sumaelixir + aux.getElixir() < 11) {
                cartasJugador2.add(aux);
                contadorcartas++;
                sumaelixir += aux.getElixir();
            } else {
                System.out.println("El elixir maximo permitido es 10");
            }
        }while (contadorcartas<3);
        int rnd = (int) Math.random()*2 + 1;
        // dejo el random hecho por si lo quieres pero no lo usare ya que no es necesario
// el resultado de la batalla sera el mismo empieze quien empiece y sin importar el orden de las cartas ya que no mueren
        int sumaAtaqueJ1 = 0;
        int sumaVidaJ1 = 0;
        int sumaAtaqueJ2 = 0;
        int sumaVidaJ2 = 0;
        Hechizo z;
        Tropa t;
        Estructura e;
        for (int i = 0; i <cartasJugador1.size();i++){
            sumaVidaJ1 += cartasJugador1.get(i).getVida();
            if (cartasJugador1.get(i).getClass() == Tropa.class){
                t = (Tropa) cartasJugador1.get(i);
                sumaAtaqueJ1 += t.accion();
            }
            if (cartasJugador1.get(i).getClass() == Estructura.class){
                e = (Estructura) cartasJugador1.get(i);
                sumaVidaJ1 += e.accion();
            }
            if (cartasJugador1.get(i).getClass() == Hechizo.class){
                z = (Hechizo) cartasJugador1.get(i);
                if (z.getAtaque())
                    sumaAtaqueJ1 += z.accion();
                else
                    sumaVidaJ1 += z.accion();
            }
            sumaVidaJ2 += cartasJugador2.get(i).getVida();
            if (cartasJugador2.get(i).getClass() == Tropa.class){
                t = (Tropa) cartasJugador2.get(i);
                sumaAtaqueJ2 += t.accion();
            }
            if (cartasJugador2.get(i).getClass() == Estructura.class){
                e = (Estructura) cartasJugador2.get(i);
                sumaVidaJ2 += e.accion();
            }
            if (cartasJugador2.get(i).getClass() == Hechizo.class){
                z = (Hechizo) cartasJugador2.get(i);
                if (z.getAtaque())
                    sumaAtaqueJ2 += z.accion();
                else
                    sumaVidaJ2 += z.accion();
            }
        }
        sumaVidaJ1 = sumaVidaJ1 - sumaAtaqueJ2;
        sumaVidaJ2 = sumaVidaJ2 - sumaAtaqueJ1;
        if (sumaVidaJ1>sumaVidaJ2){
            System.out.println("Gana el jugador 1 porque ha acabado con un total de " + (sumaVidaJ1-sumaVidaJ2) + " puntos de vida totales mas que el jugador 2");
        }else if (sumaVidaJ2>sumaVidaJ1){
            System.out.println("Gana el jugador 2 porque ha acabado con un total de " + (sumaVidaJ2-sumaVidaJ1) + " puntos de vida totales mas que el jugador 1");
        }else {
            System.out.println("Empate! los dos habeis acabado con la misma vida total");
        }

    }
}
