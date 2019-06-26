package com.kalpesh.controller;


import com.kalpesh.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {


    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/async")
    public ResponseEntity createProduct() throws Exception {
        sampleService.createProduct();
        sampleService.sendEMail();
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/callable")
    public ResponseEntity createProductUsingCallable() throws Exception {
        sampleService.createProduct();
        sampleService.sendEmailWithCallable();
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/callable/result")
    public ResponseEntity<String> createProductUsingCallableAndGetData() throws Exception{
        sampleService.createProduct();
        String response = sampleService.sendEmailWithCallableAndReturnResponse();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(value = "/async/result")
    public ResponseEntity<String> createProductUsingAsyncAndGetData() throws Exception{
        sampleService.createProduct();
        String response = sampleService.sendEmailWithAsyncAndReturnResponse();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
