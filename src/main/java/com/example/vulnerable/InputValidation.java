package com.example.vulnerable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Input Validation Issues
 * CWE-20: Improper Input Validation
 */
public class InputValidation {
    
    public int processNumber(String input) {
        // VULNERABILITY: No validation before parsing
        return Integer.parseInt(input);
    }
    
    public double calculateDiscount(String percent) {
        // VULNERABILITY: No range validation
        double value = Double.parseDouble(percent);
        return value / 100;
    }
    
    public Date parseDate(String dateStr) throws Exception {
        // VULNERABILITY: No format validation
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }
    
    public void processArray(String[] data, int index) {
        // VULNERABILITY: No bounds checking
        System.out.println(data[index]);
    }
    
    public String substring(String input, int start, int end) {
        // VULNERABILITY: No index validation
        return input.substring(start, end);
    }
    
    public void divide(int a, int b) {
        // VULNERABILITY: No division by zero check
        int result = a / b;
        System.out.println(result);
    }
    
    public void allocateArray(int size) {
        // VULNERABILITY: No size validation
        int[] array = new int[size];
    }
    
    public String formatString(String template, Object... args) {
        // VULNERABILITY: Unvalidated format string
        return String.format(template, args);
    }
}
