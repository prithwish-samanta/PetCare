package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.PetTypeMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // Get a pet type by ID
    @GetMapping("/{petTypeId}")
    public ResponseEntity<PetTypeDto> getPetType(@PathVariable int petTypeId) {
        PetType petType = clinicService.findPetTypeById(petTypeId);
        if (petType == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDto(petType), HttpStatus.OK);
    }
}
