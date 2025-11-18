package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * Improper Authorization vulnerabilities
 * CWE-862: Missing Authorization
 * CWE-863: Incorrect Authorization
 */
public class ImproperAuthorization {
    
    public void deleteAccount(String userId, HttpServletRequest request) {
        // VULNERABILITY: No authorization check
        System.out.println("Deleting account: " + userId);
    }
    
    public void viewUserProfile(String targetUserId, HttpSession session) {
        // VULNERABILITY: No check if user can view this profile
        System.out.println("Viewing profile: " + targetUserId);
    }
    
    public void updateOrder(String orderId, String newStatus) {
        // VULNERABILITY: No ownership verification
        System.out.println("Updating order " + orderId + " to " + newStatus);
    }
    
    public void accessAdminFunction(HttpServletRequest request) {
        // VULNERABILITY: Role not checked
        String function = request.getParameter("function");
        executeAdminFunction(function);
    }
    
    private void executeAdminFunction(String function) {
        System.out.println("Executing: " + function);
    }
    
    public void modifyUserData(String userId, String data, HttpSession session) {
        // VULNERABILITY: No check if current user can modify target user
        System.out.println("Modifying user " + userId + " data to: " + data);
    }
    
    public void downloadFile(String fileId, HttpServletRequest request) {
        // VULNERABILITY: No file access authorization
        System.out.println("Downloading file: " + fileId);
    }
    
    public void grantPermission(String userId, String permission) {
        // VULNERABILITY: No check if caller has permission to grant
        System.out.println("Granting " + permission + " to " + userId);
    }
}
