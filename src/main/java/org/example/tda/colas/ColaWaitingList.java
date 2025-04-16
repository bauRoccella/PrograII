package org.example.tda.colas;

import org.example.model.WaitingListEntry;

public class ColaWaitingList implements IColaWaitingList {
    private class Nodo {
        WaitingListEntry info;
        Nodo sig;
    }

    private Nodo primero;
    private Nodo ultimo;

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(WaitingListEntry entry) {
        Nodo nuevo = new Nodo();
        nuevo.info = entry;
        nuevo.sig = null;
        if (ultimo != null)
            ultimo.sig = nuevo;
        ultimo = nuevo;
        if (primero == null)
            primero = ultimo;
    }

    public void Desacolar() {
        primero = primero.sig;
        if (primero == null)
            ultimo = null;
    }

    public boolean ColaVacia() {
        return (ultimo == null);
    }

    public WaitingListEntry Primero() {
        return primero.info;
    }
}