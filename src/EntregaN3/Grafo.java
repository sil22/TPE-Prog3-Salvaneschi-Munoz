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
	
	public ArrayList<String> mismosGustos(String usuario){ 
	//dado un usuario, mostrarle las personas que tienen mas de un gusto en comun con el
		
		ArrayList<String> personasMismosGustos = new ArrayList<String>();//array resultado
		
		ArrayList<String> gustosUsuario=extraerGustos(usuario);//gustos que tiene el usuario pasado por parametro
		
		for (int i = 0; i < gustosUsuario.size(); i++) {
			int pos=aux.get(gustosUsuario.get(i));
			 
			if (vertices[pos].size()>1){
				for (int j = 0; j < vertices[pos].size(); j++) {
					
					String UsuarioAcomparar=vertices[pos].getElement(j);
					
					ArrayList<String>gustosSegUsuario=extraerGustos(UsuarioAcomparar);
					
					if(compartenDosGustos(gustosUsuario,gustosSegUsuario)&&(!usuario.equals(vertices[pos].getElement(j)))&&(!personasMismosGustos.contains(vertices[pos].getElement(j)))){
						personasMismosGustos.add(UsuarioAcomparar);
						
						
						
						
					}					
				}
			}						
		}
		return personasMismosGustos;
		
	
	}
	
	
	public String GustoMasPopular(){//devuelve el gusto mas popular
		
		int temporal=0;
		String nombre="";
		
		
		for (int i = 0; i < cont; i++) {
			if((vertices[i].getTipoDato()==TipoDato.gusto)){				
			
			if(temporal<vertices[i].size()){
				temporal=vertices[i].size();
				nombre=vertices[i].primero.getDato();
			}
		}
		
	}
		
		return nombre;
}
	
	
	
	
	public boolean compartenDosGustos(ArrayList<String> g1, ArrayList<String> g2){//Responde si los arreglos pasados como parametros, si tienen considencia en 2 ocurrencias
		int tiene = 0;
		for (int i = 0; i < g1.size(); i++) {
			for (int j = 0; j < g2.size(); j++) {
				if(g1.get(i).equals(g2.get(j))) {
					tiene++;
				}
				if(tiene == 2){ 
					return true;
			}

			}
		}
		
		return false;
	}
	
	public ArrayList<String> extraerGustos(String usuario ){//Extrae los gustos del Usuario pasado como parametro
		int pos=aux.get(usuario);
		ArrayList<String> resultado=new ArrayList<String>();
		for (int i = 0; i < vertices[pos].size(); i++) {
			String gusto=vertices[pos].getElement(i);
			resultado.add(gusto);
			}
		return resultado;
	}
	
	public String PersonaConGustoMasLejano(String usuario){//Devuelve el usuario que tenga gustos mas lejanos al pasado como parametro
		
		String resultado="";		
		
		if (this.existeUsuario(usuario)){			
			
			ArrayList<String> gustosUsuario=extraerGustos(usuario);
		
			
			int ocurrencia=gustosUsuario.size();
			
			for (int i = 0; i < vertices.length;i++) {
				
				if(vertices[i].getTipoDato()==TipoDato.gusto){					
					int tiempo=tantasVecesElGusto(gustosUsuario , vertices[i] , ocurrencia);					
					if(tiempo==ocurrencia){
						resultado=vertices[i].getPrimero().getDato();						
					}
					
					else if (tiempo < ocurrencia && tiempo != -1){
						ocurrencia=tiempo;						
						resultado=vertices[i].getPrimero().getDato();
					}				
				
				}
			}
			
	}
		return resultado;
	
	}
	
	public int tantasVecesElGusto(ArrayList<String> arreglo1, ListaNodo arreglo2, int ocurrencia){//Dado los dos arreglos de gustos, ya sea el del pasado como paramtro
		//o el del Usuario a comparar y la cantidad de ocurrencias, si es menor que el actual devuelve valor actualizado. Sino -1;
		
		int contador = 0;
		
		for (int i = 0; i < arreglo1.size(); i++) {
			
			for (int j = 0; j < arreglo2.size(); j++) {
				
				if(arreglo1.get(i).equals(arreglo2.getElement(j))){					
					contador++;
					if (contador > ocurrencia) {
						return -1;
					}
				}
			}
		}
		return contador;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Grafo g = new Grafo();
		g.agregarGusto("Tenis");
		g.agregarGusto("Futbol");
		g.agregarGusto("Hockey");
		g.agregarUsuario("123");
		g.agregarUsuario("321");
		g.agregarUsuario("222");
		g.agregarUsuario("358");
		g.agregarUsuario("453");
		
		
		g.agregarGustoUsuario("Tenis", "123");
		g.agregarGustoUsuario("Futbol", "123");
		g.agregarGustoUsuario("Tenis", "321");
		g.agregarGustoUsuario("Hockey", "321");
		g.agregarGustoUsuario("Futbol", "222");
		g.agregarGustoUsuario("Tenis", "222");
		g.agregarGustoUsuario("Hockey", "123");
		g.agregarGustoUsuario("Hockey", "453");
		
		ArrayList<String> mismos=g.mismosGustos("123");
		
		
		for (int i = 0; i < mismos.size(); i++) {
			//System.out.println(mismos.get(i));
			
		}
		String x=g.GustoMasPopular();
		System.out.println(x);
		
		
		
		
	}
	
	
	
}