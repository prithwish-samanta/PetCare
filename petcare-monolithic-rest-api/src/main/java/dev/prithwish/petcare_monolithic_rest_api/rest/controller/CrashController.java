package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.rest.api.CrashApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CrashController implements CrashApi {
    @Override
    public ResponseEntity<String> failingRequest() {
        throw new RuntimeException("This endpoint is used to showcase what happens when an exception is thrown");
    }
}
