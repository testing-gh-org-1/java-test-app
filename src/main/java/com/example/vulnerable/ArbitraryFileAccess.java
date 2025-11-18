package com.example.vulnerable;

import java.io.*;
import java.nio.file.*;

/**
 * Arbitrary File Write/Read - CRITICAL
 * CWE-22: Path Traversal leading to arbitrary file operations
 */
public class ArbitraryFileAccess {
    
    public void writeToFile(String filename, String content) throws IOException {
        // CRITICAL: Arbitrary file write
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
    
    public String readAnyFile(String filepath) throws IOException {
        // CRITICAL: Arbitrary file read
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
    
    public void deleteAnyFile(String filepath) {
        // CRITICAL: Arbitrary file deletion
        new File(filepath).delete();
    }
    
    public void writeSystemFile(String path, byte[] data) throws IOException {
        // CRITICAL: Writing to system files
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(data);
        fos.close();
    }
    
    public void modifyConfigFile(String configPath, String newConfig) throws IOException {
        // CRITICAL: Configuration file tampering
        PrintWriter writer = new PrintWriter(configPath);
        writer.println(newConfig);
        writer.close();
    }
    
    public void overwriteFile(String target, String source) throws IOException {
        // CRITICAL: Arbitrary file overwrite
        Files.copy(Paths.get(source), Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
    }
    
    public void uploadFile(String destination, InputStream input) throws IOException {
        // CRITICAL: Unrestricted file upload
        FileOutputStream output = new FileOutputStream(destination);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        output.close();
    }
}
