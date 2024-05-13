package com.soundbar91.helloSpringBoot.controller;

import com.soundbar91.helloSpringBoot.dto.People;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @GetMapping("/json")
    public People json() {
        return new People("신관규", 24);
    }
}
