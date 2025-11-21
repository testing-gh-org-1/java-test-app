package com.example.vulnerable;

/**
 * CWE-691: Insufficient Control Flow Management
 * 
 * Improper control flow that allows attackers to manipulate program execution,
 * including missing break statements, improper loop conditions, and incorrect
 * use of goto-like constructs.
 */
public class CWE691InsufficientControlFlow {
    
    /**
     * vuln611: Missing break in switch statement
     */
    public String vuln611(int code) {
        String result = "";
        switch (code) {
            case 1:
                result = "Admin";
                // Missing break - falls through
            case 2:
                result = "User";
                // Missing break - falls through
            case 3:
                result = "Guest";
                break;
            default:
                result = "Unknown";
        }
        return result;
    }
    
    /**
     * vuln612: Improper loop exit condition
     */
    public void vuln612(String[] data) {
        for (int i = 0; i <= data.length; i++) { // Off-by-one
            System.out.println(data[i]);
        }
    }
    
    /**
     * vuln613: Incorrect continue usage
     */
    public int vuln613(int[] values) {
        int sum = 0;
        for (int value : values) {
            if (value < 0) {
                continue; // Skips validation
            }
            sum += value; // Positive values only, negative ignored
        }
        return sum;
    }
    
    /**
     * vuln614: Nested loop with wrong break
     */
    public boolean vuln614(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == target) {
                    break; // Only breaks inner loop
                }
            }
        }
        return false; // Should return true if found
    }
    
    /**
     * vuln615: Exception changes control flow unexpectedly
     */
    public int vuln615(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return 0; // Silently returns default, hiding errors
        }
    }
    
    /**
     * vuln616: Return in finally block
     */
    public int vuln616(int x) {
        try {
            return x / 0;
        } catch (Exception e) {
            return -1;
        } finally {
            return 0; // Overrides previous returns
        }
    }
    
    /**
     * vuln617: Unreachable code after return
     */
    public void vuln617(boolean flag) {
        if (flag) {
            return;
        }
        return;
        // Any code here would be unreachable
    }
    
    /**
     * vuln618: Infinite loop without proper exit
     */
    public void vuln618(int[] data) {
        int i = 0;
        while (true) {
            if (i >= data.length) {
                return; // Should use proper loop condition
            }
            System.out.println(data[i++]);
        }
    }
    
    /**
     * vuln619: Goto-like control flow with exceptions
     */
    public void vuln619(int state) {
        try {
            if (state == 1) throw new Exception("State1");
            if (state == 2) throw new Exception("State2");
            // Normal flow
        } catch (Exception e) {
            // Using exceptions for control flow
            if (e.getMessage().equals("State1")) {
                // Handle state 1
            } else if (e.getMessage().equals("State2")) {
                // Handle state 2
            }
        }
    }
    
    /**
     * vuln620: Missing default case in switch
     */
    public String vuln620(int role) {
        switch (role) {
            case 1: return "Admin";
            case 2: return "User";
            // Missing default case
        }
        return null; // Unexpected null return
    }
    
    /**
     * vuln621: Multiple returns obscure logic
     */
    public boolean vuln621(int value) {
        if (value < 0) return false;
        if (value == 0) return false;
        if (value > 100) return true;
        if (value % 2 == 0) return true;
        return false; // Complex logic hard to follow
    }
    
    /**
     * vuln622: Early exit skips cleanup
     */
    public void vuln622(java.io.FileInputStream fis) throws Exception {
        try {
            int data = fis.read();
            if (data == -1) {
                return; // Early exit, stream not closed
            }
            // Process data
        } catch (Exception e) {
            return; // Another early exit
        }
        // fis.close() never reached
    }
    
    /**
     * vuln623: Loop with side effects in condition
     */
    public int vuln623(int[] array, int target) {
        int i = 0;
        while (i < array.length && array[i++] != target) {
            // i incremented in condition
        }
        return i; // Off-by-one due to increment in condition
    }
    
    /**
     * vuln624: Incorrect loop update
     */
    public void vuln624(int start, int end) {
        for (int i = start; i < end; i--) { // Decrements instead of increments
            System.out.println(i);
        }
    }
    
    /**
     * vuln625: Dead code after throw
     */
    public void vuln625(boolean condition) throws Exception {
        if (condition) {
            throw new Exception("Error");
            // System.out.println("Dead code"); - would be unreachable
        }
    }
    
    /**
     * vuln626: Switch fall-through without comment
     */
    public int vuln626(String operation) {
        int result = 0;
        switch (operation) {
            case "INIT":
                result = 1;
            case "START": // Intentional fall-through not documented
                result = 2;
            case "RUN":
                result = 3;
                break;
        }
        return result;
    }
    
    /**
     * vuln627: Nested exception handling confusion
     */
    public void vuln627(String input) {
        try {
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid", e);
            }
        } catch (IllegalArgumentException e) {
            // Catches what we just threw - confusing
            throw e;
        }
    }
    
    /**
     * vuln628: Label usage (rare in Java but possible)
     */
    public void vuln628(int[][] matrix) {
        outer:
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) {
                    break outer; // Breaks outer loop - can be confusing
                }
            }
        }
    }
    
    /**
     * vuln629: Finally block modifies return value
     */
    public String vuln629() {
        String result = "initial";
        try {
            result = "try";
            return result;
        } finally {
            result = "finally"; // Modifies after return set
        }
    }
    
    /**
     * vuln630: Complex conditional with side effects
     */
    public boolean vuln630(int[] array, int index) {
        return index >= 0 && index < array.length && array[index]++ > 0;
        // Side effect in condition
    }
}
