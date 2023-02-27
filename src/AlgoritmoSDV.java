
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
//import org.apache.commons.lang3.ArrayUtils;


/**
 * @descripcion: Algoritmo de cifrado SDV(Sustitucion por Desplazamiento de variable).
 *               Tipo cifrado Cesar.
 * 
 * @author Núñez Avila Jose Flaviano
 */
public class AlgoritmoSDV {
    
    
    private String strClave;
    //private String defaultCaracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
    private long constante;
    private int longitudClave;
    private int BLOCKSIZE = 64;
    
    
    public AlgoritmoSDV () throws ExcepcionLongitudClave {
        this.strClave = this.generarClave();
        this.constante = this.generarConstante();
        this.longitudClave = this.strClave.length();
    }
    
    
    public AlgoritmoSDV (String clave) throws ExcepcionLongitudClave {
        this.setClave(clave);
        this.constante = this.generarConstante();
        this.longitudClave = this.strClave.length();
    }
    
    
    public AlgoritmoSDV (int constante) {
        this.strClave = this.generarClave();
        this.constante = constante;
        this.longitudClave = this.strClave.length();
    }
    
    
    public AlgoritmoSDV (long constante) {
        this.strClave = this.generarClave();
        this.constante = constante;
        this.longitudClave = this.strClave.length();
    }
    
    public AlgoritmoSDV (String clave, int intClave) throws ExcepcionLongitudClave {
        this.setClave(clave);
        this.constante = intClave;
        this.longitudClave = this.strClave.length();
    }
    
    public AlgoritmoSDV (String clave, long intClave) throws ExcepcionLongitudClave {
        this.setClave(clave);
        this.constante = intClave;
        this.longitudClave = this.strClave.length();
    }
    
    
    public void setClave(String clave) throws ExcepcionLongitudClave {
        if(clave.length() >= 64 && clave.length() <= 256)
            this.strClave = clave;
        else if(clave.length() > 256)
            throw new ExcepcionLongitudClave("La longitud de la clave debe tener un máximo de 256 caracteres.");
        else
            throw new ExcepcionLongitudClave("La longitud de la clave debe tener un minimo de 64 caracteres.");
    }
    
    
    public void setConstante(long constante){
        this.constante = constante;
    }
    
    
    public void setTamanoBloque(int tamanoBloque){
        this.BLOCKSIZE = tamanoBloque;
    }
    
    
    public String getStrClave() {
        return this.strClave;
    }
    
    
    public static int[] getBytesClave(String clave){
        int[] intClave = new int[clave.length()]; 
        char[] sClave = clave.toCharArray();
        for(int i=0; i<clave.length(); i++){
            intClave[i] = (int)sClave[i];
        }
        return intClave;
    }
    
    
    public long getConstante(){
        return this.constante;
    }
    
    
    public int getTamanoBloque() {
        return this.BLOCKSIZE;
    }
    
    
    public static int[] stringToArrayInt(String str){
        char[] charArray = str.toCharArray();
        int[] intArray = new int[charArray.length];
        for(int i=0; i<charArray.length; i++){
            intArray[i] = (int)charArray[i];
        }
        return intArray;
    }
    
    
    public static String arrayIntToString(int[] arrInt){
        char[] charArray = new char[arrInt.length];
        for(int i=0; i<arrInt.length; i++){
            charArray[i] = (char)arrInt[i];
        }
        String str = new String(charArray);
        return str;
    }
    
    
    public static String generarClave() {
        
        String rClave;
        StringBuilder tmp_rClave = new StringBuilder();
        int caracterIndice = 4; // A partir de este caracter se tomaran para hacer la clave simetrica
        for(int i=0; i<256; i++){
            tmp_rClave.append((char)caracterIndice);
            caracterIndice++;
        }
        rClave = tmp_rClave.toString();
        
        
        String[] strArray = rClave.split("");
        List<String> strList = Arrays.asList(strArray);
        Collections.shuffle(strList);
        rClave = String.join("", strList);
        return rClave;    
    }
    
    
    public static String generarClave(int longitudClave) throws ExcepcionLongitudClave {
        
        String rClave = "";
        
        if(longitudClave < 64)
            throw new ExcepcionLongitudClave("La longitud de la clave debe ser un minimo de 64 caracteres.");
        else if(longitudClave > 256)
            throw new ExcepcionLongitudClave("La longitud de la clave debe ser un maximo de 256 caracteres.");
        else{
            StringBuilder tmp_rClave = new StringBuilder();
            int caracterIndice = 1; // A partir de este caracter se tomaran para hacer la clave simetrica
            for(int i=0; i<longitudClave; i++){
                tmp_rClave.append((char)caracterIndice);
                caracterIndice++;
            }
            rClave = tmp_rClave.toString();
        }
        
        String[] strArray = rClave.split("");
        List<String> strList = Arrays.asList(strArray);
        Collections.shuffle(strList);
        rClave = String.join("", strList);
        return rClave;    
    }
    
    
    public static long generarConstante() {
        long rcons = (long) (Math.random()*(1000000000-1000000)) + 1000000;
        return rcons;
    }
    
    
    public static int[] convertirByteArrayToArrayInt(byte[] datos){
        int[] arrayInt = new int[datos.length]; 
        for(int i=0; i<datos.length; i++){
            arrayInt[i] = datos[i] & 0xff;
        }
        return arrayInt;
    }
    
    private static int buscarIndice(int clave[], int dato) {

        for (int index = 0; index < clave.length; index++) {
            if (clave[index] == dato)
                return index;
        }
        return -1;
    }
    
    
    public String cifrar(int[] datos) {
        long acumulador = 1;
        int[] bytesCifrados = new int[datos.length];
        int[] bytesClave = this.getBytesClave(this.getStrClave());
        int indiceClave;
        long nuevoIndice;
        
        for(int i=0; i<datos.length; i++){
            indiceClave = this.buscarIndice(bytesClave, datos[i]);
            if(indiceClave >= 0) {
                nuevoIndice = (indiceClave + this.constante + acumulador) % this.longitudClave;
                bytesCifrados[i] = bytesClave[(int)nuevoIndice];
            }else {
                bytesCifrados[i] = datos[i];
            }
            acumulador += this.constante;
        }
        
        String datosCifrados = this.arrayIntToString(bytesCifrados);
        return datosCifrados;
    }
    
    
    public String cifrar(String strDatos) {
        long acumulador = 1;
        int[] datos = this.stringToArrayInt(strDatos);
        int[] bytesCifrados = new int[datos.length];
        int[] bytesClave = this.getBytesClave(this.getStrClave());
        int indiceClave;
        long nuevoIndice;
        
        for(int i=0; i<datos.length; i++){
            indiceClave = this.buscarIndice(bytesClave, datos[i]);
            if(indiceClave >= 0) {
                nuevoIndice = (indiceClave + this.constante + acumulador) % this.longitudClave;
                bytesCifrados[i] = bytesClave[(int)nuevoIndice];
            } else {
                bytesCifrados[i] = datos[i];
            }
            acumulador += this.constante;
        }
        
        String datosCifrados = this.arrayIntToString(bytesCifrados);
        return datosCifrados;
    }
    
    public static String cifrar(String strDatos, String clave, long constante) {
        long acumulador = 1;
        int[] datos = AlgoritmoSDV.stringToArrayInt(strDatos);
        int[] bytesCifrados = new int[datos.length];
        int[] bytesClave = AlgoritmoSDV.getBytesClave(clave);
        int indiceClave;
        long nuevoIndice;
        
        for(int i=0; i<datos.length; i++){
            indiceClave = AlgoritmoSDV.buscarIndice(bytesClave, datos[i]);
            if(indiceClave >= 0) {
                nuevoIndice = (indiceClave + constante + acumulador) % clave.length();
                bytesCifrados[i] = bytesClave[(int)nuevoIndice];
            }else {
                bytesCifrados[i] = datos[i];
            }
            acumulador += constante;
        }
        
        String datosCifrados = AlgoritmoSDV.arrayIntToString(bytesCifrados);
        return datosCifrados;
    }
    
    public String descifrar(int[] datos) {
        long acumulador = 1;
        int[] bytesDescifrados = new int[datos.length];
        int[] bytesClave = this.getBytesClave(this.getStrClave());
        int indiceClave;
        long nuevoIndice;
        
        for(int i=0; i<datos.length; i++){
            indiceClave = this.buscarIndice(bytesClave, datos[i]);
            if(indiceClave >= 0) {
                int indiceBuscado = 0;
                while(((indiceBuscado + this.constante + acumulador) % this.longitudClave) != indiceClave) {
                    indiceBuscado++;
                }
                nuevoIndice = indiceBuscado;
                bytesDescifrados[i] = bytesClave[(int)nuevoIndice];
            }else {
                bytesDescifrados[i] = datos[i];
            }
            acumulador += this.constante;
        }
        
        String datosDescifrados = this.arrayIntToString(bytesDescifrados);
        return datosDescifrados;
    }
    
    
    public String descifrar(String strDatos) {
        long acumulador = 1;
        int[] datos = this.stringToArrayInt(strDatos);
        int[] bytesDescifrados = new int[datos.length];
        int[] bytesClave = this.getBytesClave(this.getStrClave());
        int indiceClave;
        long nuevoIndice;
        
        for(int i=0; i<datos.length; i++){
            indiceClave = this.buscarIndice(bytesClave, datos[i]);
            if(indiceClave >= 0) {
                int indiceBuscado = 0;
                while(((indiceBuscado + this.constante + acumulador) % this.longitudClave) != indiceClave) {
                    indiceBuscado++;
                }
                nuevoIndice = indiceBuscado;
                bytesDescifrados[i] = bytesClave[(int)nuevoIndice];
            }else {
                bytesDescifrados[i] = datos[i];
            }
            acumulador = acumulador + this.constante;
        }
        
        String datosDescifrados = this.arrayIntToString(bytesDescifrados);
        return datosDescifrados;
    }
    
    
    public static String descifrar(String strDatos, String clave, long constante) {
        long acumulador = 1;
        int[] datos = AlgoritmoSDV.stringToArrayInt(strDatos);
        int[] bytesDescifrados = new int[datos.length];
        int[] bytesClave = AlgoritmoSDV.getBytesClave(clave);
        int indiceClave;
        long nuevoIndice;
        
        for(int i=0; i<datos.length; i++){
            indiceClave = AlgoritmoSDV.buscarIndice(bytesClave, datos[i]);
            if(indiceClave >= 0) {
                int indiceBuscado = 0;
                while(((indiceBuscado + constante + acumulador) % clave.length()) != indiceClave) {
                    indiceBuscado++;
                }
                nuevoIndice = indiceBuscado;
                bytesDescifrados[i] = bytesClave[(int)nuevoIndice];
            }else {
                bytesDescifrados[i] = datos[i];
            }
            acumulador = acumulador + constante;
        }
        
        String datosDescifrados = AlgoritmoSDV.arrayIntToString(bytesDescifrados);
        return datosDescifrados;
    }
    
    
    public int cifrarArchivo(String rutaArchivo, String rutaNuevoArchivo) {
        try {
            byte[] bytesLeidos = new byte[BLOCKSIZE];
            int[] intLeidos = new int[BLOCKSIZE];
            String strCifrado;
            
            //Obtener extension la extension del archivo para cifrarla junto con las datos del archivo cifrado, y asi cuando el archivo se descifre,
            // la extension del archivo estara almacenada para volver a como estaba con su extension original
            String[] arr = rutaArchivo.split("\\.");
            //Añadir el caracter Ascii 1 para identificar la terminacion de la extension, para saber donde empieza la lectura de los datos del archivo
            String extensionArchivo = arr[arr.length-1] + (char)1; 
            
            //Añadiendo extension enc al nombre del archivo cifrado
            rutaNuevoArchivo = rutaNuevoArchivo+".enc";
            
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(rutaArchivo)));
            DataOutputStream archivoCifrado = new DataOutputStream(new FileOutputStream(rutaNuevoArchivo));
            
            byte[] bytesDatosConExtension = new byte[BLOCKSIZE-extensionArchivo.length()];
            int finDeArchivo = input.read(bytesDatosConExtension,0,bytesDatosConExtension.length);
            
            //Se añade la extension del archivo original al princicio del archivo cifrado
            intLeidos = IntStream.concat(Arrays.stream(this.stringToArrayInt(extensionArchivo)), Arrays.stream(this.convertirByteArrayToArrayInt(bytesDatosConExtension))).toArray();
            strCifrado = this.cifrar(intLeidos);
            
            while(finDeArchivo != -1) {
                
                // Excribir bytes cifrados
                archivoCifrado.writeBytes(strCifrado);
                
                 //Limpio los arrays de lectura
                Arrays.fill(intLeidos, 0);
                bytesLeidos = new byte[BLOCKSIZE];
                finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);
                intLeidos = this.convertirByteArrayToArrayInt(bytesLeidos);
                strCifrado = this.cifrar(intLeidos);
            }
            input.close();
            archivoCifrado.close();
        } catch(FileNotFoundException fex) {
            System.out.println(fex.getMessage());
            return 1;
        } catch(IOException iex) {
            System.out.println(iex.getMessage());
            return 2;
        }
        return 0;
    }
    
    public int cifrarArchivoCopia(String rutaArchivo, String rutaNuevoArchivo) {
        try {
            byte[] bytesLeidos = new byte[BLOCKSIZE];
            int[] intLeidos = new int[BLOCKSIZE];
            String strCifrado;
            
            
            
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(rutaArchivo)));
             
            DataOutputStream archivoCifrado = new DataOutputStream(new FileOutputStream(rutaNuevoArchivo));
            
            int finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);
            
            while(finDeArchivo != -1) {
                
                // Se leen bytes del archivo, se cifran y se escriben en el archivo nuevo.
                intLeidos = this.convertirByteArrayToArrayInt(bytesLeidos);
                strCifrado = this.cifrar(intLeidos);
                archivoCifrado.writeBytes(strCifrado);
                
                 //Limpio los arrays de lectura
                Arrays.fill(intLeidos, 0);
                bytesLeidos = new byte[BLOCKSIZE];
                finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);
            }
            input.close();
            archivoCifrado.close();
        } catch(FileNotFoundException fex) {
            System.out.println(fex.getMessage());
            return 1;
        } catch(IOException iex) {
            System.out.println(iex.getMessage());
            return 2;
        }
        return 0;
    }
    
    
    public int descifrarArchivo(String rutaArchivo, String rutaNuevoArchivo) {
        try {
            byte[] bytesLeidos = new byte[BLOCKSIZE];
            int[] intLeidos = new int[BLOCKSIZE];
            String strDescifrado;
            
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(rutaArchivo)));
            
            int finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);
            intLeidos = this.convertirByteArrayToArrayInt(bytesLeidos);
            strDescifrado = this.descifrar(intLeidos);
            
            //Obtener la extension del archivo original
            String[] arrayExtensionAndDatosArchivo = strDescifrado.split(Character.toString((char)1));
            String extension = arrayExtensionAndDatosArchivo[0];
            strDescifrado = arrayExtensionAndDatosArchivo[1];

            DataOutputStream archivoCifrado = new DataOutputStream(new FileOutputStream(rutaNuevoArchivo+"."+extension));
            
            while(finDeArchivo != -1) {
                // Se leen bytes del archivo, se descifran y se escriben en el archivo nuevos
                
                archivoCifrado.writeBytes(strDescifrado);
                
                //Limpio los arrays de lectura
                Arrays.fill(intLeidos, 0);
                bytesLeidos = new byte[BLOCKSIZE];
                finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);
                intLeidos = this.convertirByteArrayToArrayInt(bytesLeidos);
                strDescifrado = this.descifrar(intLeidos);
            }
            input.close();
            archivoCifrado.close();
        
        } catch(FileNotFoundException fex) {
            System.out.println(fex.getMessage());
            return 1;
        
        } catch(IOException iex) {
            System.out.println(iex.getMessage());
            return 2;
        
        }
        return 0;
    }
    
    public int descifrarArchivoCopia(String rutaArchivo, String rutaNuevoArchivo) {
        try {
            byte[] bytesLeidos = new byte[BLOCKSIZE];
            int[] intLeidos = new int[BLOCKSIZE];
            String strCifrado;
            
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(rutaArchivo)));
            int finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);

            DataOutputStream archivoCifrado = new DataOutputStream(new FileOutputStream(rutaNuevoArchivo));
            while(finDeArchivo != -1) {
                // Se leen bytes del archivo, se descifran y se escriben en el archivo nuevos
                intLeidos = this.convertirByteArrayToArrayInt(bytesLeidos);
                strCifrado = this.descifrar(intLeidos);
                archivoCifrado.writeBytes(strCifrado);
                
                //Limpio los arrays de lectura
                Arrays.fill(intLeidos, 0);
                bytesLeidos = new byte[BLOCKSIZE];
                finDeArchivo = input.read(bytesLeidos,0,BLOCKSIZE);

            }
            input.close();
            archivoCifrado.close();
        
        } catch(FileNotFoundException fex) {
            System.out.println(fex.getMessage());
            return 1;
        
        } catch(IOException iex) {
            System.out.println(iex.getMessage());
            return 2;
        
        }
        return 0;
    }
    
}

class ExcepcionLongitudClave extends Exception {
    public ExcepcionLongitudClave(String msg) {
        super(msg);
    }
}
