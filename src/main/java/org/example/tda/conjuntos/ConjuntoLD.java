package org.example.tda.conjuntos;

public class ConjuntoLD implements ConjuntoTDA {
	private class Nodo { // la c�lula de la estructura
		int info; // el valor almacenado
		Nodo sig; // la referencia al siguiente nodo
	}

	private Nodo c; // la referencia de la estructura

	public void InicializarConjunto() {
		c = null;
	}

	public int Elegir() {
		return c.info; // elegimos el primero (puede ser cualquiera)
	}

	public void Sacar(int x) {
		if (c != null) {
			if (c.info == x) { // es el primero
				c = c.sig;
			} else { // es alg�n otro; lo buscamos
				Nodo aux = c;
				while (aux.sig != null && aux.sig.info != x)
					aux = aux.sig;
				if (aux.sig != null) { // encontrado
					aux.sig = aux.sig.sig;
				}
			}
		}
	}

	public void Agregar(int x) {
		if (!this.Pertenece(x)) { // Se verifica pertenencia
			Nodo nuevo = new Nodo(); // el nuevo nodo que se agregar�
			nuevo.info = x;
			nuevo.sig = c;
			c = nuevo;
		}
	}

	public boolean Pertenece(int x) {
		Nodo aux = c;
		while (aux != null && aux.info != x)
			aux = aux.sig;
		return (aux != null);
	}

	public boolean ConjuntoVacio() {
		return (c == null);
	}

	/*
	 * 2. [40 puntos] Modificación de la Interfaz ConjuntoTDA. Se desea agregar dos
	 * nuevos métodos a la interfaz ConjuntoTDA:  Método TodosPertenecen: Devuelve
	 * true si todos los elementos de un conjunto X están en el conjunto actual,
	 * false en caso contrario. Debe preservar el conjunto X.  Método SacarTodos:
	 * Elimina del conjunto actual todos los elementos que estén en un conjunto X
	 * dado. Debe preservar el conjunto X.
	 */
	@Override
	public boolean TodosPertenecen(ConjuntoTDA x) {
		// Creo el conjunto auxiliar
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();

		boolean respuesta = true; // SUPONGO todos pertenecen

		/*
		 * Elegimos valor de x y si este no pertenece a conjunto actual, el metodo
		 * devuelve false. Sino, elimina el valor para buscar otro, pero lo guarda en un
		 * conjunto auxiliar ya que se debe preservar el conjunto x
		 */
		while (!x.ConjuntoVacio() && respuesta) {
			int valor = x.Elegir();
			if (!this.Pertenece(valor))
				respuesta = false; // seteo el flag en falso porque alguno de los valores
									// de x NO pertenecía al conj. actual
			else
				x.Sacar(valor);
			aux.Agregar(valor);
		}

		// Pasamos todos los elementos de aux a x
		while (!aux.ConjuntoVacio()) {
			int valor = aux.Elegir();
			x.Agregar(valor);
			aux.Sacar(valor);
		}

		return respuesta;
	}

	@Override
	public void SacarTodos(ConjuntoTDA x) {
		// Creo el conjunto auxiliar
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();

		// Vaciar el conjunto x y pasar los valores a aux
		while (!x.ConjuntoVacio() && !this.ConjuntoVacio()) {
			int valor = x.Elegir();
			this.Sacar(valor);
			aux.Agregar(valor); // Paso a aux los valores de x
			x.Sacar(valor); // Línea que faltaba (sacar de x)
		}

		// Pasamos todos los elementos de aux a x
		while (!aux.ConjuntoVacio()) {
			int valor = aux.Elegir();
			x.Agregar(valor);
			aux.Sacar(valor);
		}
	}

	public boolean TodosPertenecen2(ConjuntoTDA x) {
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();

		int valor = x.Elegir();
		while (!x.ConjuntoVacio() && this.Pertenece(valor)) {
			aux.Agregar(valor);
			x.Sacar(valor);
			valor = x.Elegir();
		}

		if (x.ConjuntoVacio()) {
			while (!aux.ConjuntoVacio()) {
				valor = aux.Elegir();
				x.Agregar(valor);
				aux.Sacar(valor);
			}
			return true;

		} else {
			while (!aux.ConjuntoVacio()) {
				valor = aux.Elegir();
				x.Agregar(valor);
				aux.Sacar(valor);
			}
			return false;
		}

	}
}