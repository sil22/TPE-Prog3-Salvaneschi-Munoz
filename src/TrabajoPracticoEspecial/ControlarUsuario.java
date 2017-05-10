package TrabajoPracticoEspecial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControlarUsuario {
	
	public void cargarConListaArreglo(String path) {
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        ListaArreglo listaUsuarios = new ListaArreglo();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	               
                String[] items = line.split(cvsSplitBy);
                ListaArreglo aux=new ListaArreglo();
                Usuario user = new Usuario(items[0], aux);
                
                for (int i = 1; i < items.length; i++) {
                	user.agregarGusto(items[i]);
                }
                listaUsuarios.agregar(user);
            }
            listaUsuarios.imprimir();
        
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void cargarConListaNodo(String path) {
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        ListaNodo listaUsuarios = new ListaNodo();
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            		
                String[] items = line.split(cvsSplitBy);
                ListaNodo aux=new ListaNodo();
                Usuario user = new Usuario(items[0], aux);
                
                for (int i = 1; i < items.length; i++) {
                	user.agregarGusto(items[i]);
                }
                listaUsuarios.agregar(user);
            }
            listaUsuarios.imprimir();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void cargarConListaNodoAlPpio(String path) {
    	
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            		
                String[] items = line.split(cvsSplitBy);
             
                
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public static void main(String[] args) {
		ControlarUsuario control = new ControlarUsuario();
		String csvFile = "/Users/munoz/Documents/workspace/Programacion3/src/ProgramacionIII/TPE/dataset.csv";
	//	control.cargarConListaArreglo("/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_insert_10000.csv");
	//	control.cargarConListaNodo("/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_insert_10000.csv");
		control.cargarConListaNodo(csvFile);
	}

}
