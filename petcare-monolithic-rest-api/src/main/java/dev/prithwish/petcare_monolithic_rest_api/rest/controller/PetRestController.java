package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.PetMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetReqDto;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetResDto;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/pets")
public class PetRestController {
    private final ClinicService clinicService;
    private final MessageSource messageSource;

    public PetRestController(ClinicService clinicService, MessageSource messageSource) {
        this.clinicService = clinicService;
        this.messageSource = messageSource;
    }

    // Lists pet
    @GetMapping
    public ResponseEntity<List<PetResDto>> listPets() {
        List<Pet> pets = clinicService.findAllPets();
        return new ResponseEntity<>(PetMapper.toPetDtoList(pets), HttpStatus.OK);
    }

    // Create a pet
    @PostMapping
    public ResponseEntity<PetResDto> addPet(@RequestBody @Valid PetReqDto pet) {
        Pet petToAdd = PetMapper.toPet(pet);
        PetType petType = clinicService.findPetTypeByName(pet.getPetType());
        if (petType == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        petToAdd.setType(petType);
        Pet savedPet = clinicService.savePet(petToAdd);
        return new ResponseEntity<>(PetMapper.toPetDto(savedPet), HttpStatus.CREATED);
    }

    // Get a pet by ID
    @GetMapping("/{petId}")
    public ResponseEntity<PetResDto> getPet(@PathVariable int petId) {
        Pet pet = clinicService.findPetById(petId);
        if (pet == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pet.not.found", null, Locale.ENGLISH));
        }
        return new ResponseEntity<>(PetMapper.toPetDto(pet), HttpStatus.OK);
    }

    // Update a pet by ID
    @PutMapping("/{petId}")
    public ResponseEntity<PetResDto> updatePet(@PathVariable int petId, @RequestBody PetReqDto pet) {
        Pet dbPet = clinicService.findPetById(petId);
        if (dbPet == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pet.not.found", null, Locale.ENGLISH));
        }
        if (StringUtils.hasText(pet.getName())) {
            dbPet.setName(pet.getName());
        }
        if (pet.getBirthDate() != null) {
            dbPet.setBirthDate(pet.getBirthDate());
        }
        if (StringUtils.hasText(pet.getPetType())) {
            PetType petType = clinicService.findPetTypeByName(pet.getPetType());
            if (petType == null) {
                throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
            }
            dbPet.setType(petType);
        }
        Pet savedPet = clinicService.savePet(dbPet);
        return new ResponseEntity<>(PetMapper.toPetDto(savedPet), HttpStatus.OK);
    }

    // Delete a pet by ID
    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable int petId) {
        Pet pet = clinicService.findPetById(petId);
        if (pet == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pet.not.found", null, Locale.ENGLISH));
        }
        clinicService.deletePetById(petId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}