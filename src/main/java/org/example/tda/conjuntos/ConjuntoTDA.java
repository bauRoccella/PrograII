package org.example.tda.conjuntos;

import org.example.model.Film;

public interface ConjuntoTDA {
	void InicializarConjunto(); // pre: no aplica.
	void Agregar(int x); // pre: conjunto inicializado.
	void Agregar(Film p); // firma para agregar una pelicula.
	int Elegir(); // pre: conjunto inicializado y no vac�o// .
	Film ElegirPelicula(); // firma para elegir una pelicula.
	boolean ConjuntoVacio(); // pre: conjunto inicializado.
	void Sacar(int x); // pre: conjunto inicializado.
	void Sacar(Film p); // firma para sacar una pelicula.
	boolean Pertenece(int x); // pre: conjunto inicializado.
	boolean Pertenece(Film p); // firma para verificar si pertenece una pelicula.
	boolean TodosPertenecen(ConjuntoTDA x);
	void SacarTodos(ConjuntoTDA x);
}
