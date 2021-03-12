package com.testAnnotations;

import com.annotations.Init;
import com.annotations.Service;

@Service(name = "very Lazy service")
public class LazyService {
    @Init
    public void lazyService() throws Exception {
        System.out.println(LazyService.class + " : " + "method lazyService()...");
    }

    public void blabla() {
        System.out.println("blablabla");
    }
}
