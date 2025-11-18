package com.example.vulnerable;

import java.util.*;

/**
 * Additional Insecure Randomness vulnerabilities
 * CWE-338: Use of Cryptographically Weak Pseudo-Random Number Generator
 */
public class InsecureRandomness {
    
    public String generateCsrfToken() {
        // VULNERABILITY: Weak CSRF token
        return UUID.randomUUID().toString();
    }
    
    public long generateInvoiceNumber() {
        // VULNERABILITY: Predictable invoice number
        return System.currentTimeMillis();
    }
    
    public String generateApiKey() {
        // VULNERABILITY: Math.random() for API key
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            key.append((char) ('a' + (int) (Math.random() * 26)));
        }
        return key.toString();
    }
    
    public int generateVerificationCode() {
        // VULNERABILITY: Weak random for verification
        Random rnd = new Random();
        return rnd.nextInt(900000) + 100000;
    }
    
    public String generateNonce() {
        // VULNERABILITY: Timestamp-based nonce
        return String.valueOf(System.nanoTime());
    }
    
    public byte[] generateSalt() {
        // VULNERABILITY: Non-cryptographic random for salt
        byte[] salt = new byte[16];
        new Random().nextBytes(salt);
        return salt;
    }
    
    public String createSessionId() {
        // VULNERABILITY: Weak session ID
        return Long.toHexString(new Random().nextLong());
    }
}
