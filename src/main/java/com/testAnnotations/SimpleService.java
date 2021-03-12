package com.testAnnotations;

import com.annotations.Init;
import com.annotations.Service;

@Service(name = "superSimpleService")
public class SimpleService {
    @Init
    public void initService() {
        System.out.println(SimpleService.class + " : " + "method initService()...");
    }

    public void alalaal() {
        System.out.println("blablabla");
    }
}
