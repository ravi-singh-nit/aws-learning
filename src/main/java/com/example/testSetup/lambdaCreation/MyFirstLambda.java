package com.example.testSetup.lambdaCreation;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyFirstLambda implements RequestHandler<String,String> {
    @Override
    public String handleRequest(String input, Context context) {
        System.out.println("Hello my lambda fucntion deployed from code");
        return "hello "+input;
    }
}
