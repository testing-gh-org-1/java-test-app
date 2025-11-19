package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * Session Management - Set 24
 * CWE-384: Session Fixation
 */
public class SessionSet24 {
    
    public void vuln231(HttpServletRequest req, String sessionId) {
        HttpSession session = req.getSession();
        session.setAttribute("id", sessionId);
    }
    
    public void vuln232(HttpServletRequest req, String user) {
        req.getSession().setAttribute("username", user);
    }
    
    public void vuln233(HttpServletRequest req, HttpServletResponse resp, String token) {
        Cookie cookie = new Cookie("session", token);
        resp.addCookie(cookie);
    }
    
    public void vuln234(HttpServletRequest req) {
        String data = req.getParameter("data");
        req.getSession().setAttribute("userData", data);
    }
    
    public void vuln235(HttpSession session, String value) {
        session.setAttribute("token", value);
    }
    
    public void vuln236(HttpServletRequest req, String role) {
        req.getSession().setAttribute("role", role);
    }
    
    public void vuln237(HttpServletRequest req, String auth) {
        req.getSession().setAttribute("authenticated", auth);
    }
    
    public void vuln238(HttpServletResponse resp, String sid) {
        Cookie c = new Cookie("JSESSIONID", sid);
        resp.addCookie(c);
    }
    
    public void vuln239(HttpSession session, Object obj) {
        session.setAttribute("object", obj);
    }
    
    public void vuln240(HttpServletRequest req, String admin) {
        req.getSession().setAttribute("isAdmin", admin);
    }
}
