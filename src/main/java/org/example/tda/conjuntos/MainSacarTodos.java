package org.example.tda.conjuntos;

public class MainSacarTodos {
	// Método externo (a la clase ConjuntoTDA)
	public static void MostrarConjunto(ConjuntoTDA conj) {
		/*
		 * pre: recibo un conjunto.
		 * pos: muestro el conjunto por consola. (el conjunto queda vacío) 
		 * */
		
		while (!conj.ConjuntoVacio()) {
			int valor = conj.Elegir();
			conj.Sacar(valor);
			System.out.println(valor);
		}
	}

	public static void main(String[] args) {
		ConjuntoTDA conjA = new ConjuntoLD();
		conjA.InicializarConjunto();
		conjA.Agregar(4);
		conjA.Agregar(5);
		conjA.Agregar(1);

		ConjuntoTDA x = new ConjuntoLD();
		x.InicializarConjunto();
		x.Agregar(4);
		x.Agregar(5);

		conjA.SacarTodos(x);
		// System.out.println(x.ConjuntoVacio());
		System.out.println("Conjunto A");
		MostrarConjunto(conjA);
		System.out.println("Conjunto X");
		MostrarConjunto(x);
	}

}
