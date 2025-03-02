package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.OwnerMapper;
import dev.prithwish.petcare_monolithic_rest_api.mapper.PetMapper;
import dev.prithwish.petcare_monolithic_rest_api.mapper.VisitMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.Owner;
import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.model.Visit;
import dev.prithwish.petcare_monolithic_rest_api.rest.api.OwnersApi;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.*;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "*")
public class OwnerRestController implements OwnersApi {
    private final ClinicService clinicService;
    private final MessageSource messageSource;

    public OwnerRestController(ClinicService clinicService, MessageSource messageSource) {
        this.clinicService = clinicService;
        this.messageSource = messageSource;
    }

    @Override
    public ResponseEntity<OwnerResDto> addOwner(OwnerReqDto owner) {
        Owner req = OwnerMapper.toOwner(owner);
        OwnerResDto dto = OwnerMapper.toOwnerDto(clinicService.saveOwner(req));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.newInstance().path("/owners/{ownerId}").buildAndExpand(dto.getId()).toUri());
        return new ResponseEntity<>(dto, headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<OwnerResDto>> listOwners(String lastName) {
        List<Owner> owners;
        if (lastName != null) {
            owners = clinicService.findOwnerByLastName(lastName);
        } else {
            owners = clinicService.findAllOwners();
        }
        if (owners == null || owners.isEmpty()) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.list.empty", null, Locale.ENGLISH));
        }
        List<OwnerResDto> res = owners.stream().map(OwnerMapper::toOwnerDto).toList();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OwnerResDto> getOwner(int ownerId) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        OwnerResDto dto = OwnerMapper.toOwnerDto(owner);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OwnerResDto> updateOwner(OwnerReqDto owner, int ownerId) {
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

    @Override
    public ResponseEntity<Void> deleteOwner(int ownerId) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        clinicService.deleteOwner(ownerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<PetResDto> addPetToOwner(int ownerId, PetReqDto pet) {
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

    @Override
    public ResponseEntity<PetResDto> getOwnersPet(int ownerId, int petId) {
        Owner owner = fetchOwnerById(ownerId);
        Pet res = fetchPet(owner, petId);
        return new ResponseEntity<>(PetMapper.toPetDto(res), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateOwnersPet(int ownerId, int petId, PetReqDto pet) {
        Owner owner = fetchOwnerById(ownerId);
        Pet dbPet = fetchPet(owner, petId);
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

    @Override
    public ResponseEntity<VisitResDto> addVisitToOwner(int ownerId, int petId, VisitReqDto visit) {
        Owner owner = fetchOwnerById(ownerId);
        Pet pet = fetchPet(owner, petId);
        Visit req = VisitMapper.toVisit(visit);
        req.setPet(pet);
        Visit savedVisit = clinicService.saveVisit(req);
        return new ResponseEntity<>(VisitMapper.toVisitResDto(savedVisit), HttpStatus.CREATED);
    }

    private Owner fetchOwnerById(int ownerId) {
        Owner owner = clinicService.findOwnerById(ownerId);
        if (owner == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.owner.not.found", null, Locale.ENGLISH));
        }
        return owner;
    }

    private Pet fetchPet(Owner owner, int petId) {
        Pet pet = owner.getPet(petId);
        if (pet == null) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.pet.not.found", null, Locale.ENGLISH));
        }
        return pet;
    }
}
