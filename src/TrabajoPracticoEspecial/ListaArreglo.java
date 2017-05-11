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

}
