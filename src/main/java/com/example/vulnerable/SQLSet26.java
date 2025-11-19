package com.example.vulnerable;

import java.sql.*;

/**
 * SQL Injection - Set 26
 */
public class SQLSet26 {
    
    private Connection conn;
    
    public SQLSet26() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:db");
    }
    
    public void vuln251(String val) throws SQLException {
        conn.createStatement().executeQuery("SELECT * FROM t1 WHERE c1='" + val + "'");
    }
    
    public void vuln252(String val) throws SQLException {
        conn.createStatement().executeUpdate("DELETE FROM t2 WHERE id=" + val);
    }
    
    public void vuln253(String val) throws SQLException {
        conn.createStatement().execute("INSERT INTO t3 VALUES('" + val + "')");
    }
    
    public void vuln254(String val) throws SQLException {
        conn.createStatement().executeQuery("SELECT * FROM t4 WHERE name LIKE '%" + val + "%'");
    }
    
    public void vuln255(String val) throws SQLException {
        conn.createStatement().executeUpdate("UPDATE t5 SET data='" + val + "'");
    }
    
    public void vuln256(String val) throws SQLException {
        Statement s = conn.createStatement();
        s.executeQuery("SELECT * FROM t6 WHERE field=" + val);
    }
    
    public void vuln257(String val) throws SQLException {
        Statement s = conn.createStatement();
        s.execute("DROP TABLE " + val);
    }
    
    public void vuln258(String val) throws SQLException {
        Statement s = conn.createStatement();
        s.executeQuery("SELECT COUNT(*) FROM t7 WHERE x='" + val + "'");
    }
    
    public void vuln259(String val) throws SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("ALTER TABLE t8 ADD COLUMN " + val);
    }
    
    public void vuln260(String val) throws SQLException {
        Statement s = conn.createStatement();
        s.executeQuery("SELECT * FROM t9 GROUP BY " + val);
    }
}
