/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adficheros_2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
Antes de ejecutar crear C:\\FichTexto.txt
*/
/**
 *
 * @author wadmin
 */

public class ADFicheros_2 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\FichTexto.txt");//declara fichero          
        FileWriter ficW = new FileWriter(fichero); //crear el flujo de salida       
        String cadena ="Esto es una prueba con FileWriter";
        char[] cad = cadena.toCharArray();//convierte un String en array de caracteres
        for(int i=0; i<cad.length; i++)
            ficW.write(cad[i]);  //se va escribiendo un carácter
        ficW.append('*'); //añado al final un *   
        ficW.write(cad);//escribir un array de caracteres   
        String c="\n*esto es lo ultimo*";
        ficW.write(c);//escribir un String   
        String prov[] ={"Albacete","Avila","Badajoz","Jaén","Madrid","Toledo","Valencia","Zamora"};
        ficW.write("\n");
        for(int i=0; i<prov.length; i++) {           
            ficW.write(prov[i]);         
            ficW.write("\n");   
        }
        ficW.close();    //cerrar fichero
        
        FileReader ficR = new FileReader(fichero); //crear el flujo de entrada   
        int i;
        while ((i = ficR.read()) != -1) //se va leyendo un carácter
            System.out.println( (char) i + "==>"+ i);
        ficR.close(); //cerrar fichero   
        
    }
  
}
