package com.example.vulnerable;

import java.io.*;

/**
 * Unsafe Deserialization - CRITICAL
 * CWE-502: Can lead to Remote Code Execution
 */
public class UnsafeDeserialization {
    
    public Object deserializeUntrusted(byte[] data) throws Exception {
        // CRITICAL: Deserializing untrusted data without validation
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
    
    public Object readFromNetwork(InputStream networkStream) throws Exception {
        // CRITICAL: Deserializing from network without validation
        ObjectInputStream ois = new ObjectInputStream(networkStream);
        return ois.readObject();
    }
    
    public Object loadFromUserFile(String userFilePath) throws Exception {
        // CRITICAL: Loading serialized objects from user-controlled path
        FileInputStream fis = new FileInputStream(userFilePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        fis.close();
        return obj;
    }
    
    public void processSerializedData(byte[] serializedData) throws Exception {
        // CRITICAL: Processing without type checking
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedData));
        Object obj = ois.readObject();
        ois.close();
        
        // Direct method invocation on deserialized object
        obj.getClass().getMethod("execute").invoke(obj);
    }
    
    public Object deserializeFromURL(String url) throws Exception {
        // CRITICAL: Deserializing from remote URL
        java.net.URL website = new java.net.URL(url);
        ObjectInputStream ois = new ObjectInputStream(website.openStream());
        return ois.readObject();
    }
}
