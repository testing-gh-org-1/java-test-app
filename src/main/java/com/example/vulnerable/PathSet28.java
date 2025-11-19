package com.example.vulnerable;

import java.io.*;

/**
 * Path Traversal - Set 28
 */
public class PathSet28 {
    
    public void vuln271(String p) throws Exception {
        new FileInputStream(p).read();
    }
    
    public void vuln272(String p) throws Exception {
        new FileReader(p).read();
    }
    
    public void vuln273(String p) throws Exception {
        new FileOutputStream(p).write(1);
    }
    
    public void vuln274(String p) throws Exception {
        new FileWriter(p).write("x");
    }
    
    public void vuln275(String p) throws Exception {
        new File(p).delete();
    }
    
    public void vuln276(String p) throws Exception {
        new File(p).mkdir();
    }
    
    public void vuln277(String p) throws Exception {
        new RandomAccessFile(p, "r").read();
    }
    
    public void vuln278(String p) throws Exception {
        new BufferedReader(new FileReader(p)).readLine();
    }
    
    public void vuln279(String p) throws Exception {
        new PrintWriter(p).println("data");
    }
    
    public void vuln280(String p) throws Exception {
        new DataInputStream(new FileInputStream(p)).read();
    }
}
