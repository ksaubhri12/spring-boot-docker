package com.kalpesh.controller;

import com.kalpesh.requestBody.StatusRequestBody;
import com.kalpesh.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@RestController
public class StatusController {

    @Autowired
    private StatusService statusService;


    @PostMapping("/status")
    public Callable<Object> getStatus(@RequestBody StatusRequestBody statusRequestBody)  {
        try {
            return () -> {return statusService.getStatus(statusRequestBody);};
        }
        catch (Exception e){
            return () -> { return "Some error occurred" + e.getMessage(); };
        }


    }
}
