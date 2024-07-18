package com.example.test1.until;
import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSAUntil {
        private static final String ALGORITHM = "RSA";

        public static KeyPair generateKeyPair() throws Exception {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(2048);
            return keyGen.generateKeyPair();
        }

        public static String encrypt(String data, PublicKey publicKey) throws Exception {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }

        public static String decrypt(String encryptedData, PrivateKey privateKey) throws Exception {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        }


}
