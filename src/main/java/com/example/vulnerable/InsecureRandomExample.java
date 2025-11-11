package com.example.vulnerable;

import java.util.Random;

/**
 * Insecure Random Number Generation vulnerability
 * CWE-330: Use of Insufficiently Random Values
 */
public class InsecureRandomExample {
    
    private Random random = new Random();
    
    public String generateSessionToken() {
        // VULNERABILITY: Using non-cryptographic Random for security tokens
        long token = random.nextLong();
        return Long.toHexString(token);
    }
    
    public String generatePasswordResetToken(String email) {
        // VULNERABILITY: Predictable random values
        int token = random.nextInt(999999);
        return String.format("%06d", token);
    }
    
    public byte[] generateEncryptionKey(int size) {
        // VULNERABILITY: Using Random instead of SecureRandom for crypto keys
        byte[] key = new byte[size];
        random.nextBytes(key);
        return key;
    }
    
    public String generateOTP() {
        // VULNERABILITY: Math.random() is predictable
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }
}
