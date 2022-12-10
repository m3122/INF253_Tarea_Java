

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Mapa {
    private int profundidad;
    private NodoInicial nodo_inicial; // No supe como implementar el nodo inicial en ningun metodo del mapa, por eso no es utilizado.
    private List<Nodo> nodos_mapa = new ArrayList<Nodo>();
    private int idNodoActual;
    
    /* 
    void preguntarProfundidad: le pregunta al usuario la profundidad que quiere para el mapa

    Scanner userin: objeto necesario para pedir 

    return void: no retorna nada
    */

    public void preguntarProfundidad(Scanner userin){
        int aux = 0;
        System.out.println("Cual es la profundidad del mapa?");
        while (aux < 3){
            aux = userin.nextInt();
            if (aux < 3){
                System.out.println("La profundidad no puede ser menor a 3. Introduzca una nueva profundidad.");
            }
        }
        this.profundidad = aux;
    }

    /* 
    void crearMapa: constructor del mapa, considerando la profundidad y las probabilidades de aparicion de nodos.

    esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void crearMapa(){
        this.idNodoActual = 0;
        int i;
        SortedSet<Integer> track = new TreeSet<Integer>();
        SortedSet<Edge> edges = GraphGenerator.Generar(this.profundidad);
        for (Edge e : edges){
            i = e.x;
            if (track.contains(i)==false){
                track.add(i);
                if (i == 0){
                    nodos_mapa.add(new NodoInicial());
                    nodos_mapa.get(i).setId(i);
                }
                else {
                    Random rand = new Random();
                    int chance = rand.nextInt(10);
                    if (chance < 1){
                        nodos_mapa.add(new NodoTienda());
                        nodos_mapa.get(i).setId(i);
                    }
                    else if (chance > 0 && chance < 4){
                        nodos_mapa.add(new NodoEvento());
                        nodos_mapa.get(i).setId(i); 
                    }
                    else{
                        nodos_mapa.add(new NodoCombate());
                        nodos_mapa.get(i).setId(i);
                    }
                }
            }
        }
        for (Edge e : edges){
            i = e.y;
            if (track.contains(i)==false){
                track.add(i);
                if (i != ((this.profundidad*2)+2)){
                    Random rand = new Random();
                    int chance = rand.nextInt(10);
                    if (chance < 1){
                        nodos_mapa.add(new NodoTienda());
                        nodos_mapa.get(i).setId(i);
                    }
                    else if (chance > 0 && chance < 4){
                        nodos_mapa.add(new NodoEvento());
                        nodos_mapa.get(i).setId(i); 
                    }
                    else{
                        nodos_mapa.add(new NodoCombate());
                        nodos_mapa.get(i).setId(i);
                    }
                }
                else {
                    nodos_mapa.add(new NodoJefeFinal());
                    nodos_mapa.get(i).setId(i);
                }
            }
        }


        for (Edge e : edges){
            nodos_mapa.get(e.x).agregarNodo(nodos_mapa.get(e.y));
        }
    }

    /* 
    void verMapa: muestra el mapa por salida estandar asi como tambien el nodo en el que esta el jugador.

    esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void verMapa(){
        System.out.println("Estas en: ("+this.idNodoActual+")");
        for (Nodo n : nodos_mapa){
            for (Nodo m : n.verSiguientes()){
                System.out.println(n.getName()+" ("+n.getId()+") -> "+m.getName()+" ("+m.getId()+")");
            }
        }
    }

    /* 
    void avanzar: Funcion que implementa el "menu" del juego. Le deja al usuario elegir entre diversas opciones, la mas importante la de "Avanzar"
    que mueve al jugador al nodo deseado e interactua con el.

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */

    public void Avanzar(Jugador jug, Scanner userin){
        int respuesta;
        System.out.println("(0) Ver estado   (1) Avanzar   (2) Ver mapa   (3) Ver Items  (4) Rendirse");
        respuesta = userin.nextInt();
        
        if (respuesta == 4){
            System.out.println("Perdiste :(");
            jug.ganar();
        }

        if (respuesta == 3){
            jug.veritems();
        }

        if (respuesta == 0){
            jug.verEstado();
        }

        if (respuesta == 2){
            this.verMapa();
        }

        if (respuesta == 1){
            for (Nodo m : nodos_mapa.get(idNodoActual).verSiguientes()){
                System.out.println(nodos_mapa.get(idNodoActual).getName()+" ("+nodos_mapa.get(idNodoActual).getId()+") -> "+m.getName()+" ("+m.getId()+")");
            }
            System.out.println("Adonde vamos?");
            int camino;
            camino = userin.nextInt();
            
            this.idNodoActual = camino;
            nodos_mapa.get(idNodoActual).interactuar(jug, userin);
        }
    }
}
