package org.example.tda.conjuntos;

public interface IConjuntoTDA {
	void InicializarConjunto(); // pre: no aplica.
	void Agregar(int x); // pre: conjunto inicializado.
	int Elegir(); // pre: conjunto inicializado y no vac�o// .
	boolean ConjuntoVacio(); // pre: conjunto inicializado.
	void Sacar(int x); // pre: conjunto inicializado.
	boolean Pertenece(int x); // pre: conjunto inicializado.
	boolean TodosPertenecen(IConjuntoTDA x);
	void SacarTodos(IConjuntoTDA x);
}
