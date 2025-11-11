package com.example.vulnerable;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * Weak Cryptography vulnerabilities
 * CWE-327: Use of a Broken or Risky Cryptographic Algorithm
 * CWE-328: Use of Weak Hash
 */
public class WeakCryptoExample {
    
    public String hashPasswordMD5(String password) throws Exception {
        // VULNERABILITY: MD5 is cryptographically broken
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    
    public String hashPasswordSHA1(String password) throws Exception {
        // VULNERABILITY: SHA-1 is deprecated for security purposes
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    
    public byte[] encryptDataDES(String data, String key) throws Exception {
        // VULNERABILITY: DES has a small key size and is insecure
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data.getBytes());
    }
    
    public byte[] encryptWithECB(String data, byte[] keyBytes) throws Exception {
        // VULNERABILITY: ECB mode is insecure (doesn't use IV)
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
}
