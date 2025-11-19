package com.example.vulnerable;

import java.util.regex.*;

/**
 * ReDoS - Set 15
 * CWE-1333: Regular Expression Denial of Service
 */
public class ReDoSSet15 {
    
    public boolean vuln141(String input) {
        return Pattern.matches("(a+)+b", input);
    }
    
    public boolean vuln142(String text) {
        return text.matches("(a*)*c");
    }
    
    public boolean vuln143(String data) {
        return Pattern.compile("(x+)+y").matcher(data).matches();
    }
    
    public boolean vuln144(String str) {
        return str.matches("(a|a)*b");
    }
    
    public boolean vuln145(String input) {
        return Pattern.matches("(a|ab)*c", input);
    }
    
    public boolean vuln146(String text) {
        return text.matches("(\\w+)*\\.");
    }
    
    public boolean vuln147(String data) {
        return Pattern.compile("(.*)*suffix").matcher(data).find();
    }
    
    public boolean vuln148(String str) {
        return str.matches("^(a+)+$");
    }
    
    public boolean vuln149(String input) {
        return Pattern.matches("(x*)*y", input);
    }
    
    public boolean vuln150(String text) {
        return text.matches("(a|b|c)*d");
    }
}
