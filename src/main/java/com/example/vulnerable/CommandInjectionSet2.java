package com.example.vulnerable;

import java.io.*;

/**
 * Command Injection vulnerabilities - Set 2
 * CWE-78: OS Command Injection
 */
public class CommandInjectionSet2 {
    
    public void vuln11(String filename) throws Exception {
        Runtime.getRuntime().exec("cat " + filename);
    }
    
    public void vuln12(String dir) throws Exception {
        Runtime.getRuntime().exec("ls " + dir);
    }
    
    public void vuln13(String pattern) throws Exception {
        Runtime.getRuntime().exec("grep " + pattern + " /var/log/app.log");
    }
    
    public void vuln14(String file) throws Exception {
        Runtime.getRuntime().exec("rm -rf " + file);
    }
    
    public void vuln15(String dest) throws Exception {
        Runtime.getRuntime().exec("cp /tmp/file " + dest);
    }
    
    public void vuln16(String url) throws Exception {
        Runtime.getRuntime().exec("curl " + url);
    }
    
    public void vuln17(String host) throws Exception {
        Runtime.getRuntime().exec("ping -c 4 " + host);
    }
    
    public void vuln18(String port) throws Exception {
        Runtime.getRuntime().exec("netstat -an | grep " + port);
    }
    
    public void vuln19(String process) throws Exception {
        Runtime.getRuntime().exec("kill -9 " + process);
    }
    
    public void vuln20(String user) throws Exception {
        Runtime.getRuntime().exec("su - " + user);
    }
}
