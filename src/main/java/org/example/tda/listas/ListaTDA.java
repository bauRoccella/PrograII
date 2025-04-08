package org.example.tda.listas;

public interface ListaTDA {
	public void InicializarLista();
	public void AgregarI(Contacto c);
	public void AgregarF(Contacto c);
	public void AgregarO(Contacto c);
	public void Eliminar(int dni);
	public Contacto Buscar(int dni);
	public ListaTDA BuscarEdad(int edad);
	public ListaTDA ObtenerMayoresDeEdad();
	public void Mostrar();
	public void Ordenar();
}
