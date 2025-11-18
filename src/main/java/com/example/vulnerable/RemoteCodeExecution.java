package com.example.vulnerable;

import java.io.*;

/**
 * Remote Code Execution vulnerabilities - CRITICAL
 * CWE-78: OS Command Injection leading to RCE
 */
public class RemoteCodeExecution {
    
    public String executeSystemCommand(String command) throws Exception {
        // CRITICAL: Direct command execution
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
    
    public void runShellScript(String script) throws Exception {
        // CRITICAL: Shell script execution
        String[] cmd = {"/bin/bash", "-c", script};
        Runtime.getRuntime().exec(cmd);
    }
    
    public void executePowerShell(String psCommand) throws Exception {
        // CRITICAL: PowerShell command execution
        String[] cmd = {"powershell.exe", "-Command", psCommand};
        Runtime.getRuntime().exec(cmd);
    }
    
    public void runPythonCode(String pythonCode) throws Exception {
        // CRITICAL: Dynamic code execution
        String[] cmd = {"python", "-c", pythonCode};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
    }
    
    public void downloadAndExecute(String url, String filename) throws Exception {
        // CRITICAL: Download and execute pattern
        String[] downloadCmd = {"wget", url, "-O", filename};
        Runtime.getRuntime().exec(downloadCmd).waitFor();
        
        String[] executeCmd = {"chmod", "+x", filename};
        Runtime.getRuntime().exec(executeCmd).waitFor();
        
        Runtime.getRuntime().exec(filename);
    }
    
    public void evaluateUserCode(String code) throws Exception {
        // CRITICAL: Arbitrary code compilation and execution
        File sourceFile = new File("UserCode.java");
        FileWriter writer = new FileWriter(sourceFile);
        writer.write(code);
        writer.close();
        
        Runtime.getRuntime().exec("javac UserCode.java");
        Runtime.getRuntime().exec("java UserCode");
    }
}
