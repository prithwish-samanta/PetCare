package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;

public class PetTypeMapper {
    public static PetTypeDto toPetTypeDto(PetType petType) {
        PetTypeDto petTypeDto = new PetTypeDto();
        petTypeDto.setId(petType.getId());
        petTypeDto.setName(petType.getName());
        return petTypeDto;
    }
}
