package org.example.tda.conjuntos;

import org.example.model.Reservation;

public class ConjuntoReservation implements IConjuntoReservation {
    private class Nodo {
        Reservation info;
        Nodo sig;
    }

    private Nodo c;

    @Override
    public void InicializarConjunto() {
        c = null;
    }

    @Override
    public void Agregar(Reservation r) {
        if (!Pertenece(r)) {
            Nodo nuevo = new Nodo();
            nuevo.info = r;
            nuevo.sig = c;
            c = nuevo;
        }
    }

    @Override
    public Reservation Elegir() {
        return c != null ? c.info : null;
    }

    @Override
    public boolean ConjuntoVacio() {
        return c == null;
    }

    @Override
    public void Sacar(Reservation r) {
        if (c != null) {
            if (c.info.equals(r)) {
                c = c.sig;
            } else {
                Nodo aux = c;
                while (aux.sig != null && !aux.sig.info.equals(r))
                    aux = aux.sig;
                if (aux.sig != null)
                    aux.sig = aux.sig.sig;
            }
        }
    }

    @Override
    public boolean Pertenece(Reservation r) {
        Nodo aux = c;
        while (aux != null && !aux.info.equals(r))
            aux = aux.sig;
        return aux != null;
    }

    @Override
    public boolean TodosPertenecen(IConjuntoTDA x) {
        // no se si lo necesito
        return false;
    }

    @Override
    public void SacarTodos(IConjuntoTDA x) {
        // esto tambien
    }
}