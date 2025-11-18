package com.example.vulnerable;

import javax.net.ssl.*;
import java.net.*;
import java.security.cert.*;

/**
 * Insecure Transport vulnerabilities
 * CWE-295: Improper Certificate Validation
 * CWE-319: Cleartext Transmission of Sensitive Information
 */
public class InsecureTransport {
    
    public String connectHTTP(String url) throws Exception {
        // VULNERABILITY: HTTP instead of HTTPS
        URL website = new URL("http://" + url);
        URLConnection conn = website.openConnection();
        return conn.getContent().toString();
    }
    
    public void disableSSLVerification() throws Exception {
        // VULNERABILITY: Disabling SSL verification
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
            }
        };
        
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    
    public void disableHostnameVerification() {
        // VULNERABILITY: Disabling hostname verification
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    }
    
    public URLConnection connectUnsafe(String url) throws Exception {
        // VULNERABILITY: Accepting all certificates
        URL website = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) website.openConnection();
        conn.setHostnameVerifier((hostname, session) -> true);
        return conn;
    }
    
    public void sendPassword(String password) throws Exception {
        // VULNERABILITY: Sending sensitive data over HTTP
        URL url = new URL("http://example.com/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.getOutputStream().write(("password=" + password).getBytes());
    }
}
