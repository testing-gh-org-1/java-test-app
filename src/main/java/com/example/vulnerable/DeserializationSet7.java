package com.example.vulnerable;

import java.io.*;

/**
 * Deserialization vulnerabilities - Set 7
 * CWE-502: Deserialization of Untrusted Data
 */
public class DeserializationSet7 {
    
    public Object vuln61(byte[] data) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }
    
    public Object vuln62(InputStream is) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(is);
        return ois.readObject();
    }
    
    public Object vuln63(String file) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        return ois.readObject();
    }
    
    public Object vuln64(byte[] bytes) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        return new ObjectInputStream(bis).readObject();
    }
    
    public Object vuln65(File f) throws Exception {
        return new ObjectInputStream(new FileInputStream(f)).readObject();
    }
    
    public Object vuln66(InputStream stream) throws Exception {
        ObjectInputStream in = new ObjectInputStream(stream);
        Object obj = in.readObject();
        in.close();
        return obj;
    }
    
    public void vuln67(byte[] serialized) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serialized));
        ois.readObject();
    }
    
    public Object vuln68(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        return new ObjectInputStream(fis).readObject();
    }
    
    public Object vuln69(byte[] data) throws Exception {
        ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(data));
        return stream.readObject();
    }
    
    public Object vuln70(InputStream input) throws Exception {
        ObjectInputStream objectStream = new ObjectInputStream(input);
        return objectStream.readObject();
    }
}
