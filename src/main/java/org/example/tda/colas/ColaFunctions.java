package org.example.tda.colas;

import org.example.model.Function;

public class ColaFunctions { // le borre el implements porque es progra 2
    // en paradigma respeten las interfaces !!!

    private class Nodo {
        Function info; // el valor ahora va a ser una Function
        Nodo sig;
    }

    private Nodo primero;
    private Nodo ultimo;

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(Function function) {
        Nodo nuevo = new Nodo();
        nuevo.info = function;
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

    public Function Primero() {
        return primero.info;
    }
}
