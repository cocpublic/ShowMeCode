package com.tany.show.thread;

/**
 * 调试 ThreadLocal
 */
public class ThreadLocalDemo {


    public static void main(final String[] args) {

        final ThreadLocal<String> localName = new ThreadLocal<>();
        localName.set("demo");
        final String name = localName.get();
    }
}
