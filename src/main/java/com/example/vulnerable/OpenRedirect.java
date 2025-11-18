package com.example.vulnerable;

import javax.servlet.http.*;
import java.io.IOException;

/**
 * Open Redirect vulnerabilities
 * CWE-601: URL Redirection to Untrusted Site
 */
public class OpenRedirect {
    
    public void redirectToUserURL(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // VULNERABILITY: Unvalidated redirect
        String url = request.getParameter("redirect");
        response.sendRedirect(url);
    }
    
    public void redirectAfterLogin(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // VULNERABILITY: Open redirect in login flow
        String returnUrl = request.getParameter("returnUrl");
        response.sendRedirect(returnUrl);
    }
    
    public void forwardToPage(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // VULNERABILITY: Unvalidated forward
        String page = request.getParameter("page");
        response.sendRedirect("/" + page);
    }
    
    public void redirectWithHeader(HttpServletRequest request, HttpServletResponse response) {
        // VULNERABILITY: Location header injection
        String target = request.getParameter("target");
        response.setHeader("Location", target);
        response.setStatus(302);
    }
    
    public String generateRedirectHTML(String url) {
        // VULNERABILITY: Client-side redirect
        return "<html><head><meta http-equiv='refresh' content='0;url=" + url + "'></head></html>";
    }
}
