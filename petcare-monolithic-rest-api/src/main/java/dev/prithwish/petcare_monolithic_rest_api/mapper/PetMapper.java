package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetReqDto;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetResDto;

import java.util.HashSet;
import java.util.stream.Collectors;

public class PetMapper {
    public static Pet toPet(PetReqDto petReqDto) {
        Pet pet = new Pet();
        pet.setName(petReqDto.getName());
        pet.setBirthDate(petReqDto.getBirthDate());
        return pet;
    }

    public static PetResDto toPetDto(Pet pet) {
        PetResDto petResDto = new PetResDto();
        petResDto.setId(pet.getId());
        petResDto.setName(pet.getName());
        petResDto.setBirthDate(pet.getBirthDate());
        petResDto.setPetType(PetTypeMapper.toPetTypeDto(pet.getType()));
        if (pet.getVisits() != null) {
            petResDto.setVisits(pet.getVisits().stream().map(VisitMapper::toVisitResDto).collect(Collectors.toSet()));
        } else {
            petResDto.setVisits(new HashSet<>());
        }
        return petResDto;
    }
}
