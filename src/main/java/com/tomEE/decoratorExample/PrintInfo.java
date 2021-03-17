package com.tomEE.decoratorExample;

public class PrintInfo implements Printer{
    @Override
    public void print() {
        System.out.println("Print Info");
    }
}
