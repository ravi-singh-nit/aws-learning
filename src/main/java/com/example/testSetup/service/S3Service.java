package com.example.testSetup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Paths;


@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    private final String bucketName = "smy-lambda-artifacts-bucket-ravi-123";

    public String uploadFileToS3(MultipartFile multipartFile){

        String key = "myPic/"+multipartFile.getOriginalFilename();
        try{
            System.out.println("going to upload to s3");
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .contentType(multipartFile.getContentType())
                            .build(),
                    RequestBody.fromBytes(multipartFile.getBytes())
            );
            return "file uploaded successfully to S3";

        }catch (Exception e){
            System.out.println("Error : failed to upload to s3");
            throw new RuntimeException("File upload failed due to "+e.getMessage());
        }
    }

    public byte[] download(){
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key("myPic/1000090172.png")
                .build();

        ResponseBytes<GetObjectResponse> objectBytes =s3Client.getObjectAsBytes(getObjectRequest);
        return objectBytes.asByteArray();
    }

    public  String uploadJar(){
        String key = "myPic/"+"myApp.jar";
        try{
            System.out.println("going to my appJar upload to s3");
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .contentType("application/java-archive")
                            .build(),
                    RequestBody.fromFile(Paths.get("target/testSetup-0.0.1-SNAPSHOT.jar"))
            );
            return "file uploaded successfully to S3";

        }catch (Exception e){
            System.out.println("Error : failed to upload to s3");
            throw new RuntimeException("File upload failed due to "+e.getMessage());
        }
    }
}
