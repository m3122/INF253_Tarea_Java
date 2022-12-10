

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Nodo {
    private int id;
    private String name = "Nodo";
    private List<Nodo> nodos_siguientes = new ArrayList<Nodo>();

    /* 
    void agregarNodo: Agrega un nodo a la lista de nodos siguientes.

    Nodo n: nodo a ser agregado

    return void: no retorna nada
    */

    public void agregarNodo(Nodo n){
        nodos_siguientes.add(n);
    }


    // Get de los nodos_siguientes
    public List<Nodo> verSiguientes(){
        return nodos_siguientes;
    }


    // Get del id
    public int getId(){ 
        return this.id;
    }


    // Set del id
    public void setId(int i){
        this.id = i;
    }
    

    // get del name
    public String getName(){
        return this.name;
    }
    
    /* 
    void interactuar: funcion abstract que servira para interactuar con las subclases de Nodo

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */
    abstract void interactuar(Jugador jug, Scanner userin);
}
