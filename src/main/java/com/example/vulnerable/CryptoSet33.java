package com.example.vulnerable;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

/**
 * Weak Crypto - Set 33
 */
public class CryptoSet33 {
    
    public byte[] vuln321(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(data.getBytes());
    }
    
    public byte[] vuln322(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return md.digest(data.getBytes());
    }
    
    public byte[] vuln323(String data, String key) throws Exception {
        Cipher c = Cipher.getInstance("DES");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "DES"));
        return c.doFinal(data.getBytes());
    }
    
    public byte[] vuln324(String data, byte[] key) throws Exception {
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
        return c.doFinal(data.getBytes());
    }
    
    public byte[] vuln325(String data) throws Exception {
        return MessageDigest.getInstance("MD5").digest(data.getBytes());
    }
    
    public byte[] vuln326(String data) throws Exception {
        return MessageDigest.getInstance("SHA1").digest(data.getBytes());
    }
    
    public byte[] vuln327(String plaintext, String password) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeySpec key = new SecretKeySpec(password.getBytes(), "DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plaintext.getBytes());
    }
    
    public byte[] vuln328(String text) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        return digest.digest(text.getBytes());
    }
    
    public byte[] vuln329(String input, byte[] keyBytes) throws Exception {
        Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "DES"));
        return c.doFinal(input.getBytes());
    }
    
    public String vuln330(String pwd) throws Exception {
        byte[] hash = MessageDigest.getInstance("SHA-1").digest(pwd.getBytes());
        return java.util.Base64.getEncoder().encodeToString(hash);
    }
}
