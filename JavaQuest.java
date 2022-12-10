
import java.util.Scanner;

public class JavaQuest {
    public static void main(String[] args) {
        Scanner userin = new Scanner(System.in);
        Jugador player = new Jugador();
        String nombre;
        System.out.println("Como te llamas?");
        nombre = userin.nextLine();
        player.nuevoJugador(nombre);
        Mapa map = new Mapa();
        map.preguntarProfundidad(userin);
        map.crearMapa();
        System.out.println("Bienvenid@ a JavaQuest!\nEn esta aventura tendras que batirte a duelo con formidables enemigos y conseguir mejoras en el camino.");
        System.out.println("Las instrucciones son simples: usualmente es seguir lo que dice la pantalla.");
        System.out.println("Para poder avanzar en la aventura tendrás que indicar el número que acompaña al piso que quieres ir.");
        System.out.println("'Combate (3)' <- ese número de ahí, en este caso es el 3");
        System.out.println("Disfruta del juego y buena suerte!");
        while (player.verVida() != 0 && player.noHaGanado()){
            map.Avanzar(player, userin);
        }
        if (player.verVida() == 0){
            System.out.println("perdiste :(");
        }
        userin.close();
    }
}