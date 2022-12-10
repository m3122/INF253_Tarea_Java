import java.util.Random;
import java.util.Scanner;

public class NodoCombate extends Nodo{
    private String name = "Combate";
    private Personaje enemigo;

    //Get del name
    public String getName(){
        return this.name;
    }

    /* 
    void crearEnemigo: Constructor del objeto Enemigo. Le atribuye stats random dentro de un cierto rango.

    Esta funcion no tiene parametros.

    return void: no retorna nada
    */
    
    public void crearEnemigo(){
        enemigo = new Personaje();
        Random rand = new Random();
        int hp = rand.nextInt(1, 6);
        int dan = rand.nextInt(1, 3);
        int def = rand.nextInt(0, 3);
        enemigo.nuevoPersonaje("Enemigo", 0, hp, hp, dan, def);
    }

    /* 
    void verEnemigo: Muestra las stats del Enemigo

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void verEnemigo(){
        enemigo.verStatus();
    }

    /* 
    void interactuar: crea un enemigo, lo muestra e inicia un combate entre el jugador y este.

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */

    public void interactuar(Jugador jug, Scanner userin){
        System.out.println("Cuidado! Un enemigo!");
        this.crearEnemigo();
        this.verEnemigo();
        jug.combate(enemigo);
    }
}
