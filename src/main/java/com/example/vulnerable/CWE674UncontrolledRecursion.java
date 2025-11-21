package com.example.vulnerable;

import java.util.*;

/**
 * CWE-674: Uncontrolled Recursion
 * 
 * Recursive methods without proper termination conditions or depth limits
 * that can lead to stack overflow and denial of service.
 */
public class CWE674UncontrolledRecursion {
    
    /**
     * vuln511: Infinite recursion without base case
     */
    public int vuln511(int n) {
        return vuln511(n - 1); // No base case
    }
    
    /**
     * vuln512: Recursion with user-controlled depth
     */
    public int vuln512(int depth) {
        if (depth > 0) {
            return vuln512(depth - 1); // No maximum depth check
        }
        return 0;
    }
    
    /**
     * vuln513: Mutual recursion without limits
     */
    public void vuln513(int n) {
        vuln513Helper(n);
    }
    
    private void vuln513Helper(int n) {
        vuln513(n - 1); // Mutual recursion, no limit
    }
    
    /**
     * vuln514: Factorial without overflow check
     */
    public long vuln514(int n) {
        if (n <= 1) return 1;
        return n * vuln514(n - 1); // Can cause stack overflow for large n
    }
    
    /**
     * vuln515: Fibonacci without memoization or depth limit
     */
    public int vuln515(int n) {
        if (n <= 1) return n;
        return vuln515(n - 1) + vuln515(n - 2); // Exponential recursion
    }
    
    /**
     * vuln516: Tree traversal without cycle detection
     */
    public void vuln516(TreeNode node) {
        if (node == null) return;
        vuln516(node.left);
        vuln516(node.right); // No cycle detection
    }
    
    /**
     * vuln517: List traversal without visited tracking
     */
    public void vuln517(ListNode node) {
        if (node == null) return;
        vuln517(node.next); // No cycle detection
    }
    
    /**
     * vuln518: Graph traversal without depth limit
     */
    public void vuln518(GraphNode node) {
        if (node == null) return;
        for (GraphNode neighbor : node.neighbors) {
            vuln518(neighbor); // No visited set or depth limit
        }
    }
    
    /**
     * vuln519: String processing with uncontrolled recursion
     */
    public String vuln519(String s) {
        if (s.isEmpty()) return "";
        return s.charAt(0) + vuln519(s.substring(1)); // No length check
    }
    
    /**
     * vuln520: Nested data structure processing
     */
    public void vuln520(Object obj) {
        if (obj instanceof List) {
            for (Object item : (List<?>) obj) {
                vuln520(item); // No depth limit
            }
        }
    }
    
    // Helper classes
    static class TreeNode {
        TreeNode left, right;
    }
    
    static class ListNode {
        ListNode next;
    }
    
    static class GraphNode {
        List<GraphNode> neighbors = new ArrayList<>();
    }
}
