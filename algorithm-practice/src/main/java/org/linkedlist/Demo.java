package org.linkedlist;

public class Demo {
    public static void main(String[] args) {
        ProjectContext.setString("hllooo");
        System.out.println(Thread.currentThread().getName() + " " + ProjectContext.getString());
        new Thread(() -> {
            ProjectContext.setString("hllooo");
            System.out.println(Thread.currentThread().getName() + " " + ProjectContext.getString());
        },"t2").start();


        while (true){

        }
    }
}
