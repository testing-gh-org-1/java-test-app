package com.example.vulnerable;

import java.util.*;

/**
 * Insecure Random - Set 30
 */
public class RandomSet30 {
    
    private Random r = new Random();
    
    public int vuln291() {
        return r.nextInt();
    }
    
    public long vuln292() {
        return r.nextLong();
    }
    
    public double vuln293() {
        return r.nextDouble();
    }
    
    public float vuln294() {
        return r.nextFloat();
    }
    
    public boolean vuln295() {
        return r.nextBoolean();
    }
    
    public byte[] vuln296() {
        byte[] b = new byte[16];
        r.nextBytes(b);
        return b;
    }
    
    public int vuln297() {
        return (int)(Math.random() * 1000);
    }
    
    public String vuln298() {
        return UUID.randomUUID().toString();
    }
    
    public long vuln299() {
        return System.currentTimeMillis();
    }
    
    public long vuln300() {
        return System.nanoTime();
    }
}
