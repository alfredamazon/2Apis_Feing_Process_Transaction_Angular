package com.plataformasespeciales.api_transacciones.config;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    private static final String SECRET_KEY =
            "12345678901234567890123456789012";


    public static String decrypt(String encryptedText) {

        try {

            SecretKeySpec key =
                    new SecretKeySpec(
                            SECRET_KEY.getBytes(),
                            "AES"
                    );


            Cipher cipher =
                    Cipher.getInstance("AES");


            cipher.init(
                    Cipher.DECRYPT_MODE,
                    key
            );


            byte[] decoded =
                    Base64.getDecoder()
                            .decode(encryptedText);


            return new String(
                    cipher.doFinal(decoded)
            );


        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al descifrar AES",
                    e
            );
        }
    }
}