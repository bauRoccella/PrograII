package org.example.tda.listas;

public class MainLista {
	
	public static void mostrarLista(NodoLista u) {
	    NodoLista aux = new NodoLista();
	    aux = u;
	    System.out.print("[");
	    while (aux != null) {
	        System.out.print(aux.Valor);
	        aux = aux.Sig;
	        if (aux != null) {
	            System.out.print(", ");
	        }
	    }
	    System.out.println("]");
	}
	
	public static void mostrarListaRecursivo(NodoLista u) {
	    System.out.print("[");
	    if (u != null) {
	        System.out.print(u.Valor + " --> ");
	        mostrarLista(u.Sig);
	    } else {
	        System.out.println("]");
	    }
	}
	
	public static NodoLista AgregarI(NodoLista u, int num) {
		NodoLista nuevo = new NodoLista();
	    nuevo.Valor = num;
	    nuevo.Sig = u;
	    return nuevo;
	}
	
	public static void main(String[] args) {
		 // Crear una lista enlazada de ejemplo: 1 -> 2 -> 3 -> 3 -> 2 -> 1
        NodoLista cabeza = null;
        cabeza = AgregarI(cabeza, 1);
        cabeza = AgregarI(cabeza, 2);
        cabeza = AgregarI(cabeza, 3);
        cabeza = AgregarI(cabeza, 3);
        cabeza = AgregarI(cabeza, 2);
        cabeza = AgregarI(cabeza, 1);
        
        // Mostrar la lista
        mostrarLista(cabeza);

	}

}
