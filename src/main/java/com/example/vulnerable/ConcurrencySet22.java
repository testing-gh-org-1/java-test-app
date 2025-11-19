package com.example.vulnerable;

import java.util.*;

/**
 * Concurrency Issues - Set 22
 * CWE-362: Race Condition
 */
public class ConcurrencySet22 {
    
    private int vuln211 = 0;
    private long vuln212 = 0L;
    private double vuln213 = 0.0;
    private List<String> vuln214 = new ArrayList<>();
    private Map<String, String> vuln215 = new HashMap<>();
    private Set<String> vuln216 = new HashSet<>();
    private StringBuilder vuln217 = new StringBuilder();
    private StringBuffer vuln218 = new StringBuffer();
    private boolean vuln219 = false;
    private String vuln220 = null;
    
    public void incrementVuln211() {
        vuln211++;
    }
    
    public void incrementVuln212() {
        vuln212++;
    }
    
    public void addToVuln214(String item) {
        vuln214.add(item);
    }
    
    public void addToVuln215(String key, String value) {
        vuln215.put(key, value);
    }
    
    public void addToVuln216(String item) {
        vuln216.add(item);
    }
    
    public void appendToVuln217(String text) {
        vuln217.append(text);
    }
    
    public void setVuln219() {
        vuln219 = true;
    }
    
    public void setVuln220(String value) {
        vuln220 = value;
    }
    
    public void updateVuln213(double value) {
        vuln213 = value;
    }
}
