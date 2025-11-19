package com.example.vulnerable;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

/**
 * Weak Cryptography - Set 8
 * CWE-327: Use of Broken Cryptographic Algorithm
 */
public class WeakCryptoSet8 {
    
    public String vuln71(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return new String(md.digest(data.getBytes()));
    }
    
    public byte[] vuln72(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return md.digest(input.getBytes());
    }
    
    public String vuln73(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        return java.util.Base64.getEncoder().encodeToString(hash);
    }
    
    public byte[] vuln74(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "DES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(data.getBytes());
    }
    
    public byte[] vuln75(String text, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(text.getBytes());
    }
    
    public String vuln76(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(data.getBytes());
        return new String(hash);
    }
    
    public byte[] vuln77(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("RC4");
        SecretKeySpec key = new SecretKeySpec("key".getBytes(), "RC4");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plaintext.getBytes());
    }
    
    public String vuln78(String pwd) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        return java.util.Base64.getEncoder().encodeToString(md.digest(pwd.getBytes()));
    }
    
    public byte[] vuln79(String data) throws Exception {
        Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
        SecretKeySpec k = new SecretKeySpec("12345678".getBytes(), "DES");
        c.init(Cipher.ENCRYPT_MODE, k);
        return c.doFinal(data.getBytes());
    }
    
    public byte[] vuln80(String text, String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] key = md.digest(password.getBytes());
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(text.getBytes());
    }
}
