package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VisitReqDto;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VisitResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitRestController {
    // Lists visits
    @GetMapping
    public ResponseEntity<List<VisitResDto>> listVisits() {
        return null;
    }

    // Create a visit
    @PostMapping
    public ResponseEntity<VisitResDto> addVisit(@RequestBody VisitReqDto visit) {
        return null;
    }

    // Get a visit by ID
    @GetMapping("/{visitId}")
    public ResponseEntity<VisitResDto> getVisit(@PathVariable int visitId) {
        return null;
    }

    // Update a visit by ID
    @PutMapping("/{visitId}")
    public ResponseEntity<VisitResDto> updateVisit(@PathVariable int visitId, @RequestBody VisitReqDto visit) {
        return null;
    }

    // Delete a visit by ID
    @DeleteMapping("/{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable int visitId) {
        return null;
    }

}