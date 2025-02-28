package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.Vet;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VetDto;

import java.util.List;

public class VetMapper {
    public static VetDto toVetDto(Vet vet) {
        VetDto vetDto = new VetDto();
        vetDto.setId(vet.getId());
        vetDto.setFirstName(vet.getFirstName());
        vetDto.setLastName(vet.getLastName());
        vetDto.setSpecialties(vet.getSpecialties().stream().map(SpecialtyMapper::toSpecialtyDto).toList());
        return vetDto;
    }

    public static List<VetDto> toVetDtoList(List<Vet> vets) {
        return vets.stream().map(VetMapper::toVetDto).toList();
    }
}
