package com.example.vulnerable;

import java.lang.reflect.*;

/**
 * Reflection Abuse - CRITICAL
 * CWE-470: Use of Externally-Controlled Input to Select Classes or Code
 */
public class ReflectionAbuse {
    
    public Object createInstanceByName(String className) throws Exception {
        // CRITICAL: Arbitrary class instantiation
        Class<?> clazz = Class.forName(className);
        return clazz.getDeclaredConstructor().newInstance();
    }
    
    public Object invokeMethodByName(Object obj, String methodName, Object... args) 
            throws Exception {
        // CRITICAL: Arbitrary method invocation
        Class<?>[] paramTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = args[i].getClass();
        }
        Method method = obj.getClass().getMethod(methodName, paramTypes);
        return method.invoke(obj, args);
    }
    
    public void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        // CRITICAL: Arbitrary field modification
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
    
    public Object getFieldValue(Object obj, String fieldName) throws Exception {
        // CRITICAL: Arbitrary field access
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
    
    public void loadAndExecuteClass(String className, String methodName) throws Exception {
        // CRITICAL: Dynamic class loading and execution
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass(className);
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(instance);
    }
    
    public Object invokeStaticMethod(String className, String methodName) throws Exception {
        // CRITICAL: Static method invocation
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod(methodName);
        return method.invoke(null);
    }
}
