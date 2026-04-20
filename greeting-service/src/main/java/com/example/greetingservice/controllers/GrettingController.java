package com.example.greetingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GrettingController {

    @GetMapping({"", "/", "/{namePath"})
    public ResponseEntity<String> getGreeting(
            @RequestParam(required = false) String name,
            @PathVariable(required = false) String namePath
    ){
        if (name == null){
            name = namePath != null ? namePath : "World";
        }

        String retorno = String.format("%s %s!!!", "Hello", name);
        return ResponseEntity.ok(retorno);
    }
}
