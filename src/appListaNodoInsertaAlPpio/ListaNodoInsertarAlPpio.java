package appListaNodoInsertaAlPpio;

import ClasesNecesarias.Nodo;
import appListaNodo.ListaNodo;

public class  ListaNodoInsertarAlPpio extends ListaNodo {
	
	@Override
	public void agregar(Object o){
		Nodo newNodo = new Nodo(o, null);
		newNodo.setSig(primero);
		primero = newNodo;
		tamanio++;

		
	}

}
