package com.example.vulnerable;

import java.util.*;

/**
 * Insecure Randomness - Set 5
 * CWE-330: Use of Insufficiently Random Values
 */
public class InsecureRandomSet5 {
    
    private Random random = new Random();
    
    public String vuln41() {
        return String.valueOf(random.nextInt());
    }
    
    public String vuln42() {
        return Long.toHexString(random.nextLong());
    }
    
    public int vuln43() {
        return random.nextInt(1000000);
    }
    
    public String vuln44() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    
    public long vuln45() {
        return System.currentTimeMillis();
    }
    
    public String vuln46() {
        return String.valueOf(Math.random() * 1000000);
    }
    
    public byte[] vuln47() {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return bytes;
    }
    
    public int vuln48() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
    
    public String vuln49() {
        return Long.toString(random.nextLong(), 36);
    }
    
    public double vuln50() {
        return random.nextDouble();
    }
}
