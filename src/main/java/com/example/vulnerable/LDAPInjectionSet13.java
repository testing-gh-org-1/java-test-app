package com.example.vulnerable;

import javax.naming.*;
import java.util.Hashtable;

/**
 * LDAP Injection - Set 13
 * CWE-90: LDAP Injection
 */
public class LDAPInjectionSet13 {
    
    private DirContext ctx;
    
    public LDAPInjectionSet13() throws Exception {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        ctx = new InitialDirContext(env);
    }
    
    public void vuln121(String user) throws Exception {
        ctx.search("dc=example,dc=com", "(uid=" + user + ")", null);
    }
    
    public void vuln122(String email) throws Exception {
        ctx.search("ou=users,dc=com", "(mail=" + email + ")", null);
    }
    
    public void vuln123(String name) throws Exception {
        ctx.search("dc=org", "(cn=" + name + ")", null);
    }
    
    public void vuln124(String filter) throws Exception {
        ctx.search("dc=example,dc=com", filter, null);
    }
    
    public void vuln125(String username) throws Exception {
        String searchFilter = "(sAMAccountName=" + username + ")";
        ctx.search("dc=domain,dc=com", searchFilter, null);
    }
    
    public void vuln126(String group) throws Exception {
        ctx.search("ou=groups,dc=com", "(memberOf=" + group + ")", null);
    }
    
    public void vuln127(String dept) throws Exception {
        ctx.search("dc=company", "(department=" + dept + ")", null);
    }
    
    public void vuln128(String phone) throws Exception {
        ctx.search("ou=people", "(telephoneNumber=" + phone + ")", null);
    }
    
    public void vuln129(String attr, String value) throws Exception {
        ctx.search("dc=test", "(" + attr + "=" + value + ")", null);
    }
    
    public void vuln130(String dn) throws Exception {
        ctx.lookup(dn);
    }
}
