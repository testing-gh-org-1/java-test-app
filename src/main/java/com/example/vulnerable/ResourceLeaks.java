package com.example.vulnerable;

import java.io.*;
import java.net.*;
import java.sql.*;

/**
 * Resource Leak vulnerabilities
 * CWE-404: Improper Resource Shutdown or Release
 * CWE-772: Missing Release of Resource after Effective Lifetime
 */
public class ResourceLeaks {
    
    public String readFileWithLeak(String filename) throws IOException {
        // VULNERABILITY: FileInputStream not closed
        FileInputStream fis = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        return br.readLine();
    }
    
    public void writeFileWithLeak(String filename, String content) throws IOException {
        // VULNERABILITY: FileOutputStream not closed
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(content.getBytes());
    }
    
    public String queryDatabaseWithLeak(String query) throws SQLException {
        // VULNERABILITY: Connection, Statement, ResultSet not closed
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
    
    public String readFromURL(String url) throws IOException {
        // VULNERABILITY: InputStream not closed
        URL website = new URL(url);
        InputStream is = website.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.readLine();
    }
    
    public void connectWithLeak(String host, int port) throws IOException {
        // VULNERABILITY: Socket not closed
        Socket socket = new Socket(host, port);
        OutputStream os = socket.getOutputStream();
        os.write("Hello".getBytes());
    }
    
    public void preparedStatementLeak(String username) throws SQLException {
        // VULNERABILITY: PreparedStatement not closed
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
        ps.setString(1, username);
        ps.executeQuery();
    }
    
    public void multipleLeaks(String file1, String file2) throws IOException {
        // VULNERABILITY: Multiple resource leaks
        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);
        System.out.println(br1.readLine());
        System.out.println(br2.readLine());
    }
}
