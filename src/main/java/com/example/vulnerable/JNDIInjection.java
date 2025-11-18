package com.example.vulnerable;

import javax.naming.*;
import java.util.Hashtable;

/**
 * JNDI Injection - CRITICAL
 * CWE-917: JNDI Injection can lead to RCE
 */
public class JNDIInjection {
    
    public Object lookupObject(String userInput) throws Exception {
        // CRITICAL: JNDI Injection vulnerability (Log4Shell style)
        Context ctx = new InitialContext();
        return ctx.lookup(userInput);
    }
    
    public void lookupResource(String resourceName) throws Exception {
        // CRITICAL: Unsafe JNDI lookup
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        Context context = new InitialContext(env);
        context.lookup(resourceName);
    }
    
    public Object getRMIObject(String rmiUrl) throws Exception {
        // CRITICAL: RMI JNDI lookup with user input
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, rmiUrl);
        Context ctx = new InitialContext(env);
        return ctx.lookup("RemoteObject");
    }
    
    public void logUserInput(String input) throws Exception {
        // CRITICAL: Logging with potential JNDI injection
        Context ctx = new InitialContext();
        Object obj = ctx.lookup("java:comp/env/" + input);
        System.out.println("Lookup result: " + obj);
    }
    
    public Object getLDAPObject(String ldapQuery) throws Exception {
        // CRITICAL: LDAP JNDI injection
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapQuery);
        Context ctx = new InitialContext(env);
        return ctx.lookup("");
    }
}
