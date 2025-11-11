package com.example.vulnerable;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Command Injection vulnerability example
 * CWE-78: Improper Neutralization of Special Elements used in an OS Command
 */
public class CommandInjectionExample {
    
    public String pingHost(String hostname) throws Exception {
        // VULNERABILITY: Command Injection - user input in system command
        String command = "ping -c 4 " + hostname;
        Process process = Runtime.getRuntime().exec(command);
        
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()));
        
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        
        return output.toString();
    }
    
    public void executeUserCommand(String userInput) throws Exception {
        // VULNERABILITY: Arbitrary command execution
        String[] cmd = {"/bin/sh", "-c", userInput};
        Runtime.getRuntime().exec(cmd);
    }
    
    public String listDirectory(String path) throws Exception {
        // VULNERABILITY: Command Injection through path parameter
        Process process = Runtime.getRuntime().exec("ls -la " + path);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()));
        
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        
        return output.toString();
    }
}
