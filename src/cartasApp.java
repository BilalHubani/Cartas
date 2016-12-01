import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam on 22/11/16.
 */
public class cartasApp {
    public static void main(String[] args) {
        List <Carta> cartasDisponibles= new ArrayList<Carta>();
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
        List <Jugador> jugadores= new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador("TochterDesMondes", "1");
        Jugador jugador2 = new Jugador("Bimu", "2");
        Jugador jugador3 = new Jugador("lolrol1", "3");
        Jugador jugador4 = new Jugador("Shertock", "4");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

    }
    public static void elegirOpcion() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = pedirEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    nuevoPresupuesto();
                    break;
                case 3:
                    presupuestosPorEstado("pendiente");
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
        System.out.println("1. Alta cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuestos pendientes (de aceptar o rechazar)");

        System.out.println("8. Salir");
    }
}
