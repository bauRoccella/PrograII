package org.example.tda.conjuntos;

public class MainConjuntoLD {
	private static void copiarConjunto(ConjuntoTDA original, ConjuntoTDA copia) {
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();
		int x;
		while (!original.ConjuntoVacio()) {
			x = original.Elegir();
			aux.Agregar(x);
			original.Sacar(x);
		}
		while (!aux.ConjuntoVacio()) {
			x = aux.Elegir();
			original.Agregar(x);
			copia.Agregar(x);
			aux.Sacar(x);
		}
	}
	
	public static void MostrarConjunto(ConjuntoTDA c) {
		ConjuntoTDA copia= new ConjuntoLD();
		copia.InicializarConjunto();
		copiarConjunto(c, copia);
		while (!(copia.ConjuntoVacio())) {
			int valor= copia.Elegir();
			System.out.print(valor+"-");
			copia.Sacar(valor);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ConjuntoTDA conj= new ConjuntoLD();
		conj.Agregar(1);
		conj.Agregar(7);
		conj.Agregar(5);
		conj.Agregar(3);
		MostrarConjunto(conj);
		conj.Sacar(1);
		conj.Sacar(7);
		conj.Sacar(5);
		conj.Sacar(3);
		MostrarConjunto(conj);
	}

}
