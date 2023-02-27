
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Núñez Avila Jose Flaviano
 */
public class Test {
    public static AlgoritmoSDV algoritmo;
    public static void main(String args[]) throws ExcepcionLongitudClave, IOException{
        //String clave = AlgoritmoSDV.generarClave();
            
        //CIFRAR y DESCIFRAR Strings
        String msg = "holaaaa";
        String clave = "BNMVCXZASDFGHJKLÑPOIUYTREWQlkjhgfdsazxcvbnmpoiuytrewq7896543210*";
        long constante = 123456789;//(long) (Math.random()*(1000000000-1000000)) + 1000000
        algoritmo = new AlgoritmoSDV(clave, constante);
        
        String msgCifrado = AlgoritmoSDV.cifrar(msg, clave, constante);
        String msgDescifrado = AlgoritmoSDV.descifrar(msgCifrado,clave, constante);
        
        System.out.println("Mensaje:            " + msg);
        System.out.println("Mensaje Cifrado:    " + msgCifrado);
        System.out.println("Mensaje Descifrado: "+msgDescifrado+"\n\n");
        
        
        //CIFRAR ARCHIVO, los archivos cifrados se almacenan con extension .enc
        //algoritmo.cifrarArchivo("path/archivo/vas/a/cifrar.txt", "/path/archivo/donde/vas/almacenar/el/archivo/cifrado"); //El nombre del archivo donde se va guardar el archivo cifrado no agregarle extesion
        //Example
        algoritmo.cifrarArchivo("D:\\Documents\\Fotos\\fotoPlaya.png", "D:\\Documents\\Fotos\\fotoCifrada");
        System.out.println("[+] Se ha cifrado el Archivo");
        
        
        //DESCIFRAR ARCHIVO
        //algoritmo.descifrarArchivo("path/archivo/vas/a/descifrar.enc", "/path/archivo/donde/vas/almacenar/el/archivo/descifrado"); //El nombre del archivo donde se va guardar el archivo cifrado no agregarle extesion
        //Ejemplo:
        algoritmo.descifrarArchivo("D:\\Documents\\Fotos\\fotoCifrada.enc", "D:\\Documents\\Fotos\\fotoDescifrada");
        System.out.println("[+] Se ha descifrado el Archivo");
    }
    
}
