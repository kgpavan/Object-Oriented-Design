package com.sourcemaking.singleton.thread_safe_singleton;

/**
 * University of Maryland Computer Science researcher Bill Pugh has written about
 * the code issues underlying the Singleton pattern when implemented in Java.
 * Pugh's efforts on the "Double-checked locking" idiom led to changes in the Java
 * memory model in Java 5 and to what is generally regarded as the standard method
 * to implement Singletons in Java. The technique is known as the initialization
 * on demand holder idiom, is as lazy as possible, and works in all known versions
 * of Java. It takes advantage of language guarantees about class initialization,
 * and will therefore work correctly in all Java-compliant compilers and virtual
 * machines.
 * The inner class is referenced no earlier (and therefore loaded no earlier by
 * the class loader) than the moment that getInstance() is called.
 */

public final class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
