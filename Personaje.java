

import java.util.Random;

public class Personaje {
    private String nombre;
    private int dinero;
    private int hp_actual;
    private int hp_total;
    private int danio;
    private int defensa;

    /* 
    void nuevoPersonaje: Crea un nuevo personaje con las estadisticas indicadas.

    String name: nombre del personaje
    int din: dinero del personaje
    int hpa: vida actual del personaje
    int hpt: vida maxima del personaje
    int dan: daño del personaje
    int def: defensa del personaje

    return void: no retorna nada
    */

    public void nuevoPersonaje(String name, int din, int hpa, int hpt, int dan, int def){
        nombre = name;
        dinero = din;
        hp_actual = hpa;
        hp_total = hpt;
        danio = dan;
        defensa = def;
    }

    /* 
    void verStatus: muestra las stats del personaje por pantalla

    Esta funcion no tiene parametros

    return void: no retorna nada
    */

    public void verStatus(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Dinero: "+dinero);
        System.out.println("Vida: "+hp_actual);
        System.out.println("Vida maxim: "+hp_total);
        System.out.println("Daño: "+danio);
        System.out.println("Defensa: "+defensa);
    }


    // get del dinero
    public int verDinero(){
        return this.dinero;
    }


    // get de la vida maxima
    public int verVidaMax(){
        return this.hp_total;
    }
    

    // get de la vida actual
    public int verVida(){
        return this.hp_actual;
    }


    // get del daño
    public int verDanio(){
        return this.danio;
    }


    // get de la defensa
    public int verDef(){
        return this.defensa;
    }

    /* 
    void pagar: añade dinero al personaje

    int din: cantidad de dinero a agregar al personaje

    return void: no retorna nada
    */

    public void pagar(int din){
        dinero = dinero + din;
    }

    /* 
    void cobrar: quita dinero al personaje

    int din: cantidad de dinero a quitar al personaje

    return void: no retorna nada
    */

    public void cobrar(int pre){
        dinero = dinero - pre;
    }
    
    /* 
    void sanar: añade vida al personaje. No puede superar la vida maxima.

    int hp: cantidad de vida a agregar al personaje

    return void: no retorna nada
    */

    public void sanar(int hp){
        hp_actual = hp_actual + hp;
        if (hp_actual > hp_total){
            hp_actual = hp_total;
        }
    }

    /* 
    void danar: quita vida al personaje

    int din: cantidad de dinero a agregar al personaje

    return void: no retorna nada
    */

    public void danar(int dan){
        this.hp_actual = this.hp_actual - dan;
        if (this.hp_actual < 0){
            this.hp_actual = 0;
        }
    }

    /* 
    void buf_dmg: agrega daño al personaje.

    int dan: cantidad de daño a agregar al personaje

    return void: no retorna nada
    */

    public void buf_dmg(int dan){
        danio = danio + dan;
    }

    /* 
    void buf_def: agrega defensa al personaje.

    int den: cantidad de defensa a agregar al personaje

    return void: no retorna nada
    */

    public void buf_def(int def){
        defensa = defensa + def;
    }

    /* 
    void buf_vida: agrega vida maxima al personaje.

    int hp: cantidad de vida a agregar al personaje

    return void: no retorna nada
    */

    public void buf_vida(int hp){
        hp_total = hp_total + hp;
        hp_actual = hp_actual + hp;
    }

    /* 
    void debuf_vida: quita vida maxima al personaje.

    int hp: cantidad de vida a quitar al personaje

    return void: no retorna nada
    */

    public void debuf_vida(int hp){
        hp_total = hp_total - hp;
        if (hp_actual > hp_total){
            hp_actual = hp_total;
        }
    }

    /* 
    void combate: inicia un combate entre 2 personajes.

    Personaje per: Personaje a combatir.

    return void: no retorna nada
    */

    public void combate(Personaje per){
        Random rand = new Random();
        int danoin;
        int danoout;
        int chance = rand.nextInt(1);
        if (chance == 0){
            while(this.verVida() > 0 && per.verVida() > 0){
                danoin = per.verDanio() - this.verDef();
                if (danoin > 0){
                    this.danar(danoin);
                    System.out.println("Te pegaron "+danoin+" de daño");
                }
                else{
                    per.danar(per.verVida());
                }

                danoout = this.verDanio() - per.verDef();
                if (danoout > 0){
                    per.danar(danoout);
                    System.out.println("Le hiciste "+danoout+" de daño al enemigo");
                }
                else{
                    this.danar(this.verVida());
                }
                System.out.println("Tu vida: "+this.verVida());
                System.out.println("Vida del enemigo: "+per.verVida());
            }
        }
        else {
            while(this.verVida() > 0 && per.verVida() > 0){
                danoout = this.verDanio() - per.verDef();
                if (danoout > 0){
                    per.danar(danoout);
                    System.out.println("Le hiciste "+danoout+" de daño al enemigo");
                }
                else{
                    System.out.println("Te diste cuenta que tus ataques son inutiles contra el enemigo. Tomas la salida facil.");
                    this.danar(this.verVida());
                }

                danoin = per.verDanio() - this.verDef();
                if (danoin > 0){
                    this.danar(danoin);
                    System.out.println("Te pegaron "+danoin+" de daño");
                }
                else{
                    System.out.println("Los ataques del enemigo son inutiles contra ti asi que optó por suicidarse");
                    per.danar(per.verVida());
                }

                System.out.println("Tu vida: "+this.verVida());
                System.out.println("Vida del enemigo: "+per.verVida());
            }
        }
    }
}
