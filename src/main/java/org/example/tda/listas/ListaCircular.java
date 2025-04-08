package org.example.tda.listas;

public class ListaCircular implements ListaCircularTDA {
	private Nodo inicio;

	// Clase Nodo
	private class Nodo {
		int dato;
		Nodo sig;
	}

	@Override
	public void InicializarLista() {
		inicio = null;
	}

	@Override
	public void Agregar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.dato = x;
		if (inicio == null) {
			nuevo.sig = nuevo; // Si la lista está vacía, el nuevo nodo apunta a sí mismo
			inicio = nuevo; // El inicio de la lista apunta al nuevo nodo
		} else {
			nuevo.sig = inicio.sig; // El nuevo nodo apunta al 2do nodo de la lista
			inicio.sig = nuevo; // El último nodo (antes el 1ro) apunta al nuevo nodo
			inicio = nuevo; // El inicio de la lista ahora es el nuevo nodo
		}
	}

	@Override
    // Método para eliminar un nodo de la lista circular
    public void Eliminar(int x) {
        if (inicio == null) {
            return;
        }
        
        Nodo actual = inicio;
        Nodo previo = null;
        
        // Busco el nodo a eliminar
        while (actual.dato != x) {
            if (actual.sig == inicio) {
                // El valor no se encuentra en la lista
                return;
            }
            previo = actual;
            actual = actual.sig;
        }
        
        // Si el nodo a eliminar es el único nodo en la lista
        if (actual == inicio && actual.sig == inicio) {
        	inicio = null;
            return;
        }
        
        // Si el nodo a eliminar es el primer nodo de la lista
        if (actual == inicio) {
            Nodo ultimo = inicio;
            while (ultimo.sig != inicio) {
                ultimo = ultimo.sig;
            }
            inicio = actual.sig;
            ultimo.sig = inicio;
            return;
        }
        
        // Si el nodo a eliminar está en medio o al final de la lista
        if (actual.sig == inicio) {
            previo.sig = inicio;
        } else {
            previo.sig = actual.sig;
        }
    }


	@Override
	public boolean ListaVacia() {
		return inicio==null;
	}

	@Override
	public boolean Existe(int x) {
		if (inicio == null) // Si la lista está vacía, el elemento no está presente
			return false;

		Nodo actual = inicio.sig; // Empezamos desde el primer nodo
		while (actual != inicio) { // Recorremos la lista circular hasta volver al inicio
			if (actual.dato == x) // Si encontramos el dato, retornamos verdadero
				return true;
			actual = actual.sig; // Pasamos al sig nodo
		}
		// Si recorrimos toda la lista y no encontramos el dato, retornamos falso
		return false;
	}

	@Override
	public String MostrarLista() {
		String lista = "";
		if (inicio != null) {
			Nodo actual = inicio.sig;
			while (actual != inicio) {
				lista += actual.dato + " ";
				actual = actual.sig;
			}
			lista += actual.dato;
		}
		return lista;
	}

	// Método main para probar la implementación
	public static void main(String[] args) {
		ListaCircular lista = new ListaCircular();
		lista.Agregar(10);
//		lista.Agregar(20);
//		lista.Agregar(30);
//		lista.Agregar(40);
		
		System.out.println("Lista circular:");
		System.out.println(lista.MostrarLista());

		lista.Eliminar(10);
		System.out.println(lista.MostrarLista());

		// int elementoABuscar = 20;
		int elementoABuscar = 35;
		if (lista.Existe(elementoABuscar)) {
			System.out.println("El elemento " + elementoABuscar + " está presente en la lista.");
		} else {
			System.out.println("El elemento " + elementoABuscar + " no está presente en la lista.");
		}

	}

}