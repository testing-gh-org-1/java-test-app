package com.example.vulnerable;

import java.util.*;

/**
 * Memory Issues - Set 23
 * CWE-400: Uncontrolled Resource Consumption
 */
public class MemorySet23 {
    
    private static List<Object> vuln221 = new ArrayList<>();
    private static Map<String, Object> vuln222 = new HashMap<>();
    private static Set<Object> vuln223 = new HashSet<>();
    
    public void vuln224(Object obj) {
        vuln221.add(obj);
    }
    
    public void vuln225(String key, Object value) {
        vuln222.put(key, value);
    }
    
    public void vuln226(Object item) {
        vuln223.add(item);
    }
    
    public byte[] vuln227(int size) {
        return new byte[size];
    }
    
    public int[] vuln228(int length) {
        return new int[length];
    }
    
    public String vuln229(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "x";
        }
        return result;
    }
    
    public List<Object> vuln230(int size) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Object());
        }
        return list;
    }
}
