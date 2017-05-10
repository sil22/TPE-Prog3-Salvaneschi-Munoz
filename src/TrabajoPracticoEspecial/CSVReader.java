package TrabajoPracticoEspecial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * Ejemplo de cómo leer un archivo CSV
 * 
 * @author Mariano A. Fernandez <fernandez.mariano.a@gmail.com>
 */

public class CSVReader {

    public static void main(String[] args) {

    	String csvFile = "/Users/munoz/Documents/TUDAI/2DO AÑO - 2017/1er cuatrimestre/Programacion 3/Practicos/Practico Especial/datasets/dataset_insert_10000.csv";
        String line = "";
        String cvsSplitBy = ";";
        
        ListaNodo listaNodo = new ListaNodo();
        long inicio, fin, tiempoTotal;
	
		inicio = System.currentTimeMillis();
	
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                
                listaNodo.agregar(line);
                
            }
            System.out.println(listaNodo.toString());
        	fin = System.currentTimeMillis();
    		
    		tiempoTotal = fin - inicio;
    		System.out.println(" ");
    		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }
