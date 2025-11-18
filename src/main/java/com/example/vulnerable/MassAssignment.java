package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * Mass Assignment Vulnerability - CRITICAL
 * CWE-915: Improperly Controlled Modification of Dynamically-Determined Object Attributes
 */
public class MassAssignment {
    
    public User updateUser(HttpServletRequest request, User user) {
        // CRITICAL: Binding all request parameters to user object
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setRole(request.getParameter("role")); // Attacker can escalate privileges
        user.setIsAdmin(Boolean.parseBoolean(request.getParameter("isAdmin")));
        user.setAccountBalance(Double.parseDouble(request.getParameter("accountBalance")));
        return user;
    }
    
    public Account createAccount(HttpServletRequest request) {
        // CRITICAL: Creating object from unvalidated input
        Account account = new Account();
        account.setAccountId(request.getParameter("accountId"));
        account.setBalance(Double.parseDouble(request.getParameter("balance")));
        account.setAccountType(request.getParameter("accountType"));
        account.setPrivilegeLevel(Integer.parseInt(request.getParameter("privilegeLevel")));
        return account;
    }
    
    public void updatePermissions(HttpServletRequest request, String userId) {
        // CRITICAL: Direct permission modification
        String[] permissions = request.getParameterValues("permissions");
        System.out.println("Granting permissions to user " + userId + ": " + String.join(",", permissions));
    }
    
    public Order modifyOrder(HttpServletRequest request, Order order) {
        // CRITICAL: Order modification without authorization
        order.setStatus(request.getParameter("status"));
        order.setAmount(Double.parseDouble(request.getParameter("amount")));
        order.setDiscount(Double.parseDouble(request.getParameter("discount")));
        return order;
    }
    
    static class User {
        private String username;
        private String email;
        private String role;
        private boolean isAdmin;
        private double accountBalance;
        
        public void setUsername(String username) { this.username = username; }
        public void setEmail(String email) { this.email = email; }
        public void setRole(String role) { this.role = role; }
        public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
        public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }
    }
    
    static class Account {
        private String accountId;
        private double balance;
        private String accountType;
        private int privilegeLevel;
        
        public void setAccountId(String accountId) { this.accountId = accountId; }
        public void setBalance(double balance) { this.balance = balance; }
        public void setAccountType(String accountType) { this.accountType = accountType; }
        public void setPrivilegeLevel(int privilegeLevel) { this.privilegeLevel = privilegeLevel; }
    }
    
    static class Order {
        private String status;
        private double amount;
        private double discount;
        
        public void setStatus(String status) { this.status = status; }
        public void setAmount(double amount) { this.amount = amount; }
        public void setDiscount(double discount) { this.discount = discount; }
    }
}
