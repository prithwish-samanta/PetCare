package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import dev.prithwish.petcare_monolithic_rest_api.mapper.VetMapper;
import dev.prithwish.petcare_monolithic_rest_api.model.Vet;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VetDto;
import dev.prithwish.petcare_monolithic_rest_api.service.ClinicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vets")
@CrossOrigin("*")
public class VetRestController {
    private final ClinicService clinicService;

    public VetRestController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public ResponseEntity<List<VetDto>> listVets() {
        List<Vet> vets = clinicService.findAllVets();
        List<VetDto> vetDtoList = VetMapper.toVetDtoList(vets);
        return new ResponseEntity<>(vetDtoList, HttpStatus.OK);
    }
}
