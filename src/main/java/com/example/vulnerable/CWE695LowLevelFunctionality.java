package com.example.vulnerable;

import sun.misc.Unsafe;
import java.lang.reflect.*;
import java.nio.*;

/**
 * CWE-695: Use of Low-Level Functionality
 * 
 * Direct use of low-level functionality that bypasses normal security
 * mechanisms and can lead to undefined behavior, memory corruption, or
 * security vulnerabilities.
 */
public class CWE695LowLevelFunctionality {
    
    /**
     * vuln661: Direct use of sun.misc.Unsafe
     */
    public long vuln661() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.allocateMemory(1024); // Direct memory allocation
    }
    
    /**
     * vuln662: Unsafe memory access
     */
    public void vuln662(long address, byte value) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.putByte(address, value); // Direct memory write
    }
    
    /**
     * vuln663: DirectByteBuffer manipulation
     */
    public void vuln663() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        Field addressField = Buffer.class.getDeclaredField("address");
        addressField.setAccessible(true);
        long address = addressField.getLong(buffer);
        // Direct access to buffer's native memory
    }
    
    /**
     * vuln664: JNI native method declaration
     */
    public native void vuln664(String data); // Native code can bypass security
    
    /**
     * vuln665: Reflection to access private fields
     */
    public Object vuln665(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true); // Bypass access control
        return field.get(obj);
    }
    
    /**
     * vuln666: Reflection to invoke private methods
     */
    public Object vuln666(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true); // Bypass access control
        return method.invoke(obj);
    }
    
    /**
     * vuln667: Class loader manipulation
     */
    public Class<?> vuln667(byte[] classBytes) throws Exception {
        ClassLoader cl = new ClassLoader() {
            public Class<?> loadClass(byte[] bytes) {
                return defineClass(null, bytes, 0, bytes.length);
            }
        };
        return cl.loadClass(classBytes); // Load arbitrary bytecode
    }
    
    /**
     * vuln668: Unsafe object instantiation
     */
    public Object vuln668(Class<?> clazz) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.allocateInstance(clazz); // Bypass constructor
    }
    
    /**
     * vuln669: Direct memory comparison
     */
    public boolean vuln669(long addr1, long addr2, long size) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        for (long i = 0; i < size; i++) {
            if (unsafe.getByte(addr1 + i) != unsafe.getByte(addr2 + i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * vuln670: Unsafe CAS operation
     */
    public boolean vuln670(Object obj, long offset, int expected, int value) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.compareAndSwapInt(obj, offset, expected, value);
    }
    
    /**
     * vuln671: Direct memory copy
     */
    public void vuln671(long srcAddr, long destAddr, long size) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.copyMemory(srcAddr, destAddr, size); // No bounds checking
    }
    
    /**
     * vuln672: Accessing internal JVM structures
     */
    public long vuln672(Object obj) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.objectFieldOffset(obj.getClass().getDeclaredField("value"));
    }
    
    /**
     * vuln673: Manipulating final fields
     */
    public void vuln673(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(obj, value); // Modify final field
    }
    
    /**
     * vuln674: Stack manipulation via reflection
     */
    public void vuln674() throws Exception {
        Class<?> stackWalkerClass = Class.forName("java.lang.StackWalker");
        Method getInstance = stackWalkerClass.getDeclaredMethod("getInstance");
        getInstance.setAccessible(true);
        // Access stack frames
    }
    
    /**
     * vuln675: Unsafe array manipulation
     */
    public void vuln675(Object[] array, int index, Object value) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        long scale = unsafe.arrayIndexScale(Object[].class);
        unsafe.putObject(array, baseOffset + index * scale, value); // No bounds check
    }
    
    /**
     * vuln676: Native memory leak
     */
    public long vuln676(int size) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.allocateMemory(size); // Never freed
    }
    
    /**
     * vuln677: Unsafe class casting
     */
    public <T> T vuln677(Object obj, Class<T> clazz) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        // Unsafe cast without type checking
        return (T) obj;
    }
    
    /**
     * vuln678: Direct thread manipulation
     */
    public void vuln678(Thread thread) throws Exception {
        Field eetop = Thread.class.getDeclaredField("eetop");
        eetop.setAccessible(true);
        // Access internal thread structure
    }
    
    /**
     * vuln679: Unsafe volatile operations
     */
    public void vuln679(Object obj, long offset, int value) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.putIntVolatile(obj, offset, value); // Direct volatile write
    }
    
    /**
     * vuln680: Park/unpark thread manipulation
     */
    public void vuln680(Thread thread) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.unpark(thread); // Direct thread control
    }
    
    /**
     * vuln681: Unsafe fence operations
     */
    public void vuln681() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.loadFence(); // Low-level memory barrier
    }
    
    /**
     * vuln682: Direct class redefinition
     */
    public void vuln682(Class<?> clazz, byte[] newClassBytes) throws Exception {
        // Attempt to redefine class at runtime
        java.lang.instrument.Instrumentation instr = null; // Would need agent
        // instr.redefineClasses(...);
    }
    
    /**
     * vuln683: Accessing module internals
     */
    public void vuln683() throws Exception {
        Module module = Object.class.getModule();
        Field implClass = Module.class.getDeclaredField("descriptor");
        implClass.setAccessible(true);
        // Access module internals
    }
    
    /**
     * vuln684: Unsafe monitor operations
     */
    public void vuln684(Object obj) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.monitorEnter(obj);
        // Manual lock without proper unlock
    }
    
    /**
     * vuln685: Direct page size access
     */
    public int vuln685() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.pageSize(); // Access system page size
    }
    
    /**
     * vuln686: Unsafe array allocation
     */
    public Object vuln686(Class<?> componentType, int length) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe.allocateInstance(Array.newInstance(componentType, 0).getClass());
    }
    
    /**
     * vuln687: Direct field offset calculation
     */
    public long vuln687(Class<?> clazz, String fieldName) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        Field field = clazz.getDeclaredField(fieldName);
        return unsafe.objectFieldOffset(field);
    }
    
    /**
     * vuln688: Unsafe throw exception
     */
    public void vuln688(Throwable t) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.throwException(t); // Throw checked exception without declaration
    }
    
    /**
     * vuln689: Direct static field access
     */
    public Object vuln689(Class<?> clazz, String fieldName) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        Field field = clazz.getDeclaredField(fieldName);
        Object base = unsafe.staticFieldBase(field);
        long offset = unsafe.staticFieldOffset(field);
        return unsafe.getObject(base, offset);
    }
    
    /**
     * vuln690: Unsafe class initialization
     */
    public void vuln690(Class<?> clazz) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        unsafe.ensureClassInitialized(clazz); // Force class initialization
    }
}
