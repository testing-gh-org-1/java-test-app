package com.example.vulnerable;

import java.util.regex.*;

/**
 * Regular Expression Denial of Service (ReDoS) vulnerabilities
 * CWE-1333: Inefficient Regular Expression Complexity
 */
public class RegexDoS {
    
    public boolean validateEmail(String email) {
        // VULNERABILITY: Catastrophic backtracking
        String regex = "(a+)+b";
        return Pattern.matches(regex, email);
    }
    
    public boolean validateInput(String input) {
        // VULNERABILITY: Nested quantifiers
        String regex = "(a*)*b";
        return input.matches(regex);
    }
    
    public String extractData(String data) {
        // VULNERABILITY: Exponential time complexity
        Pattern pattern = Pattern.compile("(a|a)*b");
        Matcher matcher = pattern.matcher(data);
        return matcher.find() ? matcher.group() : null;
    }
    
    public boolean checkPattern(String text) {
        // VULNERABILITY: Overlapping alternations
        String regex = "(a|ab)*c";
        return Pattern.compile(regex).matcher(text).matches();
    }
    
    public boolean validateURL(String url) {
        // VULNERABILITY: Complex nested groups
        String regex = "^(https?://)?([a-z0-9]+\\.)*[a-z0-9]+\\.[a-z]+(/.)*$";
        return url.matches(regex);
    }
    
    public void splitWithRegex(String input) {
        // VULNERABILITY: Dangerous split pattern
        String[] parts = input.split("(a+)+");
        System.out.println(parts.length);
    }
    
    public boolean validateJSON(String json) {
        // VULNERABILITY: Inefficient pattern
        String regex = "\\{(\\s*\"[^\"]+\"\\s*:\\s*\"[^\"]+\"\\s*,?\\s*)*\\}";
        return json.matches(regex);
    }
}
