

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NodoTienda extends Nodo{
    public String name = "Tienda";
    private List<Item> inventario = new ArrayList<Item>();
    
    /* 
    void inicializarTienda: Llena el inventario de la tienda con 10 Items de estadisticas aleatorias

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void inicializarTienda(){
        int pre;
        int rec;
        int aumhp;
        int aumdan;
        int aumdef;
        int i;
        Random rand = new Random();
        for (i=0; i<10; i++){
            inventario.add(new Item());
            pre = rand.nextInt(30, 101);
            rec = rand.nextInt(21);
            aumhp = rand.nextInt(11);
            aumdan = rand.nextInt(6);
            aumdef = rand.nextInt(6);
            inventario.get(i).crearItem(pre, rec, aumhp, aumdan, aumdef);
        }
    }


    // Get del name
    public String getName(){
        return this.name;
    }

    /* 
    void mostrarItems: Muestra de 5 a 8 Items y sus Stats uno a uno. Tambien el dinero actual del Jugador

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.

    return void: no retorna nada
    */

    public void mostrarItems(Jugador jug){
        System.out.println("Tu dinero: "+jug.verDinero()+"$");
        Random rand = new Random();
        int cant = rand.nextInt(5, 9);
        int i;
        for (i=0; i<cant; i++){
            System.out.println("Item "+(i+1));
            inventario.get(i).verItem();
        }
    }

    /* 
    void comprar: Aplica el item deseado al Jugador.

    int i: indice del item que el jugador quiere.
    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.

    return void: no retorna nada
    */

    public void comprar(int i, Jugador jug){
        inventario.get(i-1).aplicar(jug);
    }

    /* 
    void interactuar: Crea una tienda con items aleatorios, los muestra y le pregunta al usuario cual quiere comprar

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */

    public void interactuar(Jugador jug, Scanner userin){
        boolean flag = true;
        this.inicializarTienda();
        this.mostrarItems(jug);
        System.out.println("Cual quieres?\nSi no quieres nada pon '0'");
        int respuesta;
        respuesta = userin.nextInt();
        while (respuesta > 0){
            while ((jug.verDinero() < inventario.get(respuesta).verPrecio() && flag)){
                System.out.println("No te alcanza para eso :(");
                System.out.println("Quieres otro? ");
                respuesta = userin.nextInt();
                if (respuesta == 0){
                    flag = false;
                }
            }
            if (flag == true){
                this.comprar(respuesta, jug);
                System.out.println("Objeto adquirido!");
                System.out.println("Tu dinero: "+jug.verDinero()+"$");
                System.out.println("Quieres otro? ");
                respuesta = userin.nextInt();
            }
            
        }
    }
    
}
