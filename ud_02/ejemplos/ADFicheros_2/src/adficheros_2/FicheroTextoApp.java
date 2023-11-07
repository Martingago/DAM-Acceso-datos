/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adficheros_2;

/**
 *
 * @author wadmin
 */

/*
Antes de ejecutarlo crear el archivo C:\\fichero1.txt
Ejecutarlo y ver que hace (fijaros en como escribimos en el archivo y que es lo que realmente contiene el erchivo.
Ahora intercambiar los nombres de los métodos main(...) y main1(...). Volver a ejecutar.
¿Se está leyendo el archivo?
Modificar el método main(..) para que funcione correctamente añadiendo la siguiente linea de código (buscar donde debe ir)
                        fw.flush();
*/
import java.io.*; 
public class FicheroTextoApp {
    public static void main(String[] args) {
        try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw=new FileWriter("C:\\fichero1.txt");
            //Escribimos en el fichero un String y un caracter
            fw.write("Hol");
            fw.write(97);
            //Cierro el stream
            fw.close(); 
            //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("C:\\fichero1.txt");
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
            //Cerramos el stream
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
    
    public static void main1(String[] args) {
        try{
            //Creo los objetos, abro streams
            FileWriter fw=new FileWriter("C:\\fichero1.txt");
            FileReader fr=new FileReader("C:\\fichero1.txt");

            //Escribimos en el fichero un String y un caracter 97 (a)
            fw.write("Hol");
            fw.write(97);

            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }

            //Cerramos el stream
            fw.close();
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
}
