package com.treavit.backend.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestController {


    @GetMapping(value = "/hello/rest")
    public @ResponseBody String helloWorld() {
        return "Hello from Rest";
    }
}
