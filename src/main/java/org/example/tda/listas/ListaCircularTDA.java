package org.example.tda.listas;

public interface ListaCircularTDA {
	void InicializarLista(); // pre: no aplica.
	void Agregar(int x); // pre: lista inicializada.
	void Eliminar(int x); // pre: lista inicializada.
	boolean ListaVacia(); // pre: lista inicializada.
	boolean Existe(int x); // pre: lista inicializada.
	String MostrarLista(); // pre: lista inicializada. 
	                       // pos: devuelve un String con los valores de la lista.
}
