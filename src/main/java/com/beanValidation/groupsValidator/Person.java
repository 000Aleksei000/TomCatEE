package com.beanValidation.groupsValidator;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

public class Person {
    @NotNull(groups = Group1.class)
    String s1;
    @NotNull(groups = {Group1.class, Group2.class})
    String s2;
    @NotNull(groups = Group3.class)
    String s3;
    @NotNull (groups = Default.class)
    String s4;
}


interface Group1{}
interface Group2{}
interface Group3{}
interface Group4{}
