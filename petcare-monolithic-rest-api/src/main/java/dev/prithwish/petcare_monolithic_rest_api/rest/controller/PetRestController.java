package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetReqDto;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetRestController {
    // Lists pet
    @GetMapping
    public ResponseEntity<List<PetResDto>> listPets() {
        return null;
    }

    // Create a pet
    @PostMapping
    public ResponseEntity<PetResDto> addPet(@RequestBody PetReqDto pet) {
        return null;
    }

    // Get a pet by ID
    @GetMapping("/{petId}")
    public ResponseEntity<PetResDto> getPet(@PathVariable int petId) {
        return null;
    }

    // Update a pet by ID
    @PutMapping("/{petId}")
    public ResponseEntity<PetResDto> updatePet(@PathVariable int petId, @RequestBody PetReqDto pet) {
        return null;
    }

    // Delete a pet by ID
    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable int petId) {
        return null;
    }
}