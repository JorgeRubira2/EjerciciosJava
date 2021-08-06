package com.jorgerubira.explicaciones.D20210805;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


public class EjemplosCifrado {

    public final static String CLAVE_CIFRADO_AES="MiClave";
    public final static byte[] SALT = {
                                        (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
                                        (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99
                                       };
    

    /**
     * Algoritmo simetrico.
     */
    public static Cipher obtenerCipher(int modo) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(CLAVE_CIFRADO_AES.toCharArray()));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        try {
            pbeCipher.init(modo, key, new PBEParameterSpec(SALT, 20));
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(EjemplosCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pbeCipher;
    }
    
    public static String cifradoDES(String content) throws Exception {
        Cipher cipher=obtenerCipher(Cipher.ENCRYPT_MODE);
        byte [] byteDecode=content.getBytes(); // 8. Obtenga la matriz de bytes del contenido encriptado (debe establecerse en utf-8 aquí) de lo contrario, si hay una combinación de chino e inglés en el contenido, se descifrará en caracteres ilegibles        
        byte[] byteAES=cipher.doFinal(byteDecode); // 9. Según el método de inicialización del cifrado cifrado: cifrar los datos
        String AESEncode=Base64.getEncoder().encodeToString(byteAES); // 10. Convierte los datos cifrados en una cadena
                                                                        // El paquete no se encontrará aquí con Base64Encoder
                                                                        // Solución:
                                                                        // Elimine primero la biblioteca del sistema JRE en la ruta de compilación del proyecto y luego agregue la biblioteca Biblioteca del sistema JRE. Después de volver a compilar, todo es normal.
        return AESEncode;                          // 11. Devuelve la cadena
    }

    public static String descifradoDES(String clave) throws Exception {
        Cipher cipher=obtenerCipher(Cipher.DECRYPT_MODE);
        byte[] byteAES=Base64.getDecoder().decode(clave);
        byte[] byteTexto=cipher.doFinal(byteAES);
        return new String(byteTexto);
    }
    
    public static String cifradoSHA(String originalString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(originalString.getBytes("utf8"));
        return String.format("%040x", new BigInteger(1, digest.digest()));
    }

    //1111 -> AH
    //1234 -> 
    
    public static void main(String[] args) {
        //Ejemplo cifrado simetrico DES
        String texto="textoInicial";
        try {
            String cifrado=cifradoDES(texto);
            System.out.println("Texto cifrado: " + cifrado);
            String descifrado=descifradoDES(cifrado);
            System.out.println("Texto descifrado: " + descifrado);
        } catch (Exception ex) {
            Logger.getLogger(EjemplosCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        //Ejemplo cifrado asimetrico SHA
        try {
            System.out.println(cifradoSHA("Hola mundo"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(EjemplosCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Texto cifrado: JBzJvQu+Ij4ItWfqVW2B+A==
        //Texto descifrado: textoInicial
        
        //SHA-1: c083106c930790151165b95bd11860724e3836cb        
    }
}
