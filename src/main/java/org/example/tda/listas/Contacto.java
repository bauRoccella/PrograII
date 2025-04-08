package org.example.tda.listas;

public class Contacto {
	public String nombre;
	public int dni;
	public int edad;
	
	public Contacto(int dni) {
		this.dni = dni;
		this.nombre = "";
		this.edad = 0;
	}
	
	public String toString() {
		String datosContacto = "Contacto: " + this.nombre 
				+ ", DNI: " + this.dni + ".";
		return datosContacto;
	}
}
