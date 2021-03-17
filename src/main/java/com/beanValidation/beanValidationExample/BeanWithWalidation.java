package com.beanValidation.beanValidationExample;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BeanWithWalidation {
    @Pattern(regexp = "[A-Z][a-z]*")
    String name;
    @NotNull
    @Min(18)
    int age;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }
}
