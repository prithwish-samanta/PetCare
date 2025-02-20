package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceAlreadyExistsException;
import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.PetTypeMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/pettypes")
public class PetTypeRestController {
    private final ClinicService clinicService;
    private final MessageSource messageSource;

    public PetTypeRestController(ClinicService clinicService, MessageSource messageSource) {
        this.clinicService = clinicService;
        this.messageSource = messageSource;
    }

    // Lists pet types
    @GetMapping
    public ResponseEntity<List<PetTypeDto>> listPetTypes() {
        List<PetType> petTypes = clinicService.findAllPetTypes();
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDtoList(petTypes), HttpStatus.OK);
    }

    // Create a pet type
    @PostMapping
    public ResponseEntity<PetTypeDto> addPetType(@RequestBody @Valid PetTypeDto petType) {
        if (clinicService.findPetTypeByName(petType.getName()) != null) {
            throw new ResourceAlreadyExistsException(messageSource.getMessage("api.error.pettype.already.exists", null, Locale.ENGLISH));
        }
        PetType savedPetType = clinicService.savePetType(PetTypeMapper.toPetType(petType));
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDto(savedPetType), HttpStatus.CREATED);
    }

    // Get a pet type by ID
    @GetMapping("/{petTypeId}")
    public ResponseEntity<PetTypeDto> getPetType(@PathVariable int petTypeId) {
        PetType petType = clinicService.findPetTypeById(petTypeId);
        if (petType == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDto(petType), HttpStatus.OK);
    }

    // Update a pet type by ID
    @PutMapping("/{petTypeId}")
    public ResponseEntity<PetTypeDto> updatePetType(@PathVariable int petTypeId, @RequestBody @Valid PetTypeDto petType) {
        PetType type = clinicService.findPetTypeById(petTypeId);
        if (type == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        if (clinicService.findPetTypeByName(petType.getName()) != null) {
            throw new ResourceAlreadyExistsException(messageSource.getMessage("api.error.pettype.already.exists", null, Locale.ENGLISH));
        }
        type.setName(petType.getName());
        PetType savedPetType = clinicService.savePetType(type);
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDto(savedPetType), HttpStatus.OK);
    }

    // Delete a pet type by ID
    @DeleteMapping("/{petTypeId}")
    public ResponseEntity<Void> deletePetType(@PathVariable int petTypeId) {
        PetType type = clinicService.findPetTypeById(petTypeId);
        if (type == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        clinicService.deletePetType(petTypeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
