package com.beanValidation.customValidator;

import jakarta.validation.ConstraintViolation;

public class ClazzForValidate {
    @CheckSiteUrl
    String site;
    @CheckSiteUrl(protocol = "http")
    String site2;
    @CheckSiteUrl(host = "mysite.com")
    String site3;
    @CheckSiteUrl(protocol = "ftp", port = 21)
    String site4;
}
