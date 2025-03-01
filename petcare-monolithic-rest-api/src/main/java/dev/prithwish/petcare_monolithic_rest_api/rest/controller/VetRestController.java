package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import dev.prithwish.petcare_monolithic_rest_api.mapper.VetMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.Vet;
import dev.prithwish.petcare_monolithic_rest_api.rest.api.VetsApi;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VetDto;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin("*")
public class VetRestController implements VetsApi {
    private final ClinicService clinicService;
    private final MessageSource messageSource;

    public VetRestController(ClinicService clinicService, MessageSource messageSource) {
        this.clinicService = clinicService;
        this.messageSource = messageSource;
    }

    @Override
    public ResponseEntity<List<VetDto>> listVets() {
        List<Vet> vets = clinicService.findAllVets();
        if (vets == null || vets.isEmpty()) {
            throw new ResourceNotFoundException(messageSource.getMessage("api.error.vet.list.empty", null, Locale.ENGLISH));
        }
        List<VetDto> vetDtoList = VetMapper.toVetDtoList(vets);
        return new ResponseEntity<>(vetDtoList, HttpStatus.OK);
    }
}
