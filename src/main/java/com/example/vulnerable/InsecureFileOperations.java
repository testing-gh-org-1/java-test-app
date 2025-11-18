package com.example.vulnerable;

import java.io.*;
import java.nio.file.*;

/**
 * Insecure File Operations vulnerabilities
 * CWE-732: Incorrect Permission Assignment for Critical Resource
 * CWE-379: Creation of Temporary File in Directory with Insecure Permissions
 */
public class InsecureFileOperations {
    
    public File createTempFileUnsafe() throws IOException {
        // VULNERABILITY: Predictable temp file name
        File temp = File.createTempFile("data", ".tmp");
        return temp;
    }
    
    public void createFileWithWeakPermissions(String filename) throws IOException {
        // VULNERABILITY: File created with default permissions
        File file = new File(filename);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("sensitive data");
        writer.close();
    }
    
    public void setPermissionsUnsafe(String filename) {
        // VULNERABILITY: World-readable/writable permissions
        File file = new File(filename);
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, false);
    }
    
    public void createDirectoryUnsafe(String dirName) {
        // VULNERABILITY: Directory with insecure permissions
        File dir = new File(dirName);
        dir.mkdir();
    }
    
    public void writeToTempFile(String data) throws IOException {
        // VULNERABILITY: Temp file in /tmp with sensitive data
        File temp = new File("/tmp/sensitive_data.txt");
        FileWriter writer = new FileWriter(temp);
        writer.write(data);
        writer.close();
    }
    
    public void logToFile(String logMessage) throws IOException {
        // VULNERABILITY: Log file with weak permissions
        File logFile = new File("/var/log/app.log");
        FileWriter fw = new FileWriter(logFile, true);
        fw.write(logMessage + "\n");
        fw.close();
    }
    
    public void createSymlinkUnsafe(String target, String link) throws IOException {
        // VULNERABILITY: Symlink without validation
        Path targetPath = Paths.get(target);
        Path linkPath = Paths.get(link);
        Files.createSymbolicLink(linkPath, targetPath);
    }
}
