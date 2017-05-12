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
	
	public void altaConListaArreglo(String path) {//LISTA ARREGLOOOO    ALTA
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
            	//System.out.println(resultado[1]);
            	listaUsuariosSalida.agregar(resultado);
            } 
           // listaUsuarios.imprimir();
            writeResultList(listaUsuariosSalida,"/Users/zurdo/Downloads/datasets_tpe/datasets//salidaAltaUsuarios.csv");
          
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void writeResultList(Lista listaUsuariosSalida, String path ) { //tendria que recibir la listaUdsuarios de la clase, recorrerla y guardar el dni y el timepo de ejec en cada linea
		BufferedWriter bw = null;
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			String[] resultadoRow;
			for (int i = 0; i < listaUsuariosSalida.tamanio(); i++){
				
				resultadoRow = (String[])listaUsuariosSalida.getElement(i);
				String toWrite = "";
				for (int j = 0; j < resultadoRow.length -1; j++) {
					toWrite += resultadoRow[j] + ";";
				}
				toWrite += resultadoRow[resultadoRow.length-1];
				bw.write(toWrite);
				bw.newLine();				
			}

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
        ListaArreglo salidaBusqueda = new ListaArreglo();
        Usuario userAux = null;
      
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	
            	String[] resultado = new String[3];
                   	               
                String[] items = line.split(cvsSplitBy);
                inicio = System.currentTimeMillis();
                
                resultado[0]=items[0];
                
                userAux = new Usuario(items[0], null);
                boolean existe = listaUsuarios.existe(userAux);
                               
                if (existe){
                	resultado[2]="ENCONTRADO";
                }
                else
                	resultado[2]="No Encontrado";
                              
                               
                fin = System.currentTimeMillis();
        		tiempoTotal = fin - inicio;
        		
        		resultado[1]=Long.toString(tiempoTotal);
        		salidaBusqueda.agregar(resultado);        		    
            }
            
            writeResultList(salidaBusqueda,"/Users/zurdo/Downloads/datasets_tpe/datasets//salidaBusquedaUsuarios.csv");            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }   
    
	
	public void altaConListaNodo(String path) {//LISTA NODO                    ALTAAA
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        listaUsuarios = new ListaNodo();
        long inicio, fin, tiempoTotal;
        ListaNodo listaUsuariosSalida=new ListaNodo();
		
        inicio = System.currentTimeMillis();
        
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
            	//System.out.println(resultado[1]);//Imprimo tiempo
            	listaUsuariosSalida.agregar(resultado);
            }   //listaUsuarios.imprimir();
            writeResultList(listaUsuariosSalida,"/Users/zurdo/Downloads/datasets_tpe/datasets//salidaAltaUsuarios.csv");
          
        
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void altaConListaNodoAlPpio(String path) {//LISTA NODO PRINCIPIO    ALTAAAA
    	
		String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        listaUsuarios = new ListaNodoInsertarAlPpio();
        long inicio, fin, tiempoTotal;
        ListaNodoInsertarAlPpio listaUsuariosSalida=new ListaNodoInsertarAlPpio();
		
        inicio = System.currentTimeMillis();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

        	while ((line = br.readLine()) != null) {
            	String[] resultado = new String[2];
            	               
                String[] items = line.split(cvsSplitBy);
                resultado[0] = items[0];
                
                inicio = System.currentTimeMillis();
                ListaNodoInsertarAlPpio aux=new ListaNodoInsertarAlPpio();
                Usuario user = new Usuario(items[0], aux);
                
                for (int i = 1; i < items.length; i++) {
                	user.agregarGusto(items[i]);
                }
                listaUsuarios.agregar(user);
                fin = System.currentTimeMillis();
                
            	tiempoTotal = fin - inicio;
            	resultado[1] = Long.toString(tiempoTotal);
            	System.out.println(resultado[1]);//Imprimo tiempo
            	listaUsuariosSalida.agregar(resultado);
            }   //listaUsuarios.imprimir();
            writeResultList(listaUsuariosSalida,"/Users/zurdo/Downloads/datasets_tpe/datasets//salidaAltaUsuarios.csv");
          
        
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

	
	public static void main(String[] args) {
		ControlarUsuario control = new ControlarUsuario();
		String csvFile = "/Users/munoz/Documents/workspace/Programacion3/src/ProgramacionIII/TPE/dataset.csv";
		String csvFileInsert = "/Users/zurdo/Downloads/datasets_tpe/datasets/dataset_1000000.csv";
		String csvBusqueda = "/Users/zurdo/Downloads/datasets_tpe/datasets/dataset_busqueda_10000.csv";//de aca salen los que vamos a buscar
		
	//	control.altaConListaArreglo(csvFileInsert);
		control.altaConListaNodo(csvFileInsert);
	//	control.altaConListaNodoAlPpio(csvFileInsert);

		control.busqueda(csvBusqueda);
		System.out.println("Termine");
	}

}
