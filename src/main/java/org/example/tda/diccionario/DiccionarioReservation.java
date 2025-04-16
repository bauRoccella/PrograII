package org.example.tda.diccionario;

import org.example.model.Reservation;
import org.example.tda.conjuntos.ConjuntoReservation;
import org.example.tda.conjuntos.IConjuntoReservation;

public class DiccionarioReservation implements IDiccionarioReservation {
    private class NodoReservation {
        int clave;
        Reservation valor;
        NodoReservation sig;
    }

    private NodoReservation origen;

    @Override
    public void InicializarDiccionario() {
        origen = null;
    }

    public void agregarReservation(int clave, Reservation reserva) {
        NodoReservation nodo = Buscar(clave);
        if (nodo == null) {
            nodo = new NodoReservation();
            nodo.clave = clave;
            nodo.sig = origen;
            origen = nodo;
        }
        nodo.valor = reserva;
    }

    @Override
    public void Agregar(int clave, Reservation reservation) {
        agregarReservation(clave, reservation);
    }

    @Override
    public void Eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sig;
            } else {
                NodoReservation aux = origen;
                while (aux.sig != null && aux.sig.clave != clave)
                    aux = aux.sig;
                if (aux.sig != null)
                    aux.sig = aux.sig.sig;
            }
        }
    }

    @Override
    public Reservation Recuperar(int clave) {
        return recuperarReservation(clave);
    }

    public Reservation recuperarReservation(int clave) {
        NodoReservation nodo = Buscar(clave);
        return nodo != null ? nodo.valor : null;
    }

    private NodoReservation Buscar(int clave) {
        NodoReservation aux = origen;
        while (aux != null && aux.clave != clave)
            aux = aux.sig;
        return aux;
    }

    @Override
    public IConjuntoReservation Claves() {
        IConjuntoReservation conjunto = new ConjuntoReservation();
        conjunto.InicializarConjunto();
        NodoReservation aux = origen;
        while (aux != null) {
            conjunto.Agregar(aux.valor);
            aux = aux.sig;
        }
        return conjunto;
    }
}