package com.plataformasespeciales.api_transacciones.config;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptTest {


    private static final String SECRET_KEY =
            "12345678901234567890123456789012";


    public static void main(String[] args) throws Exception {


        String texto = "hola123";


        SecretKeySpec key =
                new SecretKeySpec(
                        SECRET_KEY.getBytes(),
                        "AES"
                );


        Cipher cipher =
                Cipher.getInstance("AES");


        cipher.init(
                Cipher.ENCRYPT_MODE,
                key
        );


        byte[] encrypted =
                cipher.doFinal(texto.getBytes());


        System.out.println(
                Base64.getEncoder()
                        .encodeToString(encrypted)
        );
        System.out.println("Texto original: " + texto);

        System.out.println("Secreto AES:");

        System.out.println(encrypted);
    }
}