package com.example.vulnerable;

import javax.script.*;
import java.lang.reflect.*;

/**
 * Code Injection vulnerabilities
 * CWE-94: Improper Control of Generation of Code
 * CWE-95: Improper Neutralization of Directives in Dynamically Evaluated Code
 */
public class CodeInjection {
    
    public Object evaluateExpression(String expression) throws Exception {
        // VULNERABILITY: Script injection
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        return engine.eval(expression);
    }
    
    public void executeGroovyScript(String script) throws Exception {
        // VULNERABILITY: Groovy code injection
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("groovy");
        engine.eval(script);
    }
    
    public Object invokeMethod(String className, String methodName) throws Exception {
        // VULNERABILITY: Reflection with user input
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod(methodName);
        return method.invoke(clazz.newInstance());
    }
    
    public Object createInstance(String className) throws Exception {
        // VULNERABILITY: Dynamic class instantiation
        return Class.forName(className).newInstance();
    }
    
    public void evaluateJavaScript(String code) throws ScriptException {
        // VULNERABILITY: JavaScript eval
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("nashorn");
        engine.eval(code);
    }
    
    public Object executeExpression(String expr) throws Exception {
        // VULNERABILITY: Expression Language injection
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        return engine.eval("result = " + expr);
    }
}
