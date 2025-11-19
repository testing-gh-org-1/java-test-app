package com.example.vulnerable;

import java.io.*;
import java.net.*;

/**
 * SSRF vulnerabilities - Set 6
 * CWE-918: Server-Side Request Forgery
 */
public class SSRFSet6 {
    
    public void vuln51(String url) throws Exception {
        new URL(url).openConnection().connect();
    }
    
    public void vuln52(String host) throws Exception {
        new URL("http://" + host + "/api").openStream();
    }
    
    public void vuln53(String endpoint) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
        conn.connect();
    }
    
    public void vuln54(String server, String path) throws Exception {
        new URL("https://" + server + path).getContent();
    }
    
    public void vuln55(String target) throws Exception {
        URLConnection conn = new URL(target).openConnection();
        conn.getInputStream();
    }
    
    public void vuln56(String ip) throws Exception {
        new Socket(ip, 80);
    }
    
    public void vuln57(String host, int port) throws Exception {
        new Socket(host, port).connect(new InetSocketAddress(host, port));
    }
    
    public void vuln58(String url) throws Exception {
        new URL(url).openStream().read();
    }
    
    public void vuln59(String domain) throws Exception {
        InetAddress.getByName(domain);
    }
    
    public void vuln60(String resource) throws Exception {
        new URL("http://internal/" + resource).openConnection();
    }
}
