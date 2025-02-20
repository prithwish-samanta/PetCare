package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;

import java.util.List;

public class PetTypeMapper {
    public static PetTypeDto toPetTypeDto(PetType petType) {
        PetTypeDto petTypeDto = new PetTypeDto();
        petTypeDto.setId(petType.getId());
        petTypeDto.setName(petType.getName());
        return petTypeDto;
    }

    public static PetType toPetType(PetTypeDto petTypeDto) {
        PetType petType = new PetType();
        petType.setName(petTypeDto.getName());
        return petType;
    }

    public static List<PetTypeDto> toPetTypeDtoList(List<PetType> petTypes) {
        return petTypes.stream().map(PetTypeMapper::toPetTypeDto).toList();
    }
}
