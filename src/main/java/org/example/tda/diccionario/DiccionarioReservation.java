package org.example.tda.diccionario;

import org.example.model.Reservation;
import org.example.tda.conjuntos.ConjuntoLD;
import org.example.tda.conjuntos.IConjuntoTDA;

public class DiccionarioReservation implements IDiccionarioReservation {
    private static class Elemento {
        int clave;
        Reservation valor;
    }

    private Elemento[] elementos;
    private int cant;
    private int capacidad;

    @Override
    public void InicializarDiccionario() {
        capacidad = 100; // Configurable capacity
        elementos = new Elemento[capacidad];
        cant = 0;
    }

    /**
     * Constructor that allows setting custom capacity
     */
    public void InicializarDiccionario(int capacidad) {
        this.capacidad = capacidad;
        elementos = new Elemento[capacidad];
        cant = 0;
    }

    @Override
    public void Agregar(int clave, Reservation reserva) {
        int pos = Clave2Indice(clave);
        if (pos == -1) { // No existe, se agrega nuevo
            if (cant < capacidad) {
                pos = cant;
                elementos[pos] = new Elemento();
                elementos[pos].clave = clave;
                elementos[pos].valor = reserva;
                cant++;
            } else {
                throw new IllegalStateException("El diccionario de reservas está lleno");
            }
        } else {
            elementos[pos].valor = reserva;
        }
    }

    @Override
    public void Eliminar(int clave) {
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cant - 1]; // Reemplazar con el último
            cant--;
        }
    }

    @Override
    public Reservation Recuperar(int clave) {
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            return elementos[pos].valor;
        }
        return null;
    }

    @Override
    public IConjuntoTDA Claves() {
        IConjuntoTDA conjunto = new ConjuntoLD();
        conjunto.InicializarConjunto();
        for (int i = 0; i < cant; i++) {
            conjunto.Agregar(elementos[i].clave);
        }
        return conjunto;
    }

    private int Clave2Indice(int clave) {
        for (int i = 0; i < cant; i++) {
            if (elementos[i].clave == clave) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica si el diccionario está lleno
     */
    public boolean estaLleno() {
        return cant >= capacidad;
    }

    /**
     * Devuelve la cantidad actual de elementos
     */
    public int getCantidad() {
        return cant;
    }

    /**
     * Devuelve la capacidad máxima
     */
    public int getCapacidad() {
        return capacidad;
    }
}