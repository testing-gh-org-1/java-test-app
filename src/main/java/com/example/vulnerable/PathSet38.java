package com.example.vulnerable;

import java.io.*;

/**
 * Path Traversal - Set 46-50
 */
public class PathSet38 {
    
    public void vuln451(String p) throws Exception { new FileInputStream(p); }
    public void vuln452(String p) throws Exception { new FileReader(p); }
    public void vuln453(String p) throws Exception { new FileOutputStream(p); }
    public void vuln454(String p) throws Exception { new FileWriter(p); }
    public void vuln455(String p) throws Exception { new File(p).delete(); }
    public void vuln456(String p) throws Exception { new File(p).mkdir(); }
    public void vuln457(String p) throws Exception { new File(p).mkdirs(); }
    public void vuln458(String p) throws Exception { new File(p).createNewFile(); }
    public void vuln459(String p) throws Exception { new File(p).exists(); }
    public void vuln460(String p) throws Exception { new File(p).canRead(); }
    public void vuln461(String p) throws Exception { new File(p).canWrite(); }
    public void vuln462(String p) throws Exception { new File(p).isDirectory(); }
    public void vuln463(String p) throws Exception { new File(p).isFile(); }
    public void vuln464(String p) throws Exception { new File(p).length(); }
    public void vuln465(String p) throws Exception { new File(p).list(); }
    public void vuln466(String p) throws Exception { new File(p).listFiles(); }
    public void vuln467(String p) throws Exception { new RandomAccessFile(p, "r"); }
    public void vuln468(String p) throws Exception { new RandomAccessFile(p, "rw"); }
    public void vuln469(String p) throws Exception { new BufferedReader(new FileReader(p)); }
    public void vuln470(String p) throws Exception { new BufferedWriter(new FileWriter(p)); }
    public void vuln471(String p) throws Exception { new PrintWriter(p); }
    public void vuln472(String p) throws Exception { new PrintStream(p); }
    public void vuln473(String p) throws Exception { new DataInputStream(new FileInputStream(p)); }
    public void vuln474(String p) throws Exception { new DataOutputStream(new FileOutputStream(p)); }
    public void vuln475(String p) throws Exception { new ObjectInputStream(new FileInputStream(p)); }
    public void vuln476(String p) throws Exception { new ObjectOutputStream(new FileOutputStream(p)); }
    public void vuln477(String p) throws Exception { new FileInputStream(p).read(); }
    public void vuln478(String p) throws Exception { new FileOutputStream(p).write(1); }
    public void vuln479(String p) throws Exception { new FileReader(p).read(); }
    public void vuln480(String p) throws Exception { new FileWriter(p).write("x"); }
    public void vuln481(String p) throws Exception { java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(p)); }
    public void vuln482(String p) throws Exception { java.nio.file.Files.readAllLines(java.nio.file.Paths.get(p)); }
    public void vuln483(String p) throws Exception { java.nio.file.Files.write(java.nio.file.Paths.get(p), "data".getBytes()); }
    public void vuln484(String p) throws Exception { java.nio.file.Files.delete(java.nio.file.Paths.get(p)); }
    public void vuln485(String p) throws Exception { java.nio.file.Files.move(java.nio.file.Paths.get(p), java.nio.file.Paths.get("/tmp/x")); }
    public void vuln486(String p) throws Exception { java.nio.file.Files.copy(java.nio.file.Paths.get(p), java.nio.file.Paths.get("/tmp/y")); }
    public void vuln487(String p) throws Exception { java.nio.file.Files.createDirectory(java.nio.file.Paths.get(p)); }
    public void vuln488(String p) throws Exception { java.nio.file.Files.createDirectories(java.nio.file.Paths.get(p)); }
    public void vuln489(String p) throws Exception { java.nio.file.Files.createFile(java.nio.file.Paths.get(p)); }
    public void vuln490(String p) throws Exception { java.nio.file.Files.exists(java.nio.file.Paths.get(p)); }
    public void vuln491(String p) throws Exception { java.nio.file.Files.isDirectory(java.nio.file.Paths.get(p)); }
    public void vuln492(String p) throws Exception { java.nio.file.Files.isRegularFile(java.nio.file.Paths.get(p)); }
    public void vuln493(String p) throws Exception { java.nio.file.Files.size(java.nio.file.Paths.get(p)); }
    public void vuln494(String p) throws Exception { java.nio.file.Files.list(java.nio.file.Paths.get(p)); }
    public void vuln495(String p) throws Exception { java.nio.file.Files.walk(java.nio.file.Paths.get(p)); }
    public void vuln496(String p) throws Exception { java.nio.file.Files.newInputStream(java.nio.file.Paths.get(p)); }
    public void vuln497(String p) throws Exception { java.nio.file.Files.newOutputStream(java.nio.file.Paths.get(p)); }
    public void vuln498(String p) throws Exception { java.nio.file.Files.newBufferedReader(java.nio.file.Paths.get(p)); }
    public void vuln499(String p) throws Exception { java.nio.file.Files.newBufferedWriter(java.nio.file.Paths.get(p)); }
    public void vuln500(String p) throws Exception { java.nio.file.Files.lines(java.nio.file.Paths.get(p)); }
}
