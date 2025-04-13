package org.example.tda.colas;

public interface ColaTDA {
	void InicializarCola(); // pre: no aplica.
	void Acolar(int x); // pre: cola inicializada.
	void Desacolar(); // pre: cola inicializada y no vac�a.
	boolean ColaVacia(); // pre: cola inicializada.
	int Primero(); // cola inicializada y no vac�a.
}
