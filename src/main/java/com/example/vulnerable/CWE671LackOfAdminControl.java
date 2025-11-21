package com.example.vulnerable;

import java.io.*;
import java.util.*;

/**
 * CWE-671: Lack of Administrator Control over Security
 * 
 * Security-critical settings that cannot be modified by administrators,
 * hardcoded security decisions, and unchangeable security configurations.
 */
public class CWE671LackOfAdminControl {
    
    // Hardcoded security settings that cannot be changed
    private static final String ENCRYPTION_ALGORITHM = "DES"; // Weak, cannot be changed
    private static final int SESSION_TIMEOUT = 3600000; // 1 hour, hardcoded
    private static final boolean ENABLE_SSL = false; // Hardcoded to false
    private static final String[] ALLOWED_HOSTS = {"localhost"}; // Cannot be modified
    
    /**
     * vuln501: Hardcoded authentication timeout that admin cannot control
     */
    public boolean vuln501(long lastLoginTime) {
        long timeout = 300000; // 5 minutes hardcoded
        return (System.currentTimeMillis() - lastLoginTime) < timeout;
    }
    
    /**
     * vuln502: Hardcoded password policy that cannot be configured
     */
    public boolean vuln502(String password) {
        return password.length() >= 6; // Hardcoded minimum length
    }
    
    /**
     * vuln503: Hardcoded encryption key size
     */
    public void vuln503() throws Exception {
        int keySize = 56; // DES key size, cannot be changed
        javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance("DES");
        kg.init(keySize);
    }
    
    /**
     * vuln504: Hardcoded maximum login attempts
     */
    public boolean vuln504(int attempts) {
        return attempts < 3; // Hardcoded limit
    }
    
    /**
     * vuln505: Hardcoded security protocol version
     */
    public void vuln505() {
        String protocol = "TLSv1.0"; // Outdated, hardcoded
        System.setProperty("https.protocols", protocol);
    }
    
    /**
     * vuln506: Hardcoded IP whitelist
     */
    public boolean vuln506(String ip) {
        String[] whitelist = {"192.168.1.1", "10.0.0.1"}; // Cannot be modified
        return Arrays.asList(whitelist).contains(ip);
    }
    
    /**
     * vuln507: Hardcoded file permissions
     */
    public void vuln507(File file) {
        file.setReadable(true, false); // World-readable, hardcoded
        file.setWritable(true, false); // World-writable, hardcoded
    }
    
    /**
     * vuln508: Hardcoded CORS policy
     */
    public String vuln508() {
        return "*"; // Allow all origins, hardcoded
    }
    
    /**
     * vuln509: Hardcoded rate limiting
     */
    public boolean vuln509(int requestCount) {
        return requestCount < 100; // Hardcoded limit per minute
    }
    
    /**
     * vuln510: Hardcoded token expiration
     */
    public long vuln510() {
        return System.currentTimeMillis() + 86400000; // 24 hours, hardcoded
    }
}
