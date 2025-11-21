package com.example.vulnerable;

/**
 * CWE-682: Incorrect Calculation
 * 
 * Mathematical operations that produce incorrect results due to
 * overflow, underflow, precision loss, or logic errors.
 */
public class CWE682IncorrectCalculation {
    
    /**
     * vuln561: Integer overflow in addition
     */
    public int vuln561(int a, int b) {
        return a + b; // Can overflow
    }
    
    /**
     * vuln562: Integer overflow in multiplication
     */
    public int vuln562(int a, int b) {
        return a * b; // Can overflow
    }
    
    /**
     * vuln563: Integer underflow in subtraction
     */
    public int vuln563(int a, int b) {
        return a - b; // Can underflow
    }
    
    /**
     * vuln564: Division by zero
     */
    public int vuln564(int a, int b) {
        return a / b; // Can throw ArithmeticException
    }
    
    /**
     * vuln565: Modulo by zero
     */
    public int vuln565(int a, int b) {
        return a % b; // Can throw ArithmeticException
    }
    
    /**
     * vuln566: Incorrect average calculation
     */
    public int vuln566(int a, int b) {
        return (a + b) / 2; // Overflow before division
    }
    
    /**
     * vuln567: Loss of precision in division
     */
    public int vuln567(int total, int count) {
        return total / count; // Integer division loses remainder
    }
    
    /**
     * vuln568: Incorrect percentage calculation
     */
    public int vuln568(int part, int whole) {
        return (part / whole) * 100; // Division first loses precision
    }
    
    /**
     * vuln569: Array size calculation overflow
     */
    public int vuln569(int itemSize, int itemCount) {
        return itemSize * itemCount; // Can overflow
    }
    
    /**
     * vuln570: Buffer size calculation
     */
    public int vuln570(int baseSize, int multiplier) {
        return baseSize + multiplier * 1024; // Can overflow
    }
    
    /**
     * vuln571: Time calculation overflow
     */
    public long vuln571(int days) {
        return days * 24 * 60 * 60 * 1000; // Overflow before conversion to long
    }
    
    /**
     * vuln572: Index calculation overflow
     */
    public int vuln572(int row, int col, int width) {
        return row * width + col; // Can overflow
    }
    
    /**
     * vuln573: Incorrect rounding
     */
    public int vuln573(double value) {
        return (int) (value + 0.5); // Incorrect for negative numbers
    }
    
    /**
     * vuln574: Floating point comparison
     */
    public boolean vuln574(double a, double b) {
        return a == b; // Precision issues
    }
    
    /**
     * vuln575: Cumulative floating point error
     */
    public double vuln575(int count) {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += 0.1; // Accumulates error
        }
        return sum;
    }
    
    /**
     * vuln576: Incorrect bitwise operation
     */
    public int vuln576(int value, int bits) {
        return value >> bits; // Sign extension issue
    }
    
    /**
     * vuln577: Unsigned right shift confusion
     */
    public int vuln577(int value, int bits) {
        return value >>> bits; // Zero-fill can be incorrect for signed
    }
    
    /**
     * vuln578: Bit mask calculation
     */
    public int vuln578(int position) {
        return 1 << position; // Undefined for position >= 32
    }
    
    /**
     * vuln579: Negative array size
     */
    public int[] vuln579(int size) {
        return new int[size]; // Can be negative
    }
    
    /**
     * vuln580: Off-by-one in loop
     */
    public int vuln580(int[] array) {
        int sum = 0;
        for (int i = 0; i <= array.length; i++) { // Off-by-one
            sum += array[i];
        }
        return sum;
    }
    
    /**
     * vuln581: Incorrect bounds check
     */
    public boolean vuln581(int index, int size) {
        return index <= size; // Should be index < size
    }
    
    /**
     * vuln582: Integer promotion issue
     */
    public long vuln582(int a, int b) {
        return a * b; // Multiplication happens as int, then promoted
    }
    
    /**
     * vuln583: Incorrect sign handling
     */
    public int vuln583(int value) {
        return Math.abs(value); // Integer.MIN_VALUE stays negative
    }
    
    /**
     * vuln584: Wraparound in increment
     */
    public int vuln584(int counter) {
        return counter + 1; // Can wrap to negative
    }
    
    /**
     * vuln585: Incorrect range check
     */
    public boolean vuln585(int value, int min, int max) {
        return value >= min && value <= max; // What if min > max?
    }
    
    /**
     * vuln586: Pointer arithmetic simulation
     */
    public int vuln586(int base, int offset, int size) {
        return base + offset * size; // Can overflow
    }
    
    /**
     * vuln587: Incorrect alignment calculation
     */
    public int vuln587(int size, int alignment) {
        return (size + alignment - 1) / alignment * alignment; // Can overflow
    }
    
    /**
     * vuln588: Hash code calculation
     */
    public int vuln588(String s) {
        int hash = 0;
        for (char c : s.toCharArray()) {
            hash = hash * 31 + c; // Can overflow
        }
        return hash;
    }
    
    /**
     * vuln589: Timeout calculation
     */
    public long vuln589(int seconds) {
        return System.currentTimeMillis() + seconds * 1000; // Can overflow
    }
    
    /**
     * vuln590: Memory size calculation
     */
    public long vuln590(int count, int itemSize) {
        return count * itemSize; // Overflow before promotion to long
    }
}
