package com.example.vulnerable;

/**
 * Null Pointer - Set 14
 * CWE-476: NULL Pointer Dereference
 */
public class NullPointerSet14 {
    
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    
    public int vuln131(String s) {
        return s.length();
    }
    
    public String vuln132(String input) {
        return input.toUpperCase();
    }
    
    public char vuln133(String str) {
        return str.charAt(0);
    }
    
    public String vuln134(String data) {
        return data.trim();
    }
    
    public boolean vuln135(String text) {
        return text.isEmpty();
    }
    
    public String vuln136(String value) {
        return value.substring(0, 5);
    }
    
    public int vuln137() {
        return field1.length();
    }
    
    public String vuln138() {
        return field2.toUpperCase();
    }
    
    public void vuln139() {
        System.out.println(field3.length());
    }
    
    public void vuln140() {
        field4.trim();
    }
}
