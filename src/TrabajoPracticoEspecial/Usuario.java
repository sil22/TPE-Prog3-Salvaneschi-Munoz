package TrabajoPracticoEspecial;


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

	private boolean existe(String g) {
		for (int i = 0; i < gustos.tamanio(); i++) {
			if(gustos.getElement(i).equals(g)){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		String tastes = "";
		for (int i = 0; i < gustos.tamanio(); i++) {
			tastes += " " + gustos.getElement(i);
		}
		return tastes;
	}
	
	public void getGusto(){
		gustos.imprimir();
	}
	
	public boolean equals(Usuario d) {
		return this.getDni()==d.getDni();
	}

	public String getDni() {
		return dni;
	}

	public Lista getGustos() {
		return gustos;
	}
	
	
	public void imprimirGustos() {
		for (int i = 0; i < gustos.tamanio(); i++) {
			System.out.println(gustos.getElement(i).toString());
		}
	}



	
}
