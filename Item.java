
public class Item {
    private int precio;
    private int recuperar_hp;
    private int aumentar_hp_total;
    private int aumentar_danio;
    private int aumentar_defensa;

    /* 
    void crearItem: constructor del objeto Item

    int pre: Precio del item
    int rec: vide que cura el item
    int aum_hp: vida maxima que aumenta el item
    int aum_dan: cantidad de daño que aumenta el item
    int aum_def: cantidad de defensa que aumenta el item

    return void: no retorna nada
    */

    public void crearItem(int pre, int rec, int aum_hp, int aum_dan, int aum_def){
        precio = pre;
        recuperar_hp = rec;
        aumentar_hp_total = aum_hp;
        aumentar_danio = aum_dan;
        aumentar_defensa = aum_def;
    }

    /* 
    void aplicar: Le aplica el item al jugador

    Jugador jug: objeto tipo Jugador al que se le aplicara el item.

    return void: no retorna nada
    */

    public void aplicar(Jugador jug){
        jug.cobrar(precio);
        jug.buf_vida(aumentar_hp_total);
        jug.sanar(recuperar_hp);
        jug.buf_dmg(aumentar_danio);
        jug.buf_def(aumentar_defensa);
        jug.addItem(this);
    }

    /* 
    void verItem: muestra por salida estandar las estadisticas del item

    Esta funcion no recibe parametros

    return void: no retorna nada
    */

    public void verItem(){
        System.out.println("Precio: "+precio);
        System.out.println("Recuperar hp: "+recuperar_hp);
        System.out.println("Aumentar hp total: "+aumentar_hp_total);
        System.out.println("Aumentar danio: "+aumentar_danio);
        System.out.println("Aumentar defensa: "+aumentar_defensa);
    }

    /* 
    int verPrecio: Getter del precio de un item

    esta funcion no tiene parametros

    return precio: el precio del item
    */

    public int verPrecio(){
        return this.precio;
    }
}
