package org.example.tda.conjuntos;

import org.example.model.Reservation;

public interface IConjuntoReservation {
    void InicializarConjunto(); // pre: no aplica.
    void Agregar(Reservation r); // pre: conjunto inicializado.
    Reservation Elegir(); // pre: conjunto inicializado y no vac�o// .
    boolean ConjuntoVacio(); // pre: conjunto inicializado.
    void Sacar(Reservation r); // pre: conjunto inicializado.
    boolean Pertenece(Reservation p); // pre: conjunto inicializado.
    boolean TodosPertenecen(IConjuntoTDA x);
    void SacarTodos(IConjuntoTDA x);
}
