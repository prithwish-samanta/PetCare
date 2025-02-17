package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerRestController {
    // Adds a pet owner
    @PostMapping
    public ResponseEntity<OwnerResDto> addOwner(@RequestBody OwnerReqDto owner) {
        return null;
    }

    // Lists pet owners
    @GetMapping
    public ResponseEntity<List<OwnerResDto>> listOwners(@RequestParam(required = false) String lastName) {
        return null;
    }

    // Get a pet owner by ID
    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerResDto> getOwner(@PathVariable int ownerId) {
        return null;
    }

    // Update a pet owner's details
    @PutMapping("/{ownerId}")
    public ResponseEntity<OwnerResDto> updateOwner(@RequestBody OwnerReqDto owner, @PathVariable int ownerId) {
        return null;
    }

    // Delete an owner by ID
    @DeleteMapping("/{ownerId}")
    public ResponseEntity<OwnerResDto> deleteOwner(@PathVariable int ownerId) {
        return null;
    }

    // Adds a pet to an owner
    @PostMapping("/{ownerId}/pets")
    public ResponseEntity<PetResDto> addPetToOwner(@PathVariable int ownerId, @RequestBody PetReqDto pet) {
        return null;
    }

    // Get a pet by ID
    @GetMapping("/{ownerId}/pets/{petId}")
    public ResponseEntity<PetResDto> getOwnersPet(@PathVariable int ownerId, @PathVariable int petId) {
        return null;
    }

    // Update a pet's details
    @PutMapping("/{ownerId}/pets/{petId}")
    public ResponseEntity<String> updateOwnersPet(@PathVariable int ownerId, @PathVariable int petId, @RequestBody PetReqDto pet) {
        return null;
    }

    // Adds a vet visit
    @PostMapping("/{ownerId}/pets/{petId}/visits")
    public ResponseEntity<VisitResDto> addVisitToOwner(@PathVariable int ownerId, @PathVariable int petId, @RequestBody VisitResDto visit) {
        return null;
    }
}
