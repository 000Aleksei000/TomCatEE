package com.tomEE.specializationExample;

import jakarta.enterprise.inject.Specializes;

@Specializes
public class C extends B{
    @Override
    public void print() {
        System.out.println("Hello from " + C.class);
    }
}
