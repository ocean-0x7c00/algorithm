package org.linkedlist;

public class ProjectContext {
    static ThreadLocal<String> local = new ThreadLocal<>();


    private ProjectContext() {
    }

    public static String getString() {
        return local.get();
    }

    public static void setString(String value) {
        local.set(value);
    }
}
