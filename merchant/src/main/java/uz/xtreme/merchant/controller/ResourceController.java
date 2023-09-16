package uz.xtreme.merchant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.xtreme.merchant.error.Message;

@RestController
public class ResourceController {
    @GetMapping(value = "/admin")
    public ResponseEntity<Message> helloAdmin(){
        return new ResponseEntity<>(new Message(true, "Hello from Admin"), HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Message> helloUser(){
        return new ResponseEntity<>(new Message(true, "Hello from User"), HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }

}
