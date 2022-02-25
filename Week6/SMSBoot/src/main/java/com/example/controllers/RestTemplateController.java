package com.example.controllers;

import com.example.models.GenericPost;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    //Make a normal get request with rest template
    @GetMapping("/get")
    public ResponseEntity<String> restTemplateGet(){
        RestTemplate rest = new RestTemplate();

        String url = "https://jsonplaceholder.typicode.com/posts";

        ResponseEntity<String> res = rest.getForEntity(url, String.class);

        return res;
    }

    //Create a post request with exchange
    @PostMapping("/exchange")
    public GenericPost restTemplateExchange(@RequestBody GenericPost p){
        RestTemplate rest = new RestTemplate();

        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpEntity<GenericPost> request = new HttpEntity<GenericPost>(p);

        return rest.exchange(url, HttpMethod.POST, request, GenericPost.class).getBody();
    }

    //Create a post request with forObject
    @PostMapping("/post")
    public GenericPost restTemplatePost(@RequestBody GenericPost p){
        RestTemplate rest = new RestTemplate();

        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpEntity<GenericPost> request = new HttpEntity<GenericPost>(p);

        return rest.postForObject(url, request, GenericPost.class);
    }

}
