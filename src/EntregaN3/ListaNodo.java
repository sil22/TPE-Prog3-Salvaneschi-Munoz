package EntregaN3;


public class ListaNodo {
	Nodo primero;
	int cantidad;
	
	public ListaNodo() {
		primero = null;
		cantidad = 0;
	}

	public Nodo getPrimero() {
		return primero;
	}

	public boolean isEmpty(){
		return primero == null;
	}
	
	public int size(){
		return cantidad;
	}

	public Enum<TipoDato> getTipoDato(){
		if(primero != null)
			return primero.getTipoDato();
		return null;
	}
	
	public void agregar(String s, TipoDato t) { // agregar al final
		Nodo nuevo = new Nodo(s,t);
		nuevo.setSiguiente(primero);
		primero = nuevo;
		cantidad++;
	}
	
	public String getElement(int pos) {
		Nodo aux = primero;
		int cont = 0;
		if (pos >= 0 && pos < size()) {
			while (aux != null && cont < pos) {
				aux=aux.getSiguiente();
				cont++;
			}
			return aux.getDato();
		}
		return null;
	}
	public void imprimir() {
		Nodo aux = primero;
		while (aux != null) {
			System.out.println(aux.getDato() + " ");
			aux = aux.getSiguiente();
		}
		
	}
	


}
