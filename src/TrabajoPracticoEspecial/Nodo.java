package TrabajoPracticoEspecial;

public class Nodo {
	Object valor;
	Nodo sig;
	
	public Nodo(Object  o, Nodo s) {
		valor = o;
		sig = s;
	}

	public Object  getValor() {
		return valor;
	}

	public void setValor(Object  valor) {
		this.valor = valor;
	}

	public Nodo getSig() {
		return sig;
	}

	public void  setSig(Nodo sig) {
		this.sig = sig;
	}
	
	public String toString(){
		return valor.toString();
	}
	
	public boolean equals(Nodo n) {
		return this.getValor()==n.getValor();
	}

}
