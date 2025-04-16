package org.example.tda.conjuntos;


import org.example.model.Film;

public class ConjuntoPelicula implements IConjuntoPelicula {
    private class Nodo {
        Film info;
        Nodo sig;
    }

    private Nodo c;

    public void InicializarConjunto() {
        c = null;
    }

    public void Agregar(Film p) {
        if (!Pertenece(p)) {
            Nodo nuevo = new Nodo();
            nuevo.info = p;
            nuevo.sig = c;
            c = nuevo;
        }
    }

    @Override
    public Film Elegir() {
        return c.info;
    }

    public void Sacar(Film p) {
        if (c != null) {
            if (c.info.equals(p)) {
                c = c.sig;
            } else {
                Nodo aux = c;
                while (aux.sig != null && !aux.sig.info.equals(p))
                    aux = aux.sig;
                if (aux.sig != null)
                    aux.sig = aux.sig.sig;
            }
        }
    }

    public boolean Pertenece(Film p) {
        Nodo aux = c;
        while (aux != null && !aux.info.equals(p))
            aux = aux.sig;
        return aux != null;
    }

    public boolean ConjuntoVacio() {
        return c == null;
    }

    public Film ElegirPelicula() {
        return c.info;
    }

    public boolean TodosPertenecen(IConjuntoPelicula otro) {
        ConjuntoPelicula aux = new ConjuntoPelicula();
        aux.InicializarConjunto();

        boolean todos = true;

        while (!otro.ConjuntoVacio() && todos) {
            Film p = otro.Elegir();
            if (!this.Pertenece(p)) {
                todos = false;
            } else {
                otro.Sacar(p);
            }
            aux.Agregar(p);
        }

        while (!aux.ConjuntoVacio()) {
            Film p = aux.ElegirPelicula();
            otro.Agregar(p);
            aux.Sacar(p);
        }

        return todos;
    }

    public void SacarTodos(IConjuntoPelicula otro) {
        ConjuntoPelicula aux = new ConjuntoPelicula();
        aux.InicializarConjunto();

        while (!otro.ConjuntoVacio()) {
            Film p = otro.Elegir();
            this.Sacar(p);
            aux.Agregar(p);
            otro.Sacar(p);
        }

        while (!aux.ConjuntoVacio()) {
            Film p = aux.ElegirPelicula();
            otro.Agregar(p);
            aux.Sacar(p);
        }
    }
}
