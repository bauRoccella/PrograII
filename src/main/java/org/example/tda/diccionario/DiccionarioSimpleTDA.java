package org.example.tda.diccionario;

import org.example.model.Reservation;
import org.example.tda.conjuntos.ConjuntoTDA;

public interface DiccionarioSimpleTDA {
	void InicializarDiccionario(); // pre: no aplica.
	void Agregar(int clave, Reservation reservation); // pre: diccionario inicializado.
	void Eliminar(int clave); // pre: diccionario inicializado.
	Reservation Recuperar(int clave); // pre: diccionario inicializado y clave existente.
							  // Actividad: mejorar la implementaci�n eliminando la precondici�n que la clave sea existente.
	ConjuntoTDA Claves(); // pre: diccionario inicializado.
}
