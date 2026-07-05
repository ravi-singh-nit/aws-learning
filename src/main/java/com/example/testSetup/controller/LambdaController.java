package com.example.testSetup.controller;

import com.example.testSetup.service.LambdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/lambda")
public class LambdaController {

    @Autowired
    LambdaService lambdaService;

    @GetMapping("/test")
    public String test(){
        System.out.println("testing lmbda connection");
        lambdaService.testConnection();
        return "working fine";
    }

    @PostMapping("/create")
    public String createLambdaFunction() throws IOException {
        System.out.println("creating  lmbda function ");
        lambdaService.createLambdaClient();
        return "Lambda function created successfully";
    }

    @PostMapping("/invoke")
    public String invokeLambda(){
        System.out.println("executing lambda from code");
        lambdaService.executeLambda();
        return "lambda execution completed";
    }
}
