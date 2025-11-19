package com.example.vulnerable;

import java.io.*;

/**
 * Deserialization - Set 32
 */
public class DeserializeSet32 {
    
    public Object vuln311(byte[] data) throws Exception {
        return new ObjectInputStream(new ByteArrayInputStream(data)).readObject();
    }
    
    public Object vuln312(InputStream is) throws Exception {
        return new ObjectInputStream(is).readObject();
    }
    
    public Object vuln313(String file) throws Exception {
        return new ObjectInputStream(new FileInputStream(file)).readObject();
    }
    
    public Object vuln314(byte[] bytes) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        return ois.readObject();
    }
    
    public Object vuln315(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        return ois.readObject();
    }
    
    public Object vuln316(InputStream stream) throws Exception {
        ObjectInputStream in = new ObjectInputStream(stream);
        return in.readObject();
    }
    
    public Object vuln317(byte[] data) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
    
    public Object vuln318(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
    
    public Object vuln319(InputStream input) throws Exception {
        ObjectInputStream stream = new ObjectInputStream(input);
        return stream.readObject();
    }
    
    public Object vuln320(byte[] serialized) throws Exception {
        return new ObjectInputStream(new ByteArrayInputStream(serialized)).readObject();
    }
}
