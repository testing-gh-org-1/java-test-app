package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * Information Disclosure - Set 19
 * CWE-209: Information Exposure Through Error Message
 */
public class InfoDisclosureSet19 {
    
    public void vuln181(Exception e, HttpServletResponse resp) throws Exception {
        resp.getWriter().write(e.getMessage());
    }
    
    public void vuln182(Exception e, HttpServletResponse resp) throws Exception {
        e.printStackTrace(resp.getWriter());
    }
    
    public void vuln183(String password) {
        System.out.println("Password: " + password);
    }
    
    public void vuln184(String token) {
        System.out.println("Token: " + token);
    }
    
    public void vuln185(String apiKey) {
        System.out.println("API Key: " + apiKey);
    }
    
    public void vuln186(Exception e) {
        System.out.println("Error: " + e.getStackTrace()[0]);
    }
    
    public void vuln187(String cardNumber) {
        System.out.println("Card: " + cardNumber);
    }
    
    public void vuln188(String ssn) {
        System.out.println("SSN: " + ssn);
    }
    
    public void vuln189(Exception e, HttpServletResponse resp) throws Exception {
        resp.getWriter().write("Database error: " + e.toString());
    }
    
    public void vuln190(String secret) {
        System.err.println("Secret key: " + secret);
    }
}
