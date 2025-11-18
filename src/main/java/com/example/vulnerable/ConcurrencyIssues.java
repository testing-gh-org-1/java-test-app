package com.example.vulnerable;

import java.util.*;

/**
 * Concurrency and Thread Safety vulnerabilities
 * CWE-362: Concurrent Execution using Shared Resource with Improper Synchronization
 * CWE-366: Race Condition within a Thread
 * CWE-567: Unsynchronized Access to Shared Data
 */
public class ConcurrencyIssues {
    
    // VULNERABILITY: Unsynchronized access to shared mutable state
    private int counter = 0;
    private Map<String, String> sharedMap = new HashMap<>();
    private List<String> sharedList = new ArrayList<>();
    
    public void incrementCounter() {
        // VULNERABILITY: Race condition
        counter++;
    }
    
    public int getCounter() {
        // VULNERABILITY: Unsynchronized read
        return counter;
    }
    
    public void addToMap(String key, String value) {
        // VULNERABILITY: HashMap is not thread-safe
        sharedMap.put(key, value);
    }
    
    public void addToList(String item) {
        // VULNERABILITY: ArrayList is not thread-safe
        sharedList.add(item);
    }
    
    public void checkThenAct(String key) {
        // VULNERABILITY: Time-of-check time-of-use (TOCTOU)
        if (!sharedMap.containsKey(key)) {
            sharedMap.put(key, "default");
        }
    }
    
    public void doubleCheckedLocking(Object obj) {
        // VULNERABILITY: Broken double-checked locking
        if (obj == null) {
            synchronized (this) {
                if (obj == null) {
                    obj = new Object();
                }
            }
        }
    }
    
    private boolean flag = false;
    
    public void setFlag() {
        // VULNERABILITY: Non-volatile flag in concurrent context
        flag = true;
    }
    
    public boolean checkFlag() {
        // VULNERABILITY: Visibility issue
        return flag;
    }
    
    public void iterateSharedCollection() {
        // VULNERABILITY: Concurrent modification
        for (String item : sharedList) {
            if (item.equals("remove")) {
                sharedList.remove(item);
            }
        }
    }
}
