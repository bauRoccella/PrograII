package org.example.tda.diccionario;

import org.example.model.Reservation;
import org.example.tda.conjuntos.IConjuntoReservation;
import org.example.tda.conjuntos.IConjuntoTDA;

public interface IDiccionarioReservation {
    void InicializarDiccionario(); // pre: no aplica.
    void Agregar(int clave, Reservation reservation); // pre: diccionario inicializado.
    void Eliminar(int clave); // pre: diccionario inicializado.
    Reservation Recuperar(int clave); // pre: diccionario inicializado y clave existente.
    // Actividad: mejorar la implementaci�n eliminando la precondici�n que la clave sea existente.
    IConjuntoReservation Claves(); // pre: diccionario inicializado.
}
