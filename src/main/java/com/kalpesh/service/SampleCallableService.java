package com.kalpesh.service;

import java.util.concurrent.Callable;

public class SampleCallableService implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        System.out.println("emailSendingCallableThreadname is:" + Thread.currentThread().getName());
        for (int i = 0; i < 5000; i++) {
            Thread.sleep(1);
        }
        for (int i = 0; i < 5000; i++) {
            Thread.sleep(1);
        }
        return null;

    }
}

