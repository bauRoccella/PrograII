package org.example.tda.colas;

public class ColaPrioridadDA implements ColaPrioridadTDA {
	int[] elementos; // Los valores de la cola
	int[] prioridades; // Las prioridades de la cola
	int indice; // La cantidad de elementos

	public void InicializarCola() {
		elementos = new int[100];
		prioridades = new int[100];
		indice = 0;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		while (j > 0 && prioridades[j - 1] > prioridad) {
			elementos[j] = elementos[j - 1]; // Desplazamiento paralelo
			prioridades[j] = prioridades[j - 1]; // Desplazamiento paralelo
			j--;
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;
	}

	public void Desacolar() {
		indice--;
	}

	public boolean ColaVacia() {
		return (indice == 0);
	}

	public int Primero() {
		return elementos[indice - 1];
	}

	public int Prioridad() {
		return prioridades[indice - 1];
	}
}
