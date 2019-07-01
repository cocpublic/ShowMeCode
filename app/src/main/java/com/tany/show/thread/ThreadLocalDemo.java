package com.tany.show.thread;

/**
 * 调试 ThreadLocal
 */
public class ThreadLocalDemo {


    public static void main(String[] args) {

        ThreadLocal<String> localName = new ThreadLocal<>();
        localName.set("demo");
        String name = localName.get();
    }
}
