
import java.util.ArrayList;
import java.util.List;

class Jugador extends Personaje{
    private boolean NoHaGanado = true;
    private List<Item> items_aplicados = new ArrayList<Item>();

    /* 
    void nuevoJugador: Constructor del objeto Jugador

    String name: Nombre que deberá tener el jugador

    return void: no retorna nada
    */

    public void nuevoJugador(String name){
        this.nuevoPersonaje(name, 500, 20, 20, 5, 1);
    }

    /* 
    void addItem: añade el item al inventario del jugador

    Item item: item que será añadido al inventario

    return void: no retorna nada
    */

    public void addItem(Item item){
        items_aplicados.add(item);
    }

    /* 
    void verItems: Muestra por salida estandar todos los items que tiene el jugador

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void veritems(){
        for (int i = 0; i < items_aplicados.size(); i++){
            System.out.println("Item "+(i+1)+":");
            items_aplicados.get(i).verItem();
        }
    }

    /* 
    void verEstado: muestra por salida estandar las estadisticas del jugador

    esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void verEstado(){
        this.verStatus();
    }

    /* 
    boolean noHaGanado: Getter del estado noHaGanado del jugador. Este estado es true si NO ha ganado

    esta funcion no tiene parametros

    return this.noHaGanado: El estado de la condicion de noHaGanado del jugador
    */

    public boolean noHaGanado(){
        return this.NoHaGanado;
    }

    /* 
    void ganar: setter del estado noHaGanado a false. Es decir, el jugador ganó.

    esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void ganar(){
        this.NoHaGanado = false;
    }
}
