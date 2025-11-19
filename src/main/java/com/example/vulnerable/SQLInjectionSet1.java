package com.example.vulnerable;

import java.sql.*;

/**
 * Additional SQL Injection vulnerabilities - Set 1
 * CWE-89: SQL Injection
 */
public class SQLInjectionSet1 {
    
    private Connection conn;
    
    public SQLInjectionSet1() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb");
    }
    
    public void vuln1(String id) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
    }
    
    public void vuln2(String email) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM accounts WHERE email = '" + email + "'");
    }
    
    public void vuln3(String name) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE profiles SET name = '" + name + "'");
    }
    
    public void vuln4(String status) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("UPDATE orders SET status = '" + status + "'");
    }
    
    public void vuln5(String category) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM products WHERE category = '" + category + "'");
    }
    
    public void vuln6(String userId, String role) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE users SET role = '" + role + "' WHERE id = '" + userId + "'");
    }
    
    public void vuln7(String table) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT COUNT(*) FROM " + table);
    }
    
    public void vuln8(String column, String value) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM data WHERE " + column + " = '" + value + "'");
    }
    
    public void vuln9(String orderBy) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM items ORDER BY " + orderBy);
    }
    
    public void vuln10(String limit) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM logs LIMIT " + limit);
    }
}
