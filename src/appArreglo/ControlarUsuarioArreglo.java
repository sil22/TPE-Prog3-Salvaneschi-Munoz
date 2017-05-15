package appArreglo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ClasesNecesarias.*;

public class ControlarUsuarioArreglo {
	private static Lista listaUsuarios;
	
	public ControlarUsuarioArreglo() {
		int a = 9999; 
		listaUsuarios = new ListaArreglo(a);
	}
	
	public void precarga(String path) {
		String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
       
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	while ((line = br.readLine()) != null) {
            	
            	               
                String[] items = line.split(cvsSplitBy); 
                
                ListaArreglo auxGustos =new ListaArreglo();  //creo la lista que le voy a pasar al usuario
                Usuario user = new Usuario(items[0], auxGustos);
                
                for (int i = 1; i < items.length; i++) {  //recorro el arr items que tiene los gustos a partir de la pos 1 y los agrego como gustos del usuario nuevo 
                	user.agregarGusto(items[i]);   
                }
                
                listaUsuarios.agregar(user); 
        	} 
          
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void alta(String path, int preCarga) {
    	String csvFile = path;
        String line = "";
        String cvsSplitBy = ";";
        long inicio, fin, tiempoTotal;
        ListaArreglo listaUsuariosSalida = new ListaArreglo();
		
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
        	while ((line = br.readLine()) != null) {
       	
            	String[] resultado = new String[2];
            	               
                String[] items = line.split(cvsSplitBy); 
                resultado[0] = items[0];   // guardo el dni
                
                inicio = System.nanoTime();
                ListaArreglo aux=new ListaArreglo();  //creo la lista que le voy a pasar al usuario
                Usuario user = new Usuario(items[0], aux);
                
                for (int i = 1; i < items.length; i++) {  //recorro el arr items que tiene los gustos a partir de la pos 1 y los agrego como gustos del usuario nuevo 
                	user.agregarGusto(items[i]);   
                }
                
                listaUsuarios.agregar(user);
                
                fin = System.nanoTime();
            	tiempoTotal = fin - inicio;
            	resultado[1] = Long.toString(tiempoTotal);  //guardo el tiempo de cada operacion
            	
            	listaUsuariosSalida.agregar(resultado);  //agregao a la lista que voy a leer para escribir el archivo csv
        	} 
            escribirResultadoLista(listaUsuariosSalida,"/Users/munoz/Documents/workspace/TPE_Prog3_Salvaneschi_Munoz/src/CsvSalidas/salidaAltaUsuarios"+preCarga+".csv");
          
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	

    public void busqueda(String path, int preCarga){
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
            
            escribirResultadoLista(salidaBusqueda,"/Users/munoz/Documents/workspace/TPE_Prog3_Salvaneschi_Munoz/src/CsvSalidas/salidaBusquedaUsuarios"+preCarga+".csv");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }   

	
	public void escribirResultadoLista(Lista listaUsuariosSalida, String path ) { 
		BufferedWriter bw = null;
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			String[] resultadoLinea = new String[2];
			
			
			for (int i = 0; i < listaUsuariosSalida.tamanio(); i++){
				
				resultadoLinea = (String[])listaUsuariosSalida.getElement(i);
				String aEscribir = "";
				for (int j = 0; j < resultadoLinea.length -1; j++) {
					aEscribir += resultadoLinea[j] + ";";
				}
				aEscribir += resultadoLinea[resultadoLinea.length-1];
				bw.write(aEscribir);
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
	
	public static void main(String[] args) {
		ControlarUsuarioArreglo control = new ControlarUsuarioArreglo();
		String csvFileInsert = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_insert_10000.csv";
		String csvBusqueda = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_busqueda_10000.csv";
		String csv5 = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_500000.csv";
		String csv1 = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_1000000.csv";
		String csv3 = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_3000000.csv";

		int c = 500000;
		control.precarga(csv5);
		control.alta(csvFileInsert, c);
//		control.busqueda(csvBusqueda, c);
		
//		int u = 1000000;
//		control.precarga(csv1);
//		control.alta(csvFileInsert, u);
//		control.busqueda(csvBusqueda, u);

//		int t = 3000000;
//		control.precarga(csv3);
//		control.alta(csvFileInsert, t);
//		control.busqueda(csvBusqueda, t);

		
		
		System.out.println("Termine");
	}

}
