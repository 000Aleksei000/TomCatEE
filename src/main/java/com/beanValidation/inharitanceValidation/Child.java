package com.beanValidation.inharitanceValidation;

public class Child extends Person{
    void setName(String name) {
        this.name  = name;
    }

    String getName() {
        return name;
    }
}
