package TrabajoPracticoEspecial;

public class ListaArreglo extends Lista{
	Object arr [];
	int cant;
	
	public ListaArreglo(){
		arr= new Object [9999];
		cant = 0;
	}
	
	@Override
	public int tamanio(){
		return cant;
	}
 	
	public boolean isEmpty() {
		return cant == 0;
	}
	
	public void imprimir() {
		for (int i = 0; i < cant; i++) {
			System.out.println(arr[i]+" ");
			
		}
	}
	
	public void agregar(Object o) {
		
		if(arr[arr.length-1] != null){

			Object nuevoArreglo[] = new Object[arr.length*2];
			for (int i = 0; i < arr.length; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		
		arr[cant] = o;
		cant++;
		
	}
	@Override
	public boolean existe(Object o) {
		for (int i = 0; i < tamanio(); i++) {
			if(arr[i].equals(o)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public Object getElement(int p) {
		if(p < arr.length && p >= 0 ){
				return arr[p];
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		ListaArreglo la = new ListaArreglo();
		long inicio, fin, tiempoTotal;
		
		// inserto al comienzo
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			la.agregar(i);	
			
		}
		System.out.println(la.getElement(5));
		System.out.println(la.existe(3));
		System.out.println(la.tamanio());
		la.imprimir();
		fin = System.currentTimeMillis();
		
		tiempoTotal = fin - inicio;
		System.out.println(" ");
		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
//		
//		
//		// get un elemento
//		inicio = System.currentTimeMillis();
//		System.out.print("agarro el elmento en la pos 3: ");
//		System.out.println(la.getElement(3));
//		fin = System.currentTimeMillis();
//		
//		tiempoTotal = fin - inicio;
//		System.out.println(" ");
//		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
//		
//		// elimino un elemento
//		
//		inicio = System.currentTimeMillis();
//		la.eliminarElemento(5);
//		System.out.println("elimine el elemento 5");
//		la.imprimir();
//		fin = System.currentTimeMillis();
//		
//		tiempoTotal = fin - inicio;
//		System.out.println(" ");
//		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
//		
//		// determinar cant
//		
//		inicio = System.currentTimeMillis();
//		System.out.println("tamanio de la lista: " + la.getTamanio());
//		fin = System.currentTimeMillis();
//		
//		tiempoTotal = fin - inicio;
//		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
//		
		
	}

	


	
	

}
