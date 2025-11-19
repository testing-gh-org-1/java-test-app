package com.example.vulnerable;

import java.io.*;

/**
 * Path Traversal vulnerabilities - Set 3
 * CWE-22: Path Traversal
 */
public class PathTraversalSet3 {
    
    public void vuln21(String path) throws IOException {
        new FileInputStream(path);
    }
    
    public void vuln22(String file) throws IOException {
        new FileReader("/app/data/" + file);
    }
    
    public void vuln23(String name) throws IOException {
        new File("/uploads/" + name).delete();
    }
    
    public void vuln24(String dir) throws IOException {
        new File(dir).mkdirs();
    }
    
    public void vuln25(String filename) throws IOException {
        new FileOutputStream("/tmp/" + filename);
    }
    
    public void vuln26(String resource) throws IOException {
        new RandomAccessFile("/var/www/" + resource, "r");
    }
    
    public void vuln27(String doc) throws IOException {
        new BufferedReader(new FileReader("/documents/" + doc));
    }
    
    public void vuln28(String log) throws IOException {
        new FileWriter("/logs/" + log);
    }
    
    public void vuln29(String config) throws IOException {
        new File("/etc/app/" + config).createNewFile();
    }
    
    public void vuln30(String backup) throws IOException {
        new FileInputStream("/backup/" + backup);
    }
}
