package com.example.vulnerable;

import java.io.*;

/**
 * Command Injection - Set 27
 */
public class CommandSet27 {
    
    public void vuln261(String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd);
    }
    
    public void vuln262(String file) throws Exception {
        Runtime.getRuntime().exec("head " + file);
    }
    
    public void vuln263(String dir) throws Exception {
        Runtime.getRuntime().exec("cd " + dir);
    }
    
    public void vuln264(String proc) throws Exception {
        Runtime.getRuntime().exec("ps aux | grep " + proc);
    }
    
    public void vuln265(String path) throws Exception {
        Runtime.getRuntime().exec("chmod 777 " + path);
    }
    
    public void vuln266(String user) throws Exception {
        Runtime.getRuntime().exec("userdel " + user);
    }
    
    public void vuln267(String pkg) throws Exception {
        Runtime.getRuntime().exec("apt-get install " + pkg);
    }
    
    public void vuln268(String svc) throws Exception {
        Runtime.getRuntime().exec("systemctl restart " + svc);
    }
    
    public void vuln269(String txt) throws Exception {
        Runtime.getRuntime().exec("echo " + txt + " > /tmp/out.txt");
    }
    
    public void vuln270(String ip) throws Exception {
        Runtime.getRuntime().exec("traceroute " + ip);
    }
}
