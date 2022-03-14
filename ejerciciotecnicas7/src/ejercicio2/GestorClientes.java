package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorClientes extends Cliente{

	ArrayList<Cliente> listaClientes;

	public GestorClientes() {
		listaClientes = new ArrayList<Cliente>();
	}

	public void crearCliente(Scanner teclado) {
		System.out.println("¿Nombre?");
		String nombre = teclado.next();
		Cliente c = new Cliente(nombre);
		listaClientes.add(c);
		contador++;
		System.out.println("Cliente n.º" + c.id + " [" + c.getNombre() + "] añadido");
	}

	public void mostrarClientes() {
		if (listaClientes.isEmpty()) {
			System.out.println("No hay clientes");
		}else {
			System.out.println("-- Clientes --\n");
		}
		for (Cliente c : listaClientes) {
			System.out.println(c.toString());
		}
	}

}