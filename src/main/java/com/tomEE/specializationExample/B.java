package com.tomEE.specializationExample;

public class B implements A{
    @Override
    public void print() {
        System.out.println("HelloWorld in " + B.class);
    }
}
