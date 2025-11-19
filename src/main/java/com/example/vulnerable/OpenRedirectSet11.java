package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * Open Redirect - Set 11
 * CWE-601: URL Redirection to Untrusted Site
 */
public class OpenRedirectSet11 {
    
    public void vuln101(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("url"));
    }
    
    public void vuln102(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("next"));
    }
    
    public void vuln103(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("redirect"));
    }
    
    public void vuln104(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("returnUrl"));
    }
    
    public void vuln105(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("target"));
    }
    
    public void vuln106(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getParameter("goto");
        resp.sendRedirect(url);
    }
    
    public void vuln107(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.setHeader("Location", req.getParameter("location"));
        resp.setStatus(302);
    }
    
    public void vuln108(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("continue"));
    }
    
    public void vuln109(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("callback"));
    }
    
    public void vuln110(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(req.getParameter("destination"));
    }
}
