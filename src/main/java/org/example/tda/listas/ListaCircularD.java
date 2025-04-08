package org.example.tda.listas;

public class ListaCircularD implements ListaCircularTDA {
	NodoLC ultimo;
	
	@Override
	public void InicializarLista() {
		ultimo= null;
	}

	@Override
	public void Agregar(int x) {
		NodoLC nuevo= new NodoLC();
		nuevo.Dato= x;
		if (ultimo!=null) {
			nuevo.Sig= ultimo.Sig;
			ultimo.Sig= nuevo;
		} else {
			nuevo.Sig= nuevo; // Si la lista estaba vacía (ultimo== null),
							  // debo apuntar el nodo a sí mismo.
		}
		ultimo= nuevo;
	}

	@Override
	public void Eliminar(int x) {
		if (ultimo!=null) { // Si la lista NO está vacía
			NodoLC aux= ultimo;
			while (aux.Sig!=ultimo && aux.Sig.Dato!=x) {
				aux= aux.Sig;
			}
			if (aux.Sig.Dato==x) {
				if (ultimo== ultimo.Sig) {
					ultimo= null; // Era el último nodo de la LC y la lista queda vacía
				} else {
					aux.Sig= aux.Sig.Sig;
					if (ultimo.Dato==x) { // Si eliminé el ultimo
						ultimo= aux;
					}
				}
			}
		}
	}

	@Override
	public boolean ListaVacia() {
		return ultimo==null;
	}

	@Override
	public boolean Existe(int x) {
		boolean encontrado= false;
		if (ultimo!=null) { // Si la lista NO está vacía
			NodoLC aux= ultimo;
			while (aux.Sig!=ultimo && aux.Sig.Dato!=x) {
				aux= aux.Sig;
			}
			if (aux.Sig.Dato==x) {
				encontrado= true;
			}
		}
		return encontrado;
	}

	@Override
	public String MostrarLista() {
		String cadena= "";
		if (ultimo!=null) {
			NodoLC aux= ultimo;
			do {
				cadena+= "["+aux.Dato+"]->";
				aux= aux.Sig;
			} while (aux!=ultimo);
//			cadena+= "\n";
		}
		
		return cadena;
	}

}

