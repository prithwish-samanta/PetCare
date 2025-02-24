package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.OwnerMapper;
import dev.prithwish.petcare_monolithic_rest_api.mapper.PetMapper;
import dev.prithwish.petcare_monolithic_rest_api.mapper.VisitMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.Owner;
import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.model.Visit;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.*;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "*")
public class OwnerRestController {
    private final ClinicService clinicService;
    private final MessageSource messageSource;

    public OwnerRestController(ClinicService clinicService, MessageSource messageSource) {
        this.clinicService = clinicService;
        this.messageSource = messageSource;
    }

    // Adds a pet owner
    @PostMapping
    public ResponseEntity<OwnerResDto> addOwner(@RequestBody @Valid OwnerReqDto owner) {
        Owner req = OwnerMapper.toOwner(owner);
        OwnerResDto dto = OwnerMapper.toOwnerDto(clinicService.saveOwner(req));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.newInstance().path("/owners/{ownerId}").buildAndExpand(dto.getId()).toUri());
        return new ResponseEntity<>(dto, headers, HttpStatus.CREATED);
    }

    // Lists pet owners
    @GetMapping
    public ResponseEntity<List<OwnerResDto>> listOwners(@RequestParam(required = false) String lastName) {
        List<Owner> owners;
        if (lastName != null) {
            owners = clinicService.findOwnerByLastName(lastName);
        } else {
            owners = clinicService.findAllOwners();
        }
        if (owners.isEmpty()) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.list.empty", null, Locale.ENGLISH));
        }
        List<OwnerResDto> res = owners.stream().map(OwnerMapper::toOwnerDto).toList();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // Get a pet owner by ID
    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerResDto> getOwner(@PathVariable int ownerId) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        OwnerResDto dto = OwnerMapper.toOwnerDto(owner);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // Update a pet owner's details
    @PutMapping("/{ownerId}")
    public ResponseEntity<OwnerResDto> updateOwner(@RequestBody @Valid OwnerReqDto owner, @PathVariable int ownerId) {
        Owner dbOwner = clinicService.findOwnerById(ownerId);
        if (dbOwner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        if (StringUtils.hasText(owner.getLastName())) {
            dbOwner.setLastName(owner.getLastName());
        }
        if (StringUtils.hasText(owner.getFirstName())) {
            dbOwner.setFirstName(owner.getFirstName());
        }
        if (StringUtils.hasText(owner.getAddress())) {
            dbOwner.setAddress(owner.getAddress());
        }
        if (StringUtils.hasText(owner.getCity())) {
            dbOwner.setCity(owner.getCity());
        }
        if (StringUtils.hasText(owner.getTelephone())) {
            dbOwner.setTelephone(owner.getTelephone());
        }
        Owner savedOwner = clinicService.saveOwner(dbOwner);
        return new ResponseEntity<>(OwnerMapper.toOwnerDto(savedOwner), HttpStatus.OK);
    }

    // Delete an owner by ID
    @DeleteMapping("/{ownerId}")
    public ResponseEntity<Void> deleteOwner(@PathVariable int ownerId) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        clinicService.deleteOwner(ownerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Adds a pet to an owner
    @PostMapping("/{ownerId}/pets")
    public ResponseEntity<PetResDto> addPetToOwner(@PathVariable int ownerId, @RequestBody @Valid PetReqDto pet) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        PetType petType = clinicService.findPetTypeByName(pet.getPetType());
        if (petType == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pettype.not.found", null, Locale.ENGLISH));
        }
        Pet petToAdd = PetMapper.toPet(pet);
        petToAdd.setOwner(owner);
        petToAdd.setType(petType);
        Pet savedPet = clinicService.savePet(petToAdd);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.newInstance().path("/owners/{ownerId}/pets/{petId}").buildAndExpand(ownerId, savedPet.getId()).toUri());

        return new ResponseEntity<>(PetMapper.toPetDto(savedPet), headers, HttpStatus.CREATED);
    }

    // Get a pet by ID
    @GetMapping("/{ownerId}/pets/{petId}")
    public ResponseEntity<PetResDto> getOwnersPet(@PathVariable int ownerId, @PathVariable int petId) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        Pet res = owner.getPet(petId);
        if (res == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pet.not.found", null, Locale.ENGLISH));
        }
        return new ResponseEntity<>(PetMapper.toPetDto(res), HttpStatus.OK);
    }

    // Update a pet's details
    @PutMapping("/{ownerId}/pets/{petId}")
    public ResponseEntity<String> updateOwnersPet(@PathVariable int ownerId, @PathVariable int petId, @RequestBody @Valid PetReqDto pet) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        Pet dbPet = owner.getPet(petId);
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
        clinicService.savePet(dbPet);
        return new ResponseEntity<>(messageSource.getMessage("api.response.pet.update.successful", null, Locale.ENGLISH), HttpStatus.OK);
    }

    // Adds a vet visit
    @PostMapping("/{ownerId}/pets/{petId}/visits")
    public ResponseEntity<VisitResDto> addVisitToOwner(@PathVariable int ownerId, @PathVariable int petId, @RequestBody @Valid VisitReqDto visit) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        Pet pet = owner.getPet(petId);
        if (pet == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pet.not.found", null, Locale.ENGLISH));
        }
        Visit req = VisitMapper.toVisit(visit);
        req.setPet(pet);
        Visit savedVisit = clinicService.saveVisit(req);
        return new ResponseEntity<>(VisitMapper.toVisitResDto(savedVisit), HttpStatus.CREATED);
    }
}
