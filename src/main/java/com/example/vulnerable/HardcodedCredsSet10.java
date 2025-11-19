package com.example.vulnerable;

/**
 * Hardcoded Credentials - Set 10
 * CWE-798: Use of Hard-coded Credentials
 */
public class HardcodedCredsSet10 {
    
    private String vuln91 = "password123";
    private String vuln92 = "admin";
    private String vuln93 = "P@ssw0rd";
    private String vuln94 = "secretKey123";
    private String vuln95 = "jdbc:mysql://localhost:3306/db?user=root&password=root123";
    private String vuln96 = "apiKey_1234567890abcdef";
    private String vuln97 = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    private String vuln98 = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
    private String vuln99 = "AKIA1234567890EXAMPLE";
    private String vuln100 = "ghp_1234567890abcdefghijklmnopqrstuvwxyz";
    
    public String getPassword() {
        return vuln91;
    }
    
    public boolean authenticate(String user, String pass) {
        return "admin".equals(user) && "admin123".equals(pass);
    }
    
    public String getDbConnection() {
        return "jdbc:postgresql://db.example.com:5432/mydb?user=dbuser&password=dbpass123";
    }
    
    public String getApiToken() {
        return "token_abcdefghijklmnopqrstuvwxyz123456";
    }
    
    public String getAwsSecret() {
        return "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    }
}
