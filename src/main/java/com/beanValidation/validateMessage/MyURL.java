package com.beanValidation.validateMessage;

import com.beanValidation.customValidator.CheckSiteUrl;

public class MyURL {
    @CheckSiteUrl(port = 22 )
    String url;
}
