package com.example.vulnerable;

import java.io.*;

/**
 * Resource Leaks - Set 34
 */
public class LeakSet34 {
    
    public void vuln331(String f) throws Exception {
        new FileInputStream(f);
    }
    
    public void vuln332(String f) throws Exception {
        new FileReader(f);
    }
    
    public void vuln333(String f) throws Exception {
        new FileOutputStream(f);
    }
    
    public void vuln334(String f) throws Exception {
        new FileWriter(f);
    }
    
    public void vuln335(String f) throws Exception {
        new BufferedReader(new FileReader(f));
    }
    
    public void vuln336(String f) throws Exception {
        new BufferedWriter(new FileWriter(f));
    }
    
    public void vuln337(String f) throws Exception {
        new DataInputStream(new FileInputStream(f));
    }
    
    public void vuln338(String f) throws Exception {
        new DataOutputStream(new FileOutputStream(f));
    }
    
    public void vuln339(String f) throws Exception {
        new RandomAccessFile(f, "r");
    }
    
    public void vuln340(String f) throws Exception {
        new PrintWriter(f);
    }
}
