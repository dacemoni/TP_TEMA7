import java.util.InputMismatchException;
import java.util.Scanner;
public class Selector {
    public static void Elegir(Scanner teclado){
int eleccion=0;
        while(true){
            System.out.println("1: Ejercicio 1 (Dados)");
            System.out.println("2: Ejercicio 2 (Clientes)");
            
    try{
        eleccion=teclado.nextInt();
    }catch(InputMismatchException e){
        teclado.next();
    }
    switch(eleccion){
        case 1: Ejercicio1.Lanzar();
        break;
        case 2:Ejercicio2.Lanzar(teclado);
        break;
        case 3:break;
        case 4:break;
        
        default:break;
    }
}
    }
}
