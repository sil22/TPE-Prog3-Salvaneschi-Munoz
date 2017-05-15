package appListaNodoInsertaAlPpio;

import ClasesNecesarias.Nodo;
import appListaNodo.ListaNodo;

public class  ListaNodoInsertarAlPpio extends ListaNodo {
	
	@Override
	public void agregar(Object o){
		Nodo aux=new Nodo(o,null);
		if(primero!=null){
			aux.setSig(primero);
			primero=aux;
		}
		else{
			primero=aux;
			}
			
		
	}

}
