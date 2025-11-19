package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * CSRF - Set 18
 * CWE-352: Cross-Site Request Forgery
 */
public class CSRFSet18 {
    
    public void vuln171(HttpServletRequest req) {
        String amount = req.getParameter("amount");
        System.out.println("Transfer: " + amount);
    }
    
    public void vuln172(HttpServletRequest req) {
        String password = req.getParameter("newPassword");
        System.out.println("Password changed: " + password);
    }
    
    public void vuln173(HttpServletRequest req) {
        String email = req.getParameter("email");
        System.out.println("Email updated: " + email);
    }
    
    public void vuln174(HttpServletRequest req) {
        String userId = req.getParameter("userId");
        System.out.println("User deleted: " + userId);
    }
    
    public void vuln175(HttpServletRequest req) {
        String role = req.getParameter("role");
        System.out.println("Role changed: " + role);
    }
    
    public void vuln176(HttpServletRequest req) {
        String to = req.getParameter("to");
        System.out.println("Money sent to: " + to);
    }
    
    public void vuln177(HttpServletRequest req) {
        String accountId = req.getParameter("account");
        System.out.println("Account closed: " + accountId);
    }
    
    public void vuln178(HttpServletRequest req) {
        String permission = req.getParameter("permission");
        System.out.println("Permission granted: " + permission);
    }
    
    public void vuln179(HttpServletRequest req) {
        String settingValue = req.getParameter("setting");
        System.out.println("Setting updated: " + settingValue);
    }
    
    public void vuln180(HttpServletRequest req) {
        String action = req.getParameter("action");
        System.out.println("Action performed: " + action);
    }
}
