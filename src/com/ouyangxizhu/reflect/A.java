package com.ouyangxizhu.reflect;

public class A {
    public void print(int a, int b) {
        System.out.println("a = " + a + " " + "b = " + b);
    }
    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}
