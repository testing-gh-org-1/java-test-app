package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * Trust Boundary Violation vulnerabilities
 * CWE-501: Trust Boundary Violation
 */
public class TrustBoundaryViolation {
    
    public void storeUserInputInSession(HttpServletRequest request, HttpSession session) {
        // VULNERABILITY: Untrusted data in session
        String userInput = request.getParameter("data");
        session.setAttribute("userData", userInput);
    }
    
    public void storeRequestInSession(HttpServletRequest request, HttpSession session) {
        // VULNERABILITY: Request object in session
        session.setAttribute("request", request);
    }
    
    public void cacheUserInput(HttpServletRequest request) {
        // VULNERABILITY: User input in static cache
        String input = request.getParameter("query");
        Cache.put("userQuery", input);
    }
    
    public void setGlobalState(HttpServletRequest request) {
        // VULNERABILITY: User data in global state
        String value = request.getParameter("config");
        GlobalConfig.setValue(value);
    }
    
    public void storeInApplication(HttpServletRequest request, HttpServletContext context) {
        // VULNERABILITY: Request data in application scope
        String data = request.getParameter("appData");
        context.setAttribute("sharedData", data);
    }
    
    static class Cache {
        private static java.util.Map<String, Object> cache = new java.util.HashMap<>();
        static void put(String key, Object value) { cache.put(key, value); }
    }
    
    static class GlobalConfig {
        private static String value;
        static void setValue(String v) { value = v; }
    }
}
