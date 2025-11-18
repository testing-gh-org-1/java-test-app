package com.example.vulnerable;

import javax.servlet.http.*;
import java.io.*;

/**
 * Authentication Bypass - CRITICAL
 * CWE-287: Improper Authentication
 */
public class AuthenticationBypass {
    
    public boolean login(String username, String password, HttpSession session) {
        // CRITICAL: Always returns true - complete bypass
        session.setAttribute("authenticated", true);
        session.setAttribute("user", username);
        return true;
    }
    
    public boolean checkAdmin(HttpServletRequest request) {
        // CRITICAL: Can be bypassed with URL parameter
        String isAdmin = request.getParameter("admin");
        return "true".equals(isAdmin);
    }
    
    public void setAdminAccess(HttpSession session, String role) {
        // CRITICAL: No validation of role assignment
        session.setAttribute("role", role);
        session.setAttribute("isAdmin", "admin".equals(role));
    }
    
    public boolean authenticateWithCookie(HttpServletRequest request) {
        // CRITICAL: Trusts client-side cookie without validation
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("authenticated".equals(cookie.getName())) {
                return "true".equals(cookie.getValue());
            }
        }
        return false;
    }
    
    public boolean verifyToken(String token) {
        // CRITICAL: Weak token validation
        return token != null && token.length() > 5;
    }
    
    public void resetPassword(String username, String newPassword) {
        // CRITICAL: Password reset without verification
        System.out.println("Password for " + username + " reset to: " + newPassword);
    }
    
    public boolean loginWithHash(String username, String passwordHash) {
        // CRITICAL: Hash comparison with == operator
        String storedHash = getStoredHash(username);
        return passwordHash == storedHash;
    }
    
    private String getStoredHash(String username) {
        return "hash123"; // Dummy implementation
    }
}
