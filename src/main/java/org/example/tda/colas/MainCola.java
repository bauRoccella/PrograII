package org.example.tda.colas;

public class MainCola {
	
	public void PasarCola(ColaTDA Origen, ColaTDA Destino) {
		while (!Origen.ColaVacia()) {
			Destino.Acolar(Origen.Primero());
			Origen.Desacolar();
		}
	}
	
}
