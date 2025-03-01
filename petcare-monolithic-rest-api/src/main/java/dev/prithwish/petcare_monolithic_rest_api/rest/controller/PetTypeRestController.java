package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.PetTypeMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.rest.api.PetTypesApi;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "*")
public class PetTypeRestController implements PetTypesApi {
    private final ClinicService clinicService;
    private final MessageSource messageSource;

    public PetTypeRestController(ClinicService clinicService, MessageSource messageSource) {
        this.clinicService = clinicService;
        this.messageSource = messageSource;
    }

    @Override
    public ResponseEntity<List<PetTypeDto>> listPetTypes() {
        List<PetType> petTypes = clinicService.findAllPetTypes();
        if (petTypes == null || petTypes.isEmpty()) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.list.empty", null, Locale.ENGLISH));
        }
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDtoList(petTypes), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PetTypeDto> getPetType(int petTypeId) {
        PetType petType = clinicService.findPetTypeById(petTypeId);
        if (petType == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        return new ResponseEntity<>(PetTypeMapper.toPetTypeDto(petType), HttpStatus.OK);
    }
}
