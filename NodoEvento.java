import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NodoEvento extends Nodo{
    private String name = "Evento";
    private List<String> opciones = new ArrayList<String>();
    private List<String> recompensas = new ArrayList<String>();
    private String descripcion;
    private int idCaso;


    // get del name
    public String getName(){
        return this.name;
    }
    
    /* 
    void icrearEvento: Inicializa un Evento aleatorio dentro de 3 posibles casos.

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void crearEvento(){
        Random rand = new Random();
        int id = rand.nextInt(3);
        if(id == 0){
            this.idCaso = id;
            this.descripcion = "Te has encontrado con un hombre desesperado y malherido pidiendo ayuda. ¿Que haras?";
            this.opciones.add("(1) Ayudarlo");
            this.opciones.add("(2) Pegarle");
            this.recompensas.add("Un Item");
            this.recompensas.add("+150$");
        }
        if(id == 1){
            this.idCaso = id;
            this.descripcion = "Pasas por afuera de un carrito de sopaipillas. Piensas en saborear una de esas suculentas fritangas.\n¿Que haras?";
            this.opciones.add("(1) Comprar una (-40$)");
            this.opciones.add("(2) Pasar de largo (estas a dieta)");
            this.recompensas.add("Cura total");
            this.recompensas.add("Nada xd");
        }
        if(id == 2){
            this.idCaso = id;
            this.descripcion = "Ibas caminando sin cuidado y tropiezas...";
            this.opciones.add("(1) Tratar de parar la caida con las manos");
            this.opciones.add("(2) Aceptar tu destino y caer de cara");
            this.recompensas.add("Recibe 6 de daño");
            this.recompensas.add("Pierde 2 de vida máxima");
        }
    }
    
    /* 
    void mostrarEvento: Muestra la descripcion del evento, sus opciones y sus respectivas recompensas

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void mostrarEvento(){
        System.out.println(this.descripcion);
        System.out.println(this.opciones.get(0)+" -> "+this.recompensas.get(0));
        System.out.println(this.opciones.get(1)+" -> "+this.recompensas.get(1));
    }

    /* 
    void interactuar: crea un evento aleatorio, lo muestra por pantalla y le pide al usuario que escoja una opcion para actuar.

    Jugador jug: Objeto de tipo Jugador, es el jugador de la partida.
    Scanner userin: objeto tipo Scanner que deja al usuario proveer inputs para el funcionamiento del programa.

    return void: no retorna nada
    */

    public void interactuar(Jugador jug, Scanner userin){
        int respuesta = 3;
        this.crearEvento();
        this.mostrarEvento();
        while (respuesta != 1 && respuesta != 2){
            System.out.println("Introduce el número de la opción que quieras");
            respuesta = userin.nextInt();
            if (respuesta != 1 && respuesta != 2){
                System.out.println("Esa respuesta es invalida :(");
            }
        }

        if (this.idCaso == 0){
            if (respuesta == 1){
                // itemaleatorio
                Item item = new Item();
                item.crearItem(0, 0, 0, 5, 5);
                item.aplicar(jug);
            }
            if (respuesta == 2){
                // mas 150
                jug.pagar(150);
            }
        }

        if (this.idCaso == 1){
            if (respuesta == 1){
                // cobrar 40 sanar
                int din = jug.verDinero();
                if (din >= 40){
                    jug.cobrar(40);
                    int vida = jug.verVidaMax();
                    jug.sanar(vida);
                    System.out.println("Sopaipilla adquirida");
                }
                else{
                    System.out.println("Lastima, no te alcanza :(");
                }
                
            }
            if (respuesta == 2){
                System.out.println("Sigues tu camino");
            }
        }

        if (this.idCaso == 2){
            if (respuesta == 1){
                //6 de daño
                jug.danar(6);
            }
            if (respuesta == 2){
                //-2 max
                jug.debuf_vida(2);
            }
        }
    }
}
