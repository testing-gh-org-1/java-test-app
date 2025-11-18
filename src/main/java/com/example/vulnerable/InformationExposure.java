package com.example.vulnerable;

import javax.servlet.http.*;
import java.io.*;

/**
 * Information Exposure vulnerabilities
 * CWE-209: Generation of Error Message Containing Sensitive Information
 * CWE-532: Insertion of Sensitive Information into Log File
 * CWE-497: Exposure of Sensitive System Information
 */
public class InformationExposure {
    
    public void handleException(Exception e, HttpServletResponse response) throws IOException {
        // VULNERABILITY: Exposing stack trace to user
        PrintWriter out = response.getWriter();
        e.printStackTrace(out);
    }
    
    public void logSensitiveData(String username, String password) {
        // VULNERABILITY: Logging sensitive information
        System.out.println("Login attempt - Username: " + username + ", Password: " + password);
    }
    
    public void logCreditCard(String cardNumber) {
        // VULNERABILITY: Logging PII
        System.out.println("Processing card: " + cardNumber);
    }
    
    public String getDatabaseError(Exception e) {
        // VULNERABILITY: Exposing database details
        return "Database error: " + e.getMessage() + " at " + e.getStackTrace()[0];
    }
    
    public void printSystemInfo(HttpServletResponse response) throws IOException {
        // VULNERABILITY: Exposing system information
        PrintWriter out = response.getWriter();
        out.println("Java version: " + System.getProperty("java.version"));
        out.println("OS: " + System.getProperty("os.name"));
        out.println("User home: " + System.getProperty("user.home"));
        out.println("Working dir: " + System.getProperty("user.dir"));
    }
    
    public void logUserSession(HttpSession session) {
        // VULNERABILITY: Logging session details
        System.out.println("Session ID: " + session.getId());
        System.out.println("Session data: " + session.getAttribute("user"));
    }
    
    public void handleSQLError(Exception e, HttpServletResponse response) throws IOException {
        // VULNERABILITY: SQL error details to user
        response.getWriter().println("SQL Error: " + e.getMessage());
    }
    
    public void debugOutput(Object obj) {
        // VULNERABILITY: Debug information in production
        System.out.println("Debug: " + obj.toString());
        System.out.println("Class: " + obj.getClass().getName());
    }
}
