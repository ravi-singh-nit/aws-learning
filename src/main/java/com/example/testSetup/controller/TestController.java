package com.example.testSetup.controller;

import com.example.testSetup.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    RestClient restClient;

    @GetMapping("/greet")
    public String getString(){
       PostDTO post = restClient.get()
                .uri("https://jsonplaceholder.typicode.com//posts/{id}",2)
                .retrieve()
                .body(PostDTO.class);
        System.out.println("post is "+post);

      //        throw new RuntimeException("my exeprtion");
        return "Hello World + running latest build ";
    }

    @GetMapping("/test/{id}")
    public String getPathParam(@PathVariable int id, @RequestParam long sec){
        return "path param is "+id + "and request param is "+ sec;
    }

}
