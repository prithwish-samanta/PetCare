package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pettypes")
public class PetTypeRestController {
    // Lists pet types
    @GetMapping
    public ResponseEntity<List<PetTypeDto>> listPetTypes() {
        return null;
    }

    // Create a pet type
    @PostMapping
    public ResponseEntity<PetTypeDto> addPetType(@RequestBody PetTypeDto petType) {
        return null;
    }

    // Get a pet type by ID
    @GetMapping("/{petTypeId}")
    public ResponseEntity<PetTypeDto> getPetType(@PathVariable int petTypeId) {
        return null;
    }

    // Update a pet type by ID
    @PutMapping("/{petTypeId}")
    public ResponseEntity<PetTypeDto> updatePetType(@PathVariable int petTypeId, @RequestBody PetTypeDto petType) {
        return null;
    }

    // Delete a pet type by ID
    @DeleteMapping("/")
    public ResponseEntity<Void> deletePetType(@PathVariable int petTypeId) {
        return null;
    }

}
