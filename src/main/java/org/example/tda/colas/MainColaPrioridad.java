package org.example.tda.colas;

public class MainColaPrioridad {
	public void Pasaje(ColaPrioridadTDA origen, ColaTDA Valores, ColaTDA prioridades) {
		while (!origen.ColaVacia()) {
			Valores.Acolar(origen.Primero());
			prioridades.Acolar(origen.Prioridad());
			origen.Desacolar();
		}
	}
}
