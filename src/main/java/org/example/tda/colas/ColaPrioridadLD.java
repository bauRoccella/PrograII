package org.example.tda.colas;

public class ColaPrioridadLD implements ColaPrioridadTDA {
	private class NodoPrioridad { // la c�lula de la estructura
		int info; // el valor almacenado
		int prioridad; // la prioridad
		NodoPrioridad sig; // la referencia al siguiente nodo
	}

	private NodoPrioridad primero; // primer elemento (prioritario)

	public void InicializarCola() {
		primero = null;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad(); // el nuevo nodo que se acolar�
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		if (primero == null || primero.prioridad < prioridad) {
			nuevo.sig = primero; // el nodo debe ir al principio
			primero = nuevo;
		} else {
			NodoPrioridad aux = primero; // buscamos la posici�n
			while (aux.sig != null && aux.sig.prioridad > prioridad) {
				aux = aux.sig;
			}
			nuevo.sig = aux.sig; // al nuevo lo conecto con el siguiente
			aux.sig = nuevo; // nodo anterior lo conecto con el nuevo nodo
		}
	}

	public void Desacolar() {
		primero = primero.sig; // nueva referencia a la estructura
	}

	public boolean ColaVacia() {
		return (primero == null);
	}

	public int Primero() {
		return primero.info;
	}

	public int Prioridad() {
		return primero.prioridad;
	}
}
