package com.example.vulnerable;

import java.io.*;

/**
 * Resource Leak vulnerabilities - Set 9
 * CWE-404: Improper Resource Shutdown
 */
public class ResourceLeakSet9 {
    
    public void vuln81(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        fis.read();
    }
    
    public void vuln82(String path) throws Exception {
        FileReader fr = new FileReader(path);
        fr.read();
    }
    
    public void vuln83(String filename) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(1);
    }
    
    public void vuln84(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
    }
    
    public void vuln85(String path) throws Exception {
        FileWriter fw = new FileWriter(path);
        fw.write("data");
    }
    
    public void vuln86(String f) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(f, "r");
        raf.read();
    }
    
    public void vuln87(String file) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        dis.read();
    }
    
    public void vuln88(String path) throws Exception {
        PrintWriter pw = new PrintWriter(path);
        pw.println("text");
    }
    
    public void vuln89(String filename) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write("content");
    }
    
    public void vuln90(String file) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(1);
    }
}
