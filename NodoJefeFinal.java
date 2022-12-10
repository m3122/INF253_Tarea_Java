import java.util.Random;
import java.util.Scanner;

public class NodoJefeFinal extends Nodo{
    private String name = "Jefe final";
    private Personaje Jefe;


    //Get del name
    public String getName(){
        return this.name;
    }

    /* 
    void crearJefe: Constructor del objeto Jefe con stats aleatorias. Es lo mismo que el enemigo pero mas poderoso.

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void crearJefe(){
        Jefe = new Personaje();
        Random rand = new Random();
        int hp = rand.nextInt(20, 30);
        int dan = rand.nextInt(7, 14);
        int def = rand.nextInt(0, 5);
        Jefe.nuevoPersonaje("Jefazo", 0, hp, hp, dan, def);
    }

    /* 
    void verJefe: Muestra las stats del Jefe por pantalla.

    Esta funcion no tiene parametros

    return void: no retorna nada
    */
    
    public void verJefe(){
        Jefe.verStatus();
    }

    /* 
    void interactuar: crea un Jefe, lo muestra por pantalla y comienza un combate entre este y el jugador.
    Ademas muestra un mensaje de felicidades si es derrotado.

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */

    public void interactuar(Jugador jug, Scanner userin){
        this.crearJefe();
        this.verJefe();
        jug.combate(Jefe);
        if (jug.verVida() > 0){
            System.out.println("FELICIDADES ^.^");
            jug.ganar();
        }
    }
}
