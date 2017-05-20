package appArreglo;

import ClasesNecesarias.Lista;
import ClasesNecesarias.Usuario;

public class ListaArreglo extends Lista {
	Object arr[];
	int cant;

	public ListaArreglo() {
		arr = new Object[10];
		cant = 0;
	}

	public ListaArreglo(int a) {
		arr = new Object[a];
		cant = 0;
	}

	@Override
	public int tamanio() {
		return cant;
	}

	public boolean isEmpty() {
		return cant == 0;
	}

	public void imprimir() {
		for (int i = 0; i < cant; i++) {
			System.out.println(arr[i].toString() + " ");

		}
	}

	public boolean tieneLugar() {
		return cant + 1 < arr.length;
	}
	
	public void incrementarEspacio() {
		Object nuevoArreglo[] = new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			nuevoArreglo[i] = arr[i];
		}
		arr = nuevoArreglo;
	}
	
	public void agregar(Object o) {
		if (!tieneLugar()) {
			incrementarEspacio();
		}
		arr[cant] = o;
		cant++;
	}
	
//	public void insertarOrdenado(Object user) {
//	int i=0;
//	boolean boton=false;
//	if(isEmpty()) {
//		arr[i] = user;
//		cant++;
//		System.out.println("esta vacio");
//	}
//	else {
//		while(!boton&&(i<tamanio())){
//		
//			if(Integer.parseInt(((Usuario) arr[i]).getDni()) > Integer.parseInt(((Usuario)user).getDni())){
//				corrimiento(i);
//				arr[i]=user;
//				boton=true;
//			}
//			i++; 
//		}
//	
//	}
//}

	public void insertarOrdenado(Usuario user) {
		int i = 0;
		boolean fin = false;

		if (!tieneLugar()) {
			incrementarEspacio();
		}

		if (isEmpty()) {
			agregar(user);
		} else {
			while (!fin && (i < tamanio())) {
				Usuario x = (Usuario) getElement(i);
				
				if(x.compareTo(user) > 0) {
					corrimiento(i);
					arr[i] = user;
					fin = true;
				} else {

					i++;
				}	
			}
		}
	}

	public void corrimiento(int indice) {
		if (cant < arr.length) {
			if (indice < tamanio()) {
				for (int j = cant; j > indice; j--) {
					arr[j] = arr[j - 1];
				}
				cant++;
			}
		} 
	}

	@Override
	public boolean existe(Object o) {
//		1er etapa
//		for (int i = 0; i < tamanio(); i++) {
//			if (arr[i].equals(o)) {
//				return true;
//			}
//		}
//		return false;

//		2da etapa
		return buscarUsuario(((Usuario)o), 0, cant);
	}

	private boolean buscarUsuario(Usuario user, int min, int max) {
		int medio = (max+min)/2;
		
		if(min != medio) {
			if(((Usuario)arr[medio]).compareTo(user) < 0){
				return buscarUsuario(user, medio, max);
			}
			else if(((Usuario)arr[medio]).compareTo(user) > 0){
				return buscarUsuario(user, 0, medio);
			}
			return true;
		}
		return false;
	}

	public Object getElement(int p) {
		if (p < arr.length && p >= 0) {
			return arr[p];
		}
		return null;
	}
	

}
