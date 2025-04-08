package org.example.tda.listas;

public class MainListaCircular {

	public static void main(String[] args) {
		ListaCircularTDA listaC = new ListaCircular();
		listaC.Agregar(1);
//		listaC.Agregar(2);
//		listaC.Agregar(9);
//		listaC.Agregar(12);
//		listaC.Agregar(15);
		listaC.MostrarLista();
		listaC.Eliminar(1);
		System.out.println(listaC.MostrarLista());
		System.out.println("Test");
	}

}
