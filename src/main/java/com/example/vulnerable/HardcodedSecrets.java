package com.example.vulnerable;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * Hardcoded Secrets and Keys - CRITICAL
 * CWE-321: Use of Hard-coded Cryptographic Key
 */
public class HardcodedSecrets {
    
    // CRITICAL: Hardcoded encryption key
    private static final byte[] SECRET_KEY = {
        0x01, 0x23, 0x45, 0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef,
        0x01, 0x23, 0x45, 0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef
    };
    
    // CRITICAL: Hardcoded database credentials
    private static final String DB_USER = "root";
    private static final String DB_PASS = "rootpassword123";
    private static final String DB_HOST = "production-db.company.com";
    
    // CRITICAL: Hardcoded AWS credentials
    private static final String AWS_ACCESS_KEY = "AKIAIOSFODNN7EXAMPLE";
    private static final String AWS_SECRET_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    
    // CRITICAL: Hardcoded API tokens
    private static final String STRIPE_API_KEY = "sk_live_51HxYz2ABC123xyzDEF456";
    private static final String GITHUB_TOKEN = "ghp_16C7e42F292c6912E7710c838347Ae178B4a";
    private static final String JWT_SECRET = "super-secret-jwt-key-do-not-share";
    
    // CRITICAL: Hardcoded OAuth secrets
    private static final String OAUTH_CLIENT_SECRET = "c1i3e4n5t6s7e8c9r0e1t2";
    
    public byte[] encryptData(String data) throws Exception {
        // CRITICAL: Using hardcoded key
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(data.getBytes());
    }
    
    public String getDatabaseConnection() {
        // CRITICAL: Exposing hardcoded credentials
        return "jdbc:mysql://" + DB_HOST + "/mydb?user=" + DB_USER + "&password=" + DB_PASS;
    }
    
    public String getAWSCredentials() {
        // CRITICAL: Returning AWS credentials
        return AWS_ACCESS_KEY + ":" + AWS_SECRET_KEY;
    }
    
    public String getPrivateKey() {
        // CRITICAL: Hardcoded private key
        return "-----BEGIN RSA PRIVATE KEY-----\n" +
               "MIIEpAIBAAKCAQEA1234567890ABCDEF...\n" +
               "-----END RSA PRIVATE KEY-----";
    }
}
