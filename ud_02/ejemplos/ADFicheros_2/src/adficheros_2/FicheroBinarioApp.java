/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adficheros_2;

/**
 *
 * @author wadmin
 */
import java.io.*;
/*
Antes de ejecutar: crear el fichero  C:\\fichero_bin.ddr
Ejecutar el código
Ahora sustituir el path del FileInputStream por el de una archivo imagen pequeño.
Comprobar la salida del código al ejecutarlo.
*/
public class FicheroBinarioApp {
    public static void main(String[] args) {
        try(FileOutputStream fos=new FileOutputStream("C:\\fichero_bin.ddr")){
            String texto="Esto es una prueba para ficheros binariosssss";
            // Podemos usar un numero que corresponderá a la tabla ASCII o un array de bytes
            //Copiamos el texto en un array de bytes
            byte codigos[]=texto.getBytes();
            fos.write(codigos);
        }catch(IOException e){
             System.out.println("Error E/S: "+e);
        }
        try(FileInputStream fis=new FileInputStream("C:\\fichero_bin.ddr")){
            int valor=fis.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fis.read();
            }
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
}
    
