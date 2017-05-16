package appListaNodo;

import ClasesNecesarias.Lista;
import ClasesNecesarias.Nodo;

public class ListaNodo extends Lista {

	protected Nodo primero;
	private int tamanio = 0;

	public ListaNodo() {
		primero = null;
	}

	public int tamanio() {
		return tamanio;
	}

	public Nodo getPrimero() {
		return primero;
	}

	public boolean isEmpty() {
		return primero == null;
	}

	public void agregar(Object o) { // agregar al final
		if (isEmpty()) {
			Nodo nuevo = new Nodo(o, null);
			nuevo.setSig(primero);
			primero = nuevo;
			tamanio++;
		} else {
				Nodo n = primero;
				while (n.getSig() != null) {
					n = n.getSig();
				}
				Nodo nuevo = new Nodo(o, null);
				n.setSig(nuevo);
				tamanio++;
		}
	}

	public boolean existe(Object o) {
		Nodo aux = primero;
		while (aux != null) {
			if (aux.getValor().equals(o)) {
				return true;
			} else
				aux = aux.getSig();
		}
		return false;
	}

	@Override
	public Object getElement(int pos) {
		Nodo aux = primero;
		int cont = 0;
		if (pos >= 0 && pos < tamanio()) {
			while (aux != null && cont < pos) {
				aux=aux.getSig();
				cont++;
			}
			return aux.getValor();
		}
		return null;
	}

	public void imprimir() {
		Nodo aux = primero;
		while (aux != null) {
			System.out.println(aux.getValor() + " ");
			aux = aux.getSig();
		}
		
	}

	

}
