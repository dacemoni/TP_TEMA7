import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void Lanzar(Scanner teclado) {

        Menu m = new Menu(teclado);
    }
}

class Cliente {

    private static int contador = 0;
    String nombre;
    int id = 0;

    public Cliente() {
        contador++;
        this.id = contador;
    }

    public Cliente(String n) {
        contador++;
        this.nombre = n;
        this.id = contador;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Cliente nº" + this.id;
        s += "[" + this.nombre + "]";
        return s;
    }
}

class gestorClientes {

    ArrayList<Cliente> listaClientes;

    public gestorClientes() {
        listaClientes = new ArrayList();
    }

    public void crearCliente(Scanner teclado) {
        System.out.println("Introduce el nombre del cliente");
        String nombre = teclado.next();
        Cliente c = new Cliente(nombre);
        listaClientes.add(c);
        System.out.println("Cliente nº" + c.id + "[" + c.getNombre() + "] añadido");

    }

    public void mostrarClientes() {
        for (Cliente c : listaClientes) {
            System.out.println(c.toString());
        }
    }

}

class Menu {

    public Menu(Scanner teclado) {
        gestorClientes g = new gestorClientes();
        int eleccion = 0;
        while (true) {
            System.out.println("1: Mostrar Clientes");
            System.out.println("2: Crear un cliente");
            System.out.println("3: Salir");
            try {
                eleccion = teclado.nextInt();

            } catch (InputMismatchException e) {
                teclado.next();
            }
            switch (eleccion) {
                case 1:
                    g.mostrarClientes();
                    break;
                case 2:
                    g.crearCliente(teclado);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}
