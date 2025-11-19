package com.example.vulnerable;

import java.io.*;
import java.net.*;

/**
 * SSRF - Set 31
 */
public class SSRFSet31 {
    
    public void vuln301(String url) throws Exception {
        new URL(url).openConnection();
    }
    
    public void vuln302(String url) throws Exception {
        new URL(url).openStream();
    }
    
    public void vuln303(String url) throws Exception {
        new URL(url).getContent();
    }
    
    public void vuln304(String host) throws Exception {
        new Socket(host, 80);
    }
    
    public void vuln305(String host, int port) throws Exception {
        new Socket(host, port);
    }
    
    public void vuln306(String url) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.connect();
    }
    
    public void vuln307(String url) throws Exception {
        URLConnection conn = new URL(url).openConnection();
        conn.getInputStream();
    }
    
    public void vuln308(String host) throws Exception {
        InetAddress.getByName(host);
    }
    
    public void vuln309(String url) throws Exception {
        new URL(url).openStream().read();
    }
    
    public void vuln310(String endpoint) throws Exception {
        new URL(endpoint).openConnection().connect();
    }
}
