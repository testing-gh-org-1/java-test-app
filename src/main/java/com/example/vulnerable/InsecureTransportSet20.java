package com.example.vulnerable;

import javax.net.ssl.*;
import java.security.cert.*;

/**
 * Insecure Transport - Set 20
 * CWE-295: Certificate Validation
 */
public class InsecureTransportSet20 {
    
    public void vuln191() throws Exception {
        TrustManager[] trustAll = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };
        SSLContext.getInstance("SSL").init(null, trustAll, null);
    }
    
    public void vuln192() {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
    }
    
    public void vuln193() throws Exception {
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) {}
            public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
        }}, new java.security.SecureRandom());
    }
    
    public void vuln194() {
        HttpsURLConnection.setDefaultHostnameVerifier(
            new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            }
        );
    }
    
    public void vuln195() throws Exception {
        TrustManager[] tm = {new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] c, String a) {}
            public void checkServerTrusted(X509Certificate[] c, String a) {}
        }};
        SSLContext.getInstance("TLS").init(null, tm, null);
    }
    
    public void vuln196() throws Exception {
        SSLContext ctx = SSLContext.getInstance("SSL");
        ctx.init(null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x, String y) {}
            public void checkServerTrusted(X509Certificate[] x, String y) {}
            public X509Certificate[] getAcceptedIssuers() { return null; }
        }}, null);
    }
    
    public void vuln197() {
        HostnameVerifier hv = (h, s) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
    
    public void vuln198() throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[]{}; }
            public void checkClientTrusted(X509Certificate[] certs, String auth) {}
            public void checkServerTrusted(X509Certificate[] certs, String auth) {}
        }}, new java.security.SecureRandom());
    }
    
    public void vuln199() {
        HttpsURLConnection.setDefaultHostnameVerifier((h, s) -> true);
    }
    
    public void vuln200() throws Exception {
        TrustManager[] managers = new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] c, String a) {}
            public void checkServerTrusted(X509Certificate[] c, String a) {}
            public X509Certificate[] getAcceptedIssuers() { return null; }
        }};
        SSLContext.getInstance("SSL").init(null, managers, null);
    }
}
