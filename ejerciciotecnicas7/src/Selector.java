import java.util.InputMismatchException;
import java.util.Scanner;
public class Selector {
    public static void Elegir(Scanner teclado){
int eleccion=0;
        while(true){
            System.out.println("1: Ejercicio 1 (Dados)");
            System.out.println("2: Ejercicio 2 (Clientes)");
            System.out.println("3: Ejercicio 3 (Barcos III)");
            System.out.println("4: Ejercicio 4 (Barcos IV)");
            
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
        case 3:
        	//Ejercicio3.juegoBarcos3(); // ej 3 y 4 no son staticos, como quieres hacerlos david?
        	Ejercicio3 asdf = new Ejercicio3();
        	asdf.juegoBarcos3();
        	break;
        	
        case 4:break;
        
        default:break;
    }
}
    }
}
