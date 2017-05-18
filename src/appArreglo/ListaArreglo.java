package appArreglo;

import ClasesNecesarias.Lista;
import ClasesNecesarias.Usuario;

public class ListaArreglo extends Lista{
	Object arr [];
	int cant;
	
	public ListaArreglo(){
		arr= new Object [100];
		cant = 0;
	}
	public ListaArreglo(int a) {
		arr = new Object[a];
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
			System.out.println(arr[i].toString()+" ");
			
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
	
	public void insertarOrdenado(Object user) {
		int i=0;
		boolean boton=false;
		if(isEmpty()) {
			arr[i] = user;
			cant++;
			System.out.println("esta vacio");
		}
		else {
			while(!boton&&(i<tamanio())){
			
				if(Integer.parseInt(((Usuario) arr[i]).getDni()) > Integer.parseInt(((Usuario)user).getDni())){
					corrimiento(i);
					arr[i]=user;
					boton=true;
				}
				i++; 
			}
		
		}
	}
	
	
	public void corrimiento(int indice){
		if (cant<arr.length){
		if(indice < tamanio()){
			for (int j = cant; j > indice; j--) {
				arr[j] = arr[j-1];
			}cant++;
		}
	}
		else{
			System.out.println("exploto el arreglo");
		}
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
		
		ListaArreglo arr = new ListaArreglo();
		ListaArreglo gusto1=new ListaArreglo();
		gusto1.agregar("comoestas33");
		gusto1.agregar("comoestas22");
		gusto1.agregar("comoestas44");
		
		Usuario user1 = new Usuario("35", gusto1);
		Usuario user2= new Usuario("3", gusto1);
		Usuario user3 = new Usuario("5", gusto1);
		
		arr.insertarOrdenado(user1);
		arr.insertarOrdenado(user2);
		arr.insertarOrdenado(user3);

//		arr.agregar(3);
//		arr.agregar(1);
//		arr.agregar(4);
//		arr.agregar(6);
//		arr.agregar(7);
//		
//		arr.corrimiento(0);
	
		arr.imprimir();
	}

}
