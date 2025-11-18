package com.example.vulnerable;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * LDAP Injection vulnerabilities
 * CWE-90: Improper Neutralization of Special Elements used in an LDAP Query
 */
public class LDAPInjection {
    
    private DirContext ctx;
    
    public LDAPInjection() throws Exception {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        ctx = new InitialDirContext(env);
    }
    
    public NamingEnumeration<SearchResult> searchUser(String username) throws Exception {
        // VULNERABILITY: LDAP Injection - unsanitized user input
        String filter = "(uid=" + username + ")";
        return ctx.search("ou=users,dc=example,dc=com", filter, null);
    }
    
    public NamingEnumeration<SearchResult> authenticateUser(String user, String pass) throws Exception {
        // VULNERABILITY: LDAP Injection in authentication
        String filter = "(&(uid=" + user + ")(userPassword=" + pass + "))";
        return ctx.search("ou=people,dc=example,dc=com", filter, null);
    }
    
    public void findByEmail(String email) throws Exception {
        // VULNERABILITY: LDAP Injection
        String searchFilter = "(mail=" + email + ")";
        ctx.search("dc=example,dc=com", searchFilter, null);
    }
    
    public NamingEnumeration<SearchResult> complexSearch(String dept, String role) throws Exception {
        // VULNERABILITY: Multiple injection points
        String filter = "(&(department=" + dept + ")(role=" + role + "))";
        return ctx.search("ou=employees,dc=company,dc=com", filter, null);
    }
    
    public void searchByAttribute(String attrName, String attrValue) throws Exception {
        // VULNERABILITY: Dynamic LDAP filter construction
        String filter = "(" + attrName + "=" + attrValue + ")";
        ctx.search("dc=example,dc=com", filter, null);
    }
}
