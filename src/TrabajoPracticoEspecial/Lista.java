package TrabajoPracticoEspecial;

public abstract class Lista {
	int size = 0;
	
	public abstract void agregar(Object g);
	public abstract Object getElement(int posicion);
	public abstract boolean existe(Object o);
	public abstract int tamanio();
	public abstract void imprimir();
	
}
