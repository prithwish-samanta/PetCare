package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrashController {
    // Always fails
    @GetMapping("/oops")
    public ResponseEntity<String> triggerException() {
        throw new RuntimeException("This endpoint is used to showcase what happens when an exception is thrown");
    }
}
