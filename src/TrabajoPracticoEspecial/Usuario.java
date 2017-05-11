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
	
//	public void getGusto(){
//		gustos.imprimir();
//	}
//	public void imprimirGustos() {
//		for (int i = 0; i < gustos.tamanio(); i++) {
//			System.out.println(gustos.getElement(i).toString());
//		}
//	}
	
	public boolean equals(Usuario d) {
		return this.getDni()==d.getDni();
	}

	public String getDni() {
		return dni;
	}

	public Lista getGustos() {
		return gustos;
	}
	
	

	
	public static void main(String[] args) {
		
		Lista pepa=new ListaNodo();
		pepa.agregar("peperina0");
		pepa.agregar("peperina1");
		pepa.agregar("peperina2");
		pepa.agregar("peperina3");
		
		
		Usuario user=new Usuario("129419",pepa);
		System.out.println(user.toString());
		
		
	}



	
}
