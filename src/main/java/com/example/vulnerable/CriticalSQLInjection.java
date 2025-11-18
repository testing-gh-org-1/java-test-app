package com.example.vulnerable;

import java.sql.*;

/**
 * Additional SQL Injection - Critical vulnerabilities
 * CWE-89: SQL Injection in multiple contexts
 */
public class CriticalSQLInjection {
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
    }
    
    public void deleteUserAccount(String userId) throws SQLException {
        // CRITICAL: SQL Injection in DELETE statement
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "DELETE FROM users WHERE id = '" + userId + "'";
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
    
    public void updateUserRole(String userId, String role) throws SQLException {
        // CRITICAL: SQL Injection in UPDATE statement
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "UPDATE users SET role = '" + role + "' WHERE id = '" + userId + "'";
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
    
    public void createUser(String username, String email, String password) throws SQLException {
        // CRITICAL: SQL Injection in INSERT statement
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "INSERT INTO users (username, email, password) VALUES ('" + 
                      username + "', '" + email + "', '" + password + "')";
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
    
    public void grantAdminAccess(String username) throws SQLException {
        // CRITICAL: Privilege escalation via SQL Injection
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "UPDATE users SET is_admin = 1 WHERE username = '" + username + "'";
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
    
    public void executeDynamicQuery(String tableName, String condition) throws SQLException {
        // CRITICAL: SQL Injection with dynamic table and conditions
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM " + tableName + " WHERE " + condition;
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
    
    public void dropTable(String tableName) throws SQLException {
        // CRITICAL: SQL Injection in DDL statement
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "DROP TABLE " + tableName;
        stmt.execute(query);
        stmt.close();
        conn.close();
    }
}
