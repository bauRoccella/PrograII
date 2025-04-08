package org.example.tda.conjuntos;

public class MainConjunto {
	
	public static boolean Incluye(ConjuntoTDA conj1, ConjuntoTDA conj2) {
		boolean incluye = true; // flag
		while (!conj2.ConjuntoVacio() && incluye) {
			int x = conj2.Elegir();
			if (!conj1.Pertenece(x)) {
				incluye = false;
			} else {
				conj2.Sacar(x);
			}
		}
		return incluye;
	}

	public static boolean IncluyeConj2Lleno(ConjuntoTDA conj1, ConjuntoTDA conj2) {
		// Creo conj aux
		ConjuntoTDA aux= new ConjuntoA();
		aux.InicializarConjunto();
		
		boolean incluye = true; // flag
		while (!conj2.ConjuntoVacio() && incluye) {
			int x = conj2.Elegir();
			if (!conj1.Pertenece(x)) {
				incluye = false;
			} else {
				aux.Agregar(x);
				conj2.Sacar(x);
			}
		}
		
		conj2= aux; // MAL
		
		return incluye;
	}

	public static void main(String[] args) {
		ConjuntoTDA conj1= new ConjuntoA();
		conj1.InicializarConjunto();
		conj1.Agregar(7);
		conj1.Agregar(5);
		conj1.Agregar(2);
		
		ConjuntoTDA conj2= new ConjuntoA();
		conj2.InicializarConjunto();
		conj2.Agregar(7);
		// conj2.Agregar(0);
		conj2.Agregar(2);
		
		System.out.println(IncluyeConj2Lleno(conj1, conj2));
		System.out.println();
	}
}
