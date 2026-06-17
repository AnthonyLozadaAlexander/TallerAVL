package principal;

import algoritmos.Algoritmos;
import arbolBinario.*;
import tad.TADVector;

public class Main {
	public static void main(String[] args) {
		Long inicio = System.nanoTime();

		String[] nombres = { "Peter", "Donald", "Hugo", "Paco", "Luis", "Gohan", "Goku", "Piccolo", "Satan", "Krilin" };
		TADVector<Persona> p = new TADVector<>(10, "Vector");
		ArbolAVL<Persona> arbol = new ArbolAVL<>("Arbol Taller AVL");

		for (int i = 0; i < nombres.length; i++) {
			p.insertarElemento(new Persona(nombres[i], Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 50)), i);
			arbol.insertar(p.leerElemento(i));
		}
		System.out.println("\n");

		// muestra la informacion de todo el arbol
		arbol.info();

		int index = 5;
		Persona pBuscar = p.leerElemento(index);
		System.out.println("\nBuscar Nodo Con Dato: " + pBuscar.getNombre());
		System.out.println(arbol.buscar(pBuscar));

		System.out.println("\nBuscar Nodo No Existente");
		Persona persona = new Persona("Rogert", "084324564", 24);
		System.out.println(arbol.buscar(persona));
		arbol.eliminar(persona);

		long fin = System.nanoTime();
		System.out.println("Tiempo Total Ejecucion: " + (fin - inicio) + " [ns]");
	}

}
