package com.kalpesh.service;

import java.util.concurrent.Callable;

public class SampleCallableServiceWithResult implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("callable thread with response name is: "+Thread.currentThread().getName());
        Thread.sleep(5*1000);
        return "success";
    }
}
