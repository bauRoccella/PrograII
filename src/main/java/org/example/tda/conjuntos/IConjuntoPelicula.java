package org.example.tda.conjuntos;

import org.example.model.Film;

public interface IConjuntoPelicula {
    void InicializarConjunto(); // pre: no aplica.
    void Agregar(Film p); // pre: conjunto inicializado.
    Film Elegir(); // pre: conjunto inicializado y no vac�o// .
    boolean ConjuntoVacio(); // pre: conjunto inicializado.
    void Sacar(Film p); // pre: conjunto inicializado.
    boolean Pertenece(Film p); // pre: conjunto inicializado.
    boolean TodosPertenecen(IConjuntoPelicula x);
    void SacarTodos(IConjuntoPelicula x);
}
