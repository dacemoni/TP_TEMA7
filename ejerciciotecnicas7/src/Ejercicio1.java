import java.util.Random;
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void Lanzar() {
        Juego j = new Juego();
    }

}

class Dado {

    int caras;
    int ultimaCara;

    public Dado(int caras) {
        this.caras = caras;
    }

    public Dado() {
        this.caras = 6;
    }

    public int getCaras() {
        return this.caras;
    }

    public int getUltima() {
        return this.ultimaCara;
    }

    public void lanzar() {
        Random r = new Random();
        this.ultimaCara = r.nextInt(caras + 1);
        if (ultimaCara == 0) {
            lanzar();
        }
        System.out.println("Dado de " + this.caras + " caras sacó " + this.ultimaCara);
    }
}

class Juego {

    public Juego() {
        int suma = 0;
        Dado d6 = new Dado();
        Dado d10 = new Dado(10);
        Dado d12 = new Dado(12);
        do {
            d6.lanzar();
            d10.lanzar();
            d12.lanzar();

            suma = d6.getUltima() + d10.getUltima() + d12.getUltima();
            System.out.println("La suma es: " + suma);
        } while (suma < 20);
        System.out.println("Acabó el juego");
    }

}
