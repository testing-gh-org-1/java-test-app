package com.example.vulnerable;

/**
 * Server-Side Template Injection - CRITICAL
 * CWE-1336: Template Injection
 */
public class TemplateInjection {
    
    public String renderTemplate(String userInput) {
        // CRITICAL: Direct template evaluation with user input
        String template = "<html><body><h1>Welcome, ${" + userInput + "}</h1></body></html>";
        return evaluateTemplate(template);
    }
    
    private String evaluateTemplate(String template) {
        // Simulates template engine evaluation
        return template;
    }
    
    public String processVelocityTemplate(String userInput) {
        // CRITICAL: Velocity template injection
        String template = "#set($input = " + userInput + ")\nResult: $input";
        return template;
    }
    
    public String processFreeMarkerTemplate(String userInput) {
        // CRITICAL: FreeMarker template injection
        String template = "<#assign data = " + userInput + ">${data}";
        return template;
    }
    
    public String renderThymeleafTemplate(String userInput) {
        // CRITICAL: Thymeleaf template injection
        String template = "<div th:text=\"${" + userInput + "}\"></div>";
        return template;
    }
    
    public String evaluateExpression(String expression) {
        // CRITICAL: Expression Language injection
        return "${" + expression + "}";
    }
    
    public String renderUserContent(String content) {
        // CRITICAL: Direct content rendering
        return "<script>var data = '" + content + "';</script>";
    }
}
