package com.example.vulnerable;

import java.util.*;

/**
 * Memory and Performance Issues
 * CWE-400: Uncontrolled Resource Consumption
 * CWE-789: Memory Allocation with Excessive Size Value
 */
public class MemoryIssues {
    
    private static Map<String, Object> cache = new HashMap<>();
    
    public void addToUnboundedCache(String key, Object value) {
        // VULNERABILITY: Unbounded cache growth
        cache.put(key, value);
    }
    
    public byte[] allocateMemory(int size) {
        // VULNERABILITY: Uncontrolled memory allocation
        return new byte[size];
    }
    
    public List<String> readAllLines(String[] lines) {
        // VULNERABILITY: Loading unbounded data into memory
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(line);
        }
        return result;
    }
    
    public String concatenateStrings(String[] strings) {
        // VULNERABILITY: Inefficient string concatenation
        String result = "";
        for (String s : strings) {
            result = result + s;
        }
        return result;
    }
    
    public void createManyObjects(int count) {
        // VULNERABILITY: Object creation in loop
        for (int i = 0; i < count; i++) {
            new LargeObject();
        }
    }
    
    public Map<String, String> loadAllData() {
        // VULNERABILITY: Loading entire dataset
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            data.put("key" + i, "value" + i);
        }
        return data;
    }
    
    static class LargeObject {
        private byte[] data = new byte[1024 * 1024]; // 1MB
    }
}
