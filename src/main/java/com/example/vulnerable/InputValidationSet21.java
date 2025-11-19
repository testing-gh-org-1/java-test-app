package com.example.vulnerable;

/**
 * Input Validation - Set 21
 * CWE-20: Improper Input Validation
 */
public class InputValidationSet21 {
    
    public int vuln201(String input) {
        return Integer.parseInt(input);
    }
    
    public long vuln202(String data) {
        return Long.parseLong(data);
    }
    
    public double vuln203(String value) {
        return Double.parseDouble(value);
    }
    
    public float vuln204(String num) {
        return Float.parseFloat(num);
    }
    
    public void vuln205(String[] array, int index) {
        System.out.println(array[index]);
    }
    
    public void vuln206(int divisor) {
        int result = 100 / divisor;
    }
    
    public String vuln207(String str, int start, int end) {
        return str.substring(start, end);
    }
    
    public void vuln208(int size) {
        new byte[size];
    }
    
    public char vuln209(String text, int pos) {
        return text.charAt(pos);
    }
    
    public void vuln210(String format, Object... args) {
        String.format(format, args);
    }
}
