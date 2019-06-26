package com.kalpesh.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class SampleAsyncServiceWithResult {

    @Async("processExecutor")
    public Future<String> getAsyncWithResult() throws Exception {
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());

        Thread.sleep(5 * 1000);
        System.out.println("slept till now");
        return new AsyncResult<>("hello world !!!!");

    }
}
