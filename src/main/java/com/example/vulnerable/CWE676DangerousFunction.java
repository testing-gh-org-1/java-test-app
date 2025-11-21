package com.example.vulnerable;

import java.io.*;
import java.net.*;

/**
 * CWE-676: Use of Potentially Dangerous Function
 * 
 * Functions that are inherently dangerous or have safer alternatives.
 */
public class CWE676DangerousFunction {
    
    /**
     * vuln521: Use of Runtime.exec() with shell metacharacters
     */
    public void vuln521(String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd); // Dangerous, allows command injection
    }
    
    /**
     * vuln522: Use of Thread.stop()
     */
    public void vuln522(Thread t) {
        t.stop(); // Deprecated and dangerous
    }
    
    /**
     * vuln523: Use of Thread.suspend()
     */
    public void vuln523(Thread t) {
        t.suspend(); // Deprecated and dangerous
    }
    
    /**
     * vuln524: Use of Thread.resume()
     */
    public void vuln524(Thread t) {
        t.resume(); // Deprecated and dangerous
    }
    
    /**
     * vuln525: Use of System.exit()
     */
    public void vuln525() {
        System.exit(0); // Terminates JVM abruptly
    }
    
    /**
     * vuln526: Use of Runtime.halt()
     */
    public void vuln526() {
        Runtime.getRuntime().halt(0); // Even more abrupt than exit
    }
    
    /**
     * vuln527: Use of sun.misc.Unsafe
     */
    public void vuln527() throws Exception {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        java.lang.reflect.Field f = unsafeClass.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Object unsafe = f.get(null); // Direct memory access
    }
    
    /**
     * vuln528: Use of finalize()
     */
    @Override
    protected void finalize() throws Throwable {
        // Dangerous, unpredictable timing
        super.finalize();
    }
    
    /**
     * vuln529: Use of clone() without proper implementation
     */
    public Object vuln529() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy, dangerous for complex objects
    }
    
    /**
     * vuln530: Use of File.deleteOnExit()
     */
    public void vuln530(File f) {
        f.deleteOnExit(); // Memory leak for long-running apps
    }
    
    /**
     * vuln531: Use of StringTokenizer
     */
    public void vuln531(String s) {
        StringTokenizer st = new StringTokenizer(s); // Legacy, use String.split()
        while (st.hasMoreTokens()) {
            st.nextToken();
        }
    }
    
    /**
     * vuln532: Use of Vector (synchronized unnecessarily)
     */
    public void vuln532() {
        Vector<String> v = new Vector<>(); // Use ArrayList instead
        v.add("test");
    }
    
    /**
     * vuln533: Use of Hashtable (synchronized unnecessarily)
     */
    public void vuln533() {
        Hashtable<String, String> ht = new Hashtable<>(); // Use HashMap instead
        ht.put("key", "value");
    }
    
    /**
     * vuln534: Use of StringBuffer when not needed
     */
    public String vuln534() {
        StringBuffer sb = new StringBuffer(); // Use StringBuilder if not thread-safe
        sb.append("test");
        return sb.toString();
    }
    
    /**
     * vuln535: Use of Runtime.runFinalization()
     */
    public void vuln535() {
        Runtime.getRuntime().runFinalization(); // Dangerous, unpredictable
    }
    
    /**
     * vuln536: Use of System.gc()
     */
    public void vuln536() {
        System.gc(); // Dangerous, unpredictable performance impact
    }
    
    /**
     * vuln537: Use of Runtime.traceInstructions()
     */
    public void vuln537() {
        Runtime.getRuntime().traceInstructions(true); // Dangerous debugging function
    }
    
    /**
     * vuln538: Use of Runtime.traceMethodCalls()
     */
    public void vuln538() {
        Runtime.getRuntime().traceMethodCalls(true); // Dangerous debugging function
    }
    
    /**
     * vuln539: Use of Class.newInstance()
     */
    public Object vuln539(String className) throws Exception {
        return Class.forName(className).newInstance(); // Deprecated, use getDeclaredConstructor()
    }
    
    /**
     * vuln540: Use of URL constructor with string
     */
    public void vuln540(String url) throws Exception {
        new URL(url); // Can be exploited with file:// or jar:// protocols
    }
}
