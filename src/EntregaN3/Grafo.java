package EntregaN3;

import java.util.*;
public class Grafo {
	
	HashMap<String, Integer> aux;
	ListaNodo[] vertices;
	int cont;
	
	public Grafo(){
		aux = new HashMap<String, Integer>(); // relacion id_nodo-string . usuando hashmap podemos ver que informacion contiene que nodo.
		vertices = new ListaNodo[1000];
		cont = 0;
	}
	
	public int getCantVertices() {
		return cont;
	}
	
	public boolean tieneLugar() {
		return cont + 1 < vertices.length;
	}
	
	public void incrementarEspacio() {
		ListaNodo[] nuevoArreglo = new ListaNodo[vertices.length * 2];
		for (int i = 0; i < vertices.length; i++) {
			nuevoArreglo[i] = vertices[i];
		}
		vertices = nuevoArreglo;
	}
	
	public void agregarUsuario(String user) {
		if (!tieneLugar()) {
			incrementarEspacio();
		}
		if(!existeUsuario(user)) {
		vertices[cont] = new ListaNodo();
		aux.put(user, cont);
		cont++;
		}
	}

	public void agregarGusto(String gusto) {
		if (!tieneLugar()) {
			incrementarEspacio();
		}
		if(!existeGusto(gusto)) {
			vertices[cont] = new ListaNodo();
			aux.put(gusto, cont);
			cont++;			
		}
	}

	public void agregarGustoUsuario(String gusto, String user) {
	
		int vUsuario = aux.get(user);
		int vGusto = aux.get(gusto);
		
		vertices[vUsuario].agregar(gusto, TipoDato.gusto);
		vertices[vGusto].agregar(user, TipoDato.idUsuario);
	
	}
 
	public boolean existeGusto(String gusto){
		return aux.containsKey(gusto);
	}
	
	public boolean existeUsuario(String usuario){
		return aux.containsKey(usuario);
	}
	
//	public ArrayList<String> gustoMasRpetido(String usuario){ 
//	//dado un usuario, mostrarle las personas que tienen mas de un gusto en comun con el
//		ArrayList<String> personasMismosGustos = new ArrayList<String>();
//		
//	
//	}
	
	public static void main(String[] args) {
		
		Grafo g = new Grafo();
		g.agregarGusto("Tenis");
		g.agregarGusto("Futbol");
		g.agregarGusto("Hockey");
		g.agregarUsuario("123");
		g.agregarUsuario("321");
		g.agregarUsuario("222");
		
		g.agregarGustoUsuario("Tenis", "123");
		g.agregarGustoUsuario("Futbol", "123");
		g.agregarGustoUsuario("Tenis", "321");
		g.agregarGustoUsuario("Hockey", "321");
		g.agregarGustoUsuario("Futbol", "222");
		
		

		
		
		
		
	}
	
	
	
}