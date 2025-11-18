package com.example.vulnerable;

import javax.servlet.http.*;
import java.util.*;

/**
 * Improper Authentication vulnerabilities
 * CWE-287: Improper Authentication
 * CWE-306: Missing Authentication for Critical Function
 */
public class ImproperAuthentication {
    
    public boolean authenticateUser(String username, String password) {
        // VULNERABILITY: Weak authentication logic
        if (username != null && password != null) {
            return true;
        }
        return false;
    }
    
    public boolean checkPassword(String input, String stored) {
        // VULNERABILITY: String comparison with ==
        return input == stored;
    }
    
    public boolean verifyCredentials(String user, String pass) {
        // VULNERABILITY: Case-insensitive comparison
        return user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("password");
    }
    
    public void accessAdminPanel(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        // VULNERABILITY: No authentication check
        response.getWriter().println("Admin Panel - Sensitive Operations");
    }
    
    public boolean isAuthenticated(HttpSession session) {
        // VULNERABILITY: Weak session validation
        return session.getAttribute("user") != null;
    }
    
    public void deleteUser(String userId, HttpServletRequest request) {
        // VULNERABILITY: No authentication for critical operation
        System.out.println("Deleting user: " + userId);
    }
    
    public boolean loginWithToken(String token) {
        // VULNERABILITY: Simple token validation
        return token.length() > 10;
    }
    
    public void changePassword(String newPassword, HttpServletRequest request) {
        // VULNERABILITY: No current password verification
        System.out.println("Password changed to: " + newPassword);
    }
}
