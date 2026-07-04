package com.example.testSetup.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.*;
import software.amazon.awssdk.services.lambda.model.Runtime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LambdaService {

    private final LambdaClient lambdaClient;

    public LambdaService(LambdaClient lambdaClient){
        this.lambdaClient =lambdaClient;
    }

    public void testConnection() {
        ListFunctionsResponse response = lambdaClient.listFunctions();
        System.out.println("repsonse is "+response);
        response.functions().forEach(function ->
                System.out.println(function.functionName()));
    }


    public boolean createLambdaClient() throws IOException {
       // byte jarBytes[] = Files.readAllBytes(Paths.get("target/testSetup.jar"));
        byte[] jarBytes = Files.readAllBytes(
                Paths.get("target/testSetup-0.0.1-SNAPSHOT.jar"));
        FunctionCode functionCode = FunctionCode.builder()
                .zipFile(SdkBytes.fromByteArray(jarBytes))
                .build();

        CreateFunctionRequest functionRequest = CreateFunctionRequest.builder()
                .functionName("firstFunctionFromCode")
                .runtime(Runtime.JAVA21)
                .handler("com.example.testSetup.lambdaCreation.MyFirstLambda::handleRequest")
                .role("arn:aws:iam::346064759756:role/LambdaExecutionRole")
                .code(functionCode)
                .timeout(30)
                .memorySize(512)
                .build();


        CreateFunctionResponse createFunctionResponse = lambdaClient.createFunction(functionRequest);
        System.out.println("craete function responee "+ createFunctionResponse.functionArn());
        return true;
    }
}
