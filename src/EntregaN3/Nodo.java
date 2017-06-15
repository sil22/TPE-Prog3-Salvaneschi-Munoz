package EntregaN3;

public class Nodo {
	
	String dato;
	TipoDato tipoDato;
	Nodo siguiente;
	
	public Nodo(String d, TipoDato t){
		dato = d;
		tipoDato = t;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public TipoDato getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDato tipoDato) {
		this.tipoDato = tipoDato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return dato;
	}
	
	
	

}
