package com.example.vulnerable;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

/**
 * Additional Weak Cryptography vulnerabilities
 * CWE-326: Inadequate Encryption Strength
 */
public class WeakEncryption {
    
    public byte[] encryptWithStaticKey(String data) throws Exception {
        // VULNERABILITY: Static encryption key
        byte[] keyBytes = "1234567890123456".getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    public byte[] encryptWithoutIV(String data, byte[] keyBytes) throws Exception {
        // VULNERABILITY: CBC mode without explicit IV
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    public byte[] encryptWithWeakKey(String data) throws Exception {
        // VULNERABILITY: Weak key size
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(56); // Weak key size
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    public byte[] xorEncrypt(String data, String key) {
        // VULNERABILITY: XOR cipher
        byte[] dataBytes = data.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] result = new byte[dataBytes.length];
        for (int i = 0; i < dataBytes.length; i++) {
            result[i] = (byte) (dataBytes[i] ^ keyBytes[i % keyBytes.length]);
        }
        return result;
    }
    
    public String encryptRC4(String data, String key) throws Exception {
        // VULNERABILITY: RC4 is broken
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "RC4");
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }
}
