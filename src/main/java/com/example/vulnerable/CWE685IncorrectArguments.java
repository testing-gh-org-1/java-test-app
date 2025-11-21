package com.example.vulnerable;

import java.util.*;
import java.text.*;

/**
 * CWE-685: Function Call With Incorrect Number of Arguments
 * 
 * Calling functions with wrong number or type of arguments, often through
 * reflection, varargs misuse, or format string vulnerabilities.
 */
public class CWE685IncorrectArguments {
    
    /**
     * vuln591: Printf with mismatched arguments
     */
    public void vuln591(int value) {
        System.out.printf("%s %d %f", value); // Expects 3 args, got 1
    }
    
    /**
     * vuln592: Format string with wrong argument count
     */
    public String vuln592(String name) {
        return String.format("Hello %s, you are %d years old", name); // Missing age
    }
    
    /**
     * vuln593: MessageFormat with mismatched arguments
     */
    public String vuln593(String arg1) {
        return MessageFormat.format("Value: {0}, {1}, {2}", arg1); // Expects 3 args
    }
    
    /**
     * vuln594: Reflection call with wrong argument count
     */
    public void vuln594(Object obj, String methodName) throws Exception {
        obj.getClass().getMethod(methodName).invoke(obj, "arg1", "arg2"); // May need different args
    }
    
    /**
     * vuln595: Varargs with single array argument
     */
    public void vuln595(String[] array) {
        vuln595Helper(array); // Passes array as single arg instead of spreading
    }
    
    private void vuln595Helper(String... args) {
        // Expected multiple strings, got array
    }
    
    /**
     * vuln596: Constructor reflection with wrong args
     */
    public Object vuln596(Class<?> clazz) throws Exception {
        return clazz.getConstructor(String.class).newInstance(); // Missing String arg
    }
    
    /**
     * vuln597: Method reference with wrong signature
     */
    public void vuln597(List<String> list) {
        list.forEach(System.out::println); // Works, but if signature changes...
    }
    
    /**
     * vuln598: PreparedStatement with wrong parameter count
     */
    public void vuln598(java.sql.PreparedStatement ps) throws Exception {
        ps.setString(1, "value");
        ps.execute(); // SQL may expect more parameters
    }
    
    /**
     * vuln599: Format with wrong type
     */
    public void vuln599(String value) {
        System.out.printf("%d", value); // %d expects int, got String
    }
    
    /**
     * vuln600: Arrays.asList with primitive array
     */
    public List<Integer> vuln600(int[] array) {
        return Arrays.asList(array); // Creates List<int[]> not List<Integer>
    }
    
    /**
     * vuln601: String.format with locale and wrong args
     */
    public String vuln601(Locale locale) {
        return String.format(locale, "%s %d", "test"); // Missing second arg
    }
    
    /**
     * vuln602: Logger with wrong number of args
     */
    public void vuln602() {
        // Simulating: logger.debug("User {} logged in from {}", username);
        System.out.println(String.format("User %s logged in from %s", "user")); // Missing IP
    }
    
    /**
     * vuln603: Callback with wrong signature
     */
    public void vuln603(Runnable callback) {
        callback.run(); // What if callback expects arguments?
    }
    
    /**
     * vuln604: Event handler with wrong parameters
     */
    public void vuln604(Object handler) throws Exception {
        handler.getClass().getMethod("onEvent").invoke(handler, "arg"); // Method may not expect arg
    }
    
    /**
     * vuln605: Function composition with mismatched types
     */
    public void vuln605(java.util.function.Function<String, Integer> f1,
                        java.util.function.Function<Integer, String> f2) {
        // f1.andThen(f2) works, but type mismatch in usage
        String result = f1.andThen(f2).apply(123); // Wrong input type
    }
    
    /**
     * vuln606: Collection.toArray with wrong array size
     */
    public String[] vuln606(Collection<String> collection) {
        return collection.toArray(new String[0]); // Size mismatch (though this actually works)
    }
    
    /**
     * vuln607: Method handle with wrong arguments
     */
    public void vuln607(java.lang.invoke.MethodHandle mh) throws Throwable {
        mh.invoke("arg1", "arg2"); // May expect different number/types
    }
    
    /**
     * vuln608: Annotation processor with wrong element count
     */
    public void vuln608(Object[] elements) {
        processElements(elements[0], elements[1]); // What if array has different size?
    }
    
    private void processElements(Object e1, Object e2) {
        // Process elements
    }
    
    /**
     * vuln609: Stream reduce with wrong combiner
     */
    public void vuln609(List<String> list) {
        list.stream().reduce("", (a, b) -> a + b, (a, b) -> a); // Wrong combiner signature
    }
    
    /**
     * vuln610: Custom format with mismatched arguments
     */
    public String vuln610(Object... args) {
        String template = "Value1: %s, Value2: %s, Value3: %s";
        return String.format(template, args); // args.length may not match placeholders
    }
    
    /**
     * vuln691: Reflection method invoke with wrong args
     */
    public Object vuln691(Object target, String methodName, Object... args) throws Exception {
        Method m = target.getClass().getMethod(methodName, String.class, int.class);
        return m.invoke(target, args); // args may not match String, int signature
    }
    
    /**
     * vuln692: Constructor call with missing parameters
     */
    public Object vuln692(Class<?> clazz, Object arg1) throws Exception {
        return clazz.getConstructor(String.class, int.class, boolean.class)
                    .newInstance(arg1); // Missing int and boolean parameters
    }
    
    /**
     * vuln693: Logging with insufficient parameters
     */
    public void vuln693(String user, String action) {
        String format = "User {} performed action {} at {} from IP {}";
        System.out.println(String.format(format, user, action)); // Missing timestamp and IP
    }
    
    /**
     * vuln694: SQL prepared statement with wrong param count
     */
    public void vuln694(java.sql.Connection conn, String name) throws Exception {
        java.sql.PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO users (name, email, age) VALUES (?, ?, ?)"
        );
        ps.setString(1, name); // Missing email and age
        ps.execute();
    }
    
    /**
     * vuln695: Variadic function with array instead of elements
     */
    public void vuln695(String format, String[] args) {
        System.out.printf(format, (Object) args); // Passes array as single object
    }
    
    /**
     * vuln696: Method handle invocation with wrong signature
     */
    public void vuln696(java.lang.invoke.MethodHandle mh, Object arg) throws Throwable {
        mh.invoke(arg); // May expect multiple arguments
    }
    
    /**
     * vuln697: Lambda with wrong parameter count
     */
    public void vuln697(java.util.function.BiFunction<String, Integer, String> func) {
        // func.apply("test"); // Would fail - needs 2 args
    }
    
    /**
     * vuln698: Stream collector with wrong combiner
     */
    public void vuln698(java.util.stream.Stream<String> stream) {
        stream.collect(
            () -> new StringBuilder(),
            (sb, s) -> sb.append(s),
            (sb1, sb2) -> {} // Wrong combiner - should append sb2 to sb1
        );
    }
    
    /**
     * vuln699: Annotation with missing required elements
     */
    @interface MyAnnotation {
        String value();
        int count();
    }
    
    // @MyAnnotation("test") // Missing count parameter
    public void vuln699() {}
    
    /**
     * vuln700: Builder pattern with incomplete parameters
     */
    public Object vuln700() {
        return new StringBuilder()
            .append("test")
            // Missing other required method calls
            .toString();
    }
}
