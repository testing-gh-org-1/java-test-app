package com.example.vulnerable;

/**
 * CWE-681: Incorrect Conversion between Numeric Types
 * 
 * Incorrect casting or conversion between numeric types that can lead to
 * data loss, overflow, underflow, or unexpected behavior.
 */
public class CWE681IncorrectConversion {
    
    /**
     * vuln541: Long to int conversion with potential overflow
     */
    public int vuln541(long value) {
        return (int) value; // Can lose high-order bits
    }
    
    /**
     * vuln542: Double to int conversion with truncation
     */
    public int vuln542(double value) {
        return (int) value; // Loses fractional part
    }
    
    /**
     * vuln543: Float to byte conversion
     */
    public byte vuln543(float value) {
        return (byte) value; // Severe data loss
    }
    
    /**
     * vuln544: Int to short conversion
     */
    public short vuln544(int value) {
        return (short) value; // Can overflow
    }
    
    /**
     * vuln545: Int to byte conversion
     */
    public byte vuln545(int value) {
        return (byte) value; // Significant data loss
    }
    
    /**
     * vuln546: Long to float conversion
     */
    public float vuln546(long value) {
        return (float) value; // Can lose precision
    }
    
    /**
     * vuln547: Double to float conversion
     */
    public float vuln547(double value) {
        return (float) value; // Can lose precision
    }
    
    /**
     * vuln548: Unsigned int simulation gone wrong
     */
    public int vuln548(long unsignedInt) {
        return (int) unsignedInt; // Loses sign information
    }
    
    /**
     * vuln549: Char to byte conversion
     */
    public byte vuln549(char c) {
        return (byte) c; // Loses high byte
    }
    
    /**
     * vuln550: Array index from long
     */
    public int vuln550(long index) {
        return (int) index; // Array access with potentially overflowed index
    }
    
    /**
     * vuln551: String to int without validation
     */
    public int vuln551(String s) {
        return Integer.parseInt(s); // Can throw NumberFormatException
    }
    
    /**
     * vuln552: String to byte without range check
     */
    public byte vuln552(String s) {
        return Byte.parseByte(s); // Can overflow
    }
    
    /**
     * vuln553: Narrowing conversion in loop
     */
    public byte[] vuln553(int[] values) {
        byte[] result = new byte[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = (byte) values[i]; // Narrowing in loop
        }
        return result;
    }
    
    /**
     * vuln554: Sign extension issue
     */
    public int vuln554(byte b) {
        return b; // Sign extends, -1 becomes -1 not 255
    }
    
    /**
     * vuln555: Unsigned to signed conversion
     */
    public long vuln555(int value) {
        return value; // Sign extension for negative values
    }
    
    /**
     * vuln556: Float to long conversion
     */
    public long vuln556(float f) {
        return (long) f; // Loses fractional part
    }
    
    /**
     * vuln557: Double to long conversion
     */
    public long vuln557(double d) {
        return (long) d; // Loses fractional part
    }
    
    /**
     * vuln558: Boolean to int conversion
     */
    public int vuln558(boolean b) {
        return b ? 1 : 0; // Information loss in reverse
    }
    
    /**
     * vuln559: Pointer-like conversion
     */
    public int vuln559(Object obj) {
        return System.identityHashCode(obj); // Not a true pointer
    }
    
    /**
     * vuln560: Time conversion with overflow
     */
    public int vuln560(long milliseconds) {
        return (int) (milliseconds / 1000); // Can overflow for large values
    }
}
