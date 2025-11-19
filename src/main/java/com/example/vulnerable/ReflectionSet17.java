package com.example.vulnerable;

import java.lang.reflect.*;

/**
 * Reflection Abuse - Set 17
 * CWE-470: Use of Externally-Controlled Input
 */
public class ReflectionSet17 {
    
    public Object vuln161(String className) throws Exception {
        return Class.forName(className).newInstance();
    }
    
    public Object vuln162(Object obj, String method) throws Exception {
        return obj.getClass().getMethod(method).invoke(obj);
    }
    
    public void vuln163(Object obj, String fieldName, Object value) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }
    
    public Object vuln164(String cls) throws Exception {
        return Class.forName(cls).getDeclaredConstructor().newInstance();
    }
    
    public Object vuln165(Object target, String methodName) throws Exception {
        Method m = target.getClass().getMethod(methodName);
        return m.invoke(target);
    }
    
    public void vuln166(String className, String method) throws Exception {
        Class<?> clazz = Class.forName(className);
        clazz.getMethod(method).invoke(clazz.newInstance());
    }
    
    public Object vuln167(Object obj, String field) throws Exception {
        Field f = obj.getClass().getDeclaredField(field);
        f.setAccessible(true);
        return f.get(obj);
    }
    
    public void vuln168(String cls, String mtd) throws Exception {
        Class.forName(cls).getMethod(mtd).invoke(null);
    }
    
    public Object vuln169(String className) throws Exception {
        return ClassLoader.getSystemClassLoader().loadClass(className).newInstance();
    }
    
    public void vuln170(Object o, String m, Object[] args) throws Exception {
        o.getClass().getMethod(m).invoke(o, args);
    }
}
