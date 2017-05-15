package ClasesNecesarias;


public class Usuario {
	String dni;
	Lista gustos;
	
	public Usuario(String d, Lista g) {
		dni = d;
		gustos = g;
	}
	
	public void agregarGusto(String g) {
		
			if(!existe(g)) {	
				gustos.agregar(g);
			}
		
	}

	public boolean existe(String g) {
		for (int i = 0; i < gustos.tamanio(); i++) {
			if(gustos.getElement(i).equals(g)){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		String tastes = dni + "";
		for (int i = 0; i < gustos.tamanio(); i++) {
			tastes += " " + gustos.getElement(i);
		}
		return tastes;
	}
	
	public boolean equals(Object o) {
		Usuario d = (Usuario)o;
		return this.getDni().equals(d.getDni());
	}

	public String getDni() {
		return dni;
	}

	public Lista getGustos() {
		return gustos;
	}
	
}
