package com.example.vulnerable;

import javax.servlet.http.*;

/**
 * XSS - Set 29
 */
public class XSSSet29 {
    
    public void vuln281(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().write(req.getParameter("p1"));
    }
    
    public void vuln282(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().print(req.getParameter("p2"));
    }
    
    public void vuln283(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().println(req.getParameter("p3"));
    }
    
    public void vuln284(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String v = req.getParameter("p4");
        resp.getWriter().write(v);
    }
    
    public void vuln285(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String v = req.getParameter("p5");
        resp.getWriter().print(v);
    }
    
    public void vuln286(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().write("<div>" + req.getParameter("p6") + "</div>");
    }
    
    public void vuln287(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().write("<p>" + req.getParameter("p7") + "</p>");
    }
    
    public void vuln288(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().write("<span>" + req.getParameter("p8") + "</span>");
    }
    
    public void vuln289(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().write("Value: " + req.getParameter("p9"));
    }
    
    public void vuln290(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.getWriter().write("Result: " + req.getParameter("p10"));
    }
}
