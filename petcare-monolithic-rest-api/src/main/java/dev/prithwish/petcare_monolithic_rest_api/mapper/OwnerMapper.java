package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.Owner;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.OwnerReqDto;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.OwnerResDto;

import java.util.HashSet;
import java.util.stream.Collectors;

public class OwnerMapper {
    public static Owner toOwner(OwnerReqDto ownerReqDto) {
        Owner owner = new Owner();
        owner.setFirstName(ownerReqDto.getFirstName());
        owner.setLastName(ownerReqDto.getLastName());
        owner.setAddress(ownerReqDto.getAddress());
        owner.setCity(ownerReqDto.getCity());
        owner.setTelephone(ownerReqDto.getTelephone());
        return owner;
    }

    public static OwnerResDto toOwnerDto(Owner owner) {
        OwnerResDto ownerResDto = new OwnerResDto();
        ownerResDto.setId(owner.getId());
        ownerResDto.setFirstName(owner.getFirstName());
        ownerResDto.setLastName(owner.getLastName());
        ownerResDto.setAddress(owner.getAddress());
        ownerResDto.setCity(owner.getCity());
        ownerResDto.setTelephone(owner.getTelephone());
        if (owner.getPets() != null) {
            ownerResDto.setPets(owner.getPets().stream().map(PetMapper::toPetDto).collect(Collectors.toSet()));
        } else {
            ownerResDto.setPets(new HashSet<>());
        }
        return ownerResDto;
    }
}
