import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

                    break;
                case 3:

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
        System.out.println(cartasDisponibles);
        do {
            añadirCarta(player1);
        }while(player1.getCartasObtenidas().size()<6);

        for (int i = 0; i<jugadores.size(); i++){
            System.out.println( jugadores.get(i).getUsuario());
            System.out.println(jugadores.get(i).getCartasObtenidas());
        }
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
}
