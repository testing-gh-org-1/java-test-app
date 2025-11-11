package com.example.vulnerable;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hardcoded Credentials vulnerability
 * CWE-798: Use of Hard-coded Credentials
 */
public class HardcodedCredentials {
    
    // VULNERABILITY: Hardcoded password
    private static final String DB_PASSWORD = "admin123";
    private static final String DB_USERNAME = "sa";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    
    // VULNERABILITY: Hardcoded API key
    private static final String API_KEY = "sk_live_51HxYz2ABC123xyz";
    
    // VULNERABILITY: Hardcoded secret token
    private String secretToken = "ghp_16C7e42F292c6912E7710c838347Ae178B4a";
    
    public Connection getDatabaseConnection() throws Exception {
        // VULNERABILITY: Using hardcoded credentials
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    
    public String getApiKey() {
        // VULNERABILITY: Returning hardcoded API key
        return API_KEY;
    }
    
    public boolean authenticate(String username, String password) {
        // VULNERABILITY: Hardcoded admin password
        if ("admin".equals(username) && "P@ssw0rd123".equals(password)) {
            return true;
        }
        return false;
    }
}
