package com.example.vulnerable;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.io.*;

/**
 * CWE-693: Protection Mechanism Failure
 * 
 * Failures in security mechanisms including authentication, authorization,
 * encryption, and other protective measures.
 */
public class CWE693ProtectionMechanismFailure {
    
    /**
     * vuln631: Weak password hashing
     */
    public String vuln631(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        return new String(hash); // MD5 is broken
    }
    
    /**
     * vuln632: No salt in password hashing
     */
    public String vuln632(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return new String(md.digest(password.getBytes())); // No salt
    }
    
    /**
     * vuln633: Hardcoded encryption key
     */
    public byte[] vuln633(String data) throws Exception {
        byte[] keyBytes = "1234567890123456".getBytes(); // Hardcoded key
        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    /**
     * vuln634: ECB mode encryption
     */
    public byte[] vuln634(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // ECB is insecure
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    /**
     * vuln635: No IV for CBC mode
     */
    public byte[] vuln635(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key); // No IV provided
        return cipher.doFinal(data.getBytes());
    }
    
    /**
     * vuln636: Disabled certificate validation
     */
    public void vuln636() {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
            (hostname, session) -> true // Accepts all certificates
        );
    }
    
    /**
     * vuln637: Trust all SSL certificates
     */
    public void vuln637() throws Exception {
        javax.net.ssl.TrustManager[] trustAll = new javax.net.ssl.TrustManager[] {
            new javax.net.ssl.X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
            }
        };
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAll, new java.security.SecureRandom());
    }
    
    /**
     * vuln638: Weak session ID generation
     */
    public String vuln638() {
        return String.valueOf(System.currentTimeMillis()); // Predictable
    }
    
    /**
     * vuln639: Session fixation vulnerability
     */
    public void vuln639(String existingSessionId) {
        // Reuses existing session ID without regeneration
        System.setProperty("sessionId", existingSessionId);
    }
    
    /**
     * vuln640: Missing authentication check
     */
    public void vuln640(String userId, String action) {
        // No authentication verification
        performAction(action);
    }
    
    private void performAction(String action) {
        System.out.println("Performing: " + action);
    }
    
    /**
     * vuln641: Missing authorization check
     */
    public String vuln641(String userId, String documentId) {
        // No check if user has access to document
        return "Document content for " + documentId;
    }
    
    /**
     * vuln642: Insufficient entropy in key generation
     */
    public byte[] vuln642() {
        byte[] key = new byte[16];
        new java.util.Random().nextBytes(key); // Weak randomness
        return key;
    }
    
    /**
     * vuln643: Plaintext password storage
     */
    public void vuln643(String username, String password) {
        // Store password in plaintext
        System.out.println("Storing: " + username + ":" + password);
    }
    
    /**
     * vuln644: No password complexity requirements
     */
    public boolean vuln644(String password) {
        return password.length() > 0; // Any non-empty password accepted
    }
    
    /**
     * vuln645: Missing rate limiting
     */
    public boolean vuln645(String username, String password) {
        // No rate limiting on login attempts
        return checkCredentials(username, password);
    }
    
    private boolean checkCredentials(String username, String password) {
        return true; // Dummy implementation
    }
    
    /**
     * vuln646: Weak random number for security
     */
    public String vuln646() {
        return String.valueOf(Math.random()); // Not cryptographically secure
    }
    
    /**
     * vuln647: Expired token still accepted
     */
    public boolean vuln647(String token, long timestamp) {
        // No expiration check
        return token.length() > 0;
    }
    
    /**
     * vuln648: Missing CSRF protection
     */
    public void vuln648(String action, String value) {
        // No CSRF token validation
        performAction(action);
    }
    
    /**
     * vuln649: Insecure direct object reference
     */
    public String vuln649(int userId, int documentId) {
        // Directly uses user-provided IDs without validation
        return "Document " + documentId + " for user " + userId;
    }
    
    /**
     * vuln650: Missing input validation before crypto
     */
    public byte[] vuln650(String data, SecretKey key) throws Exception {
        // No validation of data before encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    /**
     * vuln651: Weak encryption algorithm
     */
    public byte[] vuln651(String data) throws Exception {
        byte[] keyBytes = "12345678".getBytes();
        SecretKey key = new SecretKeySpec(keyBytes, "DES");
        Cipher cipher = Cipher.getInstance("DES"); // DES is weak
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    
    /**
     * vuln652: No integrity check on encrypted data
     */
    public String vuln652(byte[] encryptedData, SecretKey key) throws Exception {
        // No HMAC or authentication tag
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(encryptedData));
    }
    
    /**
     * vuln653: Predictable password reset token
     */
    public String vuln653(String email) {
        return email + System.currentTimeMillis(); // Predictable
    }
    
    /**
     * vuln654: Missing secure flag on cookie
     */
    public String vuln654(String sessionId) {
        return "Set-Cookie: sessionId=" + sessionId + "; Path=/"; // No Secure flag
    }
    
    /**
     * vuln655: Missing HttpOnly flag on cookie
     */
    public String vuln655(String sessionId) {
        return "Set-Cookie: sessionId=" + sessionId + "; Secure"; // No HttpOnly
    }
    
    /**
     * vuln656: Overly permissive CORS
     */
    public String vuln656(String origin) {
        return "Access-Control-Allow-Origin: *"; // Allows all origins
    }
    
    /**
     * vuln657: No account lockout mechanism
     */
    public boolean vuln657(String username, String password, int failedAttempts) {
        // No lockout even after many failed attempts
        return checkCredentials(username, password);
    }
    
    /**
     * vuln658: Weak session timeout
     */
    public boolean vuln658(long lastActivity) {
        long timeout = 86400000; // 24 hours - too long
        return (System.currentTimeMillis() - lastActivity) < timeout;
    }
    
    /**
     * vuln659: Missing password change after reset
     */
    public void vuln659(String username, String tempPassword) {
        // Temporary password can be used indefinitely
        System.out.println("Login with temp password: " + tempPassword);
    }
    
    /**
     * vuln660: Plaintext transmission of credentials
     */
    public void vuln660(String url, String username, String password) throws Exception {
        // Using HTTP instead of HTTPS
        java.net.URL u = new java.net.URL("http://" + url);
        String auth = username + ":" + password;
        System.out.println("Sending credentials to: " + u);
    }
}
