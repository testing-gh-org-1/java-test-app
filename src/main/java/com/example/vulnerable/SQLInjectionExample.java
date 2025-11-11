package com.example.vulnerable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * SQL Injection vulnerability example
 * CWE-89: Improper Neutralization of Special Elements used in an SQL Command
 */
public class SQLInjectionExample {
    
    private static final String DB_URL = "jdbc:h2:mem:testdb";
    
    public void vulnerableLogin(String username, String password) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement();
        
        // VULNERABILITY: SQL Injection - user input directly concatenated into query
        String query = "SELECT * FROM users WHERE username='" + username + 
                      "' AND password='" + password + "'";
        
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
        
        rs.close();
        stmt.close();
        conn.close();
    }
    
    public void vulnerableSearch(String searchTerm) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement();
        
        // VULNERABILITY: SQL Injection
        String query = "SELECT * FROM products WHERE name LIKE '%" + searchTerm + "%'";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        
        rs.close();
        stmt.close();
        conn.close();
    }
}
