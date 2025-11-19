package com.example.vulnerable;

import javax.script.*;

/**
 * Code Injection - Set 16
 * CWE-94: Code Injection
 */
public class CodeInjectionSet16 {
    
    private ScriptEngineManager manager = new ScriptEngineManager();
    
    public void vuln151(String code) throws Exception {
        manager.getEngineByName("JavaScript").eval(code);
    }
    
    public void vuln152(String script) throws Exception {
        manager.getEngineByName("js").eval(script);
    }
    
    public void vuln153(String expr) throws Exception {
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(expr);
    }
    
    public void vuln154(String code) throws Exception {
        ScriptEngine js = manager.getEngineByName("nashorn");
        js.eval(code);
    }
    
    public void vuln155(String script) throws Exception {
        new ScriptEngineManager().getEngineByName("JavaScript").eval(script);
    }
    
    public Object vuln156(String className) throws Exception {
        return Class.forName(className).newInstance();
    }
    
    public Object vuln157(String cls) throws Exception {
        return Class.forName(cls).getDeclaredConstructor().newInstance();
    }
    
    public void vuln158(String code) throws Exception {
        manager.getEngineByName("groovy").eval(code);
    }
    
    public void vuln159(String expression) throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        sem.getEngineByName("js").eval(expression);
    }
    
    public Object vuln160(String name) throws Exception {
        return Class.forName(name).newInstance();
    }
}
