package org.example.tda.conjuntos;

import org.example.model.Ticket;

public interface IConjuntoTicket {

    public interface ConjuntoTDA {
        void InicializarConjunto(); // pre: no aplica.
        void Agregar(Ticket t); // firma para agregar una pelicula.
        Ticket Elegir(); // firma para elegir una pelicula.
        boolean ConjuntoVacio(); // pre: conjunto inicializado.
        void Sacar(Ticket t); // firma para sacar una pelicula.
        boolean Pertenece(Ticket t); // firma para verificar si pertenece una pelicula.
        boolean TodosPertenecen(IConjuntoPelicula x);
        void SacarTodos(IConjuntoPelicula x);
    }

}
