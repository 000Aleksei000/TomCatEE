package com.tomEE.DecoratorExample;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Decorated;
import jakarta.inject.Inject;

@Decorator
public class DecoratorPrintInfo implements Printer{
    @Inject
    @Delegate
    Printer printer;

    @Override
    public void print() {
        System.out.println("Before printer");
        printer.print();
        System.out.println("After printer");
    }
}
