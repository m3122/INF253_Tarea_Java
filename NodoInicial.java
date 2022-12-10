import java.util.Scanner;

public class NodoInicial extends Nodo{
    private String name = "inicio";

    
    // Get del name
    public String getName(){
        return this.name;
    }

    /* 
    void interactuar: Muestra un texto de bienvenida

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */

    public void interactuar(Jugador jug, Scanner userin){
        System.out.println("bienvenido");
    }
    // Esta funcion esta muy poco elaborada ya que, como comenté en la clase de Mapa, no supe como implementar mi funcion de avanzar para utilizarla.
    // La introduccion y reglas del juego se encuentran en el Main.
}
