package TrabajoPracticoEspecial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControlarUsuario {
	private static Lista listaUsuarios;
	
	public void altaConListaArreglo(String path) {
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        listaUsuarios = new ListaArreglo();
        long inicio, fin, tiempoTotal;
        Lista listaUsuariosSalida = new ListaArreglo();
		
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	String[] resultado = new String[2];
            	               
                String[] items = line.split(cvsSplitBy);
                resultado[0] = items[0];
                
                inicio = System.currentTimeMillis();
                ListaArreglo aux=new ListaArreglo();
                Usuario user = new Usuario(items[0], aux);
                
                for (int i = 1; i < items.length; i++) {
                	user.agregarGusto(items[i]);
                }
                listaUsuarios.agregar(user);
                fin = System.currentTimeMillis();
                
            	tiempoTotal = fin - inicio;
            	resultado[1] = Long.toString(tiempoTotal);
            	listaUsuariosSalida.agregar(resultado);
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void salidaAltaUsuarios() { //tendria que recibir la listaUdsuarios de la clase, recorrerla y guardar el dni y el timepo de ejec en cada linea
		BufferedWriter bw = null;
		try {
			File file = new File("/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets//salidaAltaUsuarios.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			// Escribo la primer linea del archivo
			String contenidoLinea1 = "Usuario1;Tiempo1";
			bw.write(contenidoLinea1);
			bw.newLine();

			// Escribo la segunda linea del archivo
			String contenidoLinea2 = "Usuario2;Tiempo2";
			bw.write(contenidoLinea2);
			bw.newLine();
			
			/*
			 *
			 * ... 
			 * 
			*/

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	
	}
	
    public void busqueda(String path){
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        long inicio, fin, tiempoTotal;
        ArrayList<IdBuscado> resultado = new ArrayList<IdBuscado>();
		
      
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	               
                String[] items = line.split(cvsSplitBy);
                inicio = System.currentTimeMillis();
                boolean existe = listaUsuarios.existe(items[0]);
                
                if (existe){
                }
               
                fin = System.currentTimeMillis();
        		
        		tiempoTotal = fin - inicio;
        		System.out.println(" ");
        		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
             
            }
            listaUsuarios.imprimir();
            
          
        
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    
	
	public void altaConListaNodo(String path) {
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        listaUsuarios = new ListaNodo();
        long inicio, fin, tiempoTotal;
		
        inicio = System.currentTimeMillis();
        
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
            fin = System.currentTimeMillis();
    		
    		tiempoTotal = fin - inicio;
    		System.out.println(" ");
    		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");

        
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void altaConListaNodoAlPpio(String path) {
    	
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        listaUsuarios = new ListaNodoInsertarAlPpio();
        long inicio, fin, tiempoTotal;
		
        inicio = System.currentTimeMillis();

        
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
            fin = System.currentTimeMillis();
    		
    		tiempoTotal = fin - inicio;
    		System.out.println(" ");
    		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");

        
        } catch (IOException e) {
            e.printStackTrace();
        }

        
	}
	

	
	public static void main(String[] args) {
		ControlarUsuario control = new ControlarUsuario();
		String csvFile = "/Users/munoz/Documents/workspace/Programacion3/src/ProgramacionIII/TPE/dataset.csv";
		String csvFileInsert = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_insert_10000.csv";
		String csvBusqueda = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_busqueda_10000.csv";
		
		control.altaConListaArreglo(csvFileInsert);
	//	control.busqueda(csvBusqueda);
	//	control.cargarConListaNodo(csvFile);
	//	control.cargarConListaNodoAlPpio(csvFile);
	}

}
