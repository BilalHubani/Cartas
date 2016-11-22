import java.util.List;

/**
 * Created by dam on 22/11/16.
 */
public class cartasApp {
    public static void main(String[] args) {
        List <Carta> cartasDisponibles;
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
    }
}
