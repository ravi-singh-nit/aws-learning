package com.example.testSetup.controller;


import com.example.testSetup.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

@RestController
@RequestMapping("/api/v1/s3")
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public String uploadPic(@RequestParam MultipartFile file){
        System.out.println("received file upload for "+file.getOriginalFilename() + "of size "+file.getSize());
        return s3Service.uploadFileToS3(file);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(){
        byte []imageByte = s3Service.download();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageByte);
    }


    @PostMapping("/uploadJar")
    public String uploadJar(){
        System.out.println("Uploading my spring boot jar to s3");
        int k=1;
        //very expensive opertaion min 110 MB upload to s3
        if(k!=1) {
           // s3Service.uploadJar();
        }
        return "Spring boot jar uploaded jar successfully";
    }
}
