package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.Specialty;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.SpecialtyDto;

public class SpecialtyMapper {
    public static SpecialtyDto toSpecialtyDto(Specialty specialty) {
        SpecialtyDto specialtyDto = new SpecialtyDto();
        specialtyDto.setId(specialty.getId());
        specialtyDto.setName(specialty.getName());
        return specialtyDto;
    }
}
