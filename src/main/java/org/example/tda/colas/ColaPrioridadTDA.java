package org.example.tda.colas;

public interface ColaPrioridadTDA {
	void InicializarCola(); // pre: no aplica.
	void AcolarPrioridad(int x, int prioridad); // pre: cola inicializada.
	void Desacolar(); // pre: cola inicializada y no vac�a.
	boolean ColaVacia(); // pre: cola inicializada.
	int Primero(); // pre: cola inicializada y no vac�a.
	int Prioridad(); // cola inicializada y no vac�a.
}
