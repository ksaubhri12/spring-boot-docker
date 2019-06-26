package com.kalpesh.service;

import com.kalpesh.requestBody.StatusRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Component
public class SampleService {

    @Autowired
    private SampleAsyncServiceWithResult sampleAsyncServiceWithResult;

    public void createProduct()throws Exception{
        System.out.println("product created");
        System.out.println("createProductThread is:"+Thread.currentThread().getName());

    }

    @Async("processExecutor")
    public void sendEMail()throws Exception{
        System.out.println("emailSendingAsyncThreadname is:"+Thread.currentThread().getName());
        for (int i=0; i<50000; i++) {
            Thread.sleep(1);
        }
        for (int i=0; i<50000; i++) {
            Thread.sleep(1);
        }

    }


    public void sendEmailWithCallable() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10,
                new CustomizableThreadFactory("callable-thread-group"));
        executorService.submit(new SampleCallableService());
        System.out.println("Email send in callable fashion");

    }

    public String sendEmailWithCallableAndReturnResponse() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10,
                new CustomizableThreadFactory("callable-response-thread-group"));
        Future future = executorService.submit(new SampleCallableServiceWithResult());
        System.out.println("Email send in callable fashion with response");
        return String.valueOf(future.get());
    }

    public String sendEmailWithAsyncAndReturnResponse() throws Exception{
        System.out.println("Invoking an asynchronous method. "
                + Thread.currentThread().getName());
        Future<String> future = sampleAsyncServiceWithResult.getAsyncWithResult();

        return "hello";

    }


}
