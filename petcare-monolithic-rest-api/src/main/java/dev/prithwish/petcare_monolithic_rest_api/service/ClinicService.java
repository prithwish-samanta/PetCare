package dev.prithwish.petcare_monolithic_rest_api.service;

import dev.prithwish.petcare_monolithic_rest_api.model.Owner;
import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.model.Visit;

import java.util.List;

public interface ClinicService {
    Owner saveOwner(Owner owner);

    List<Owner> findAllOwners();

    List<Owner> findOwnerByLastName(String lastName);

    Owner findOwnerById(int ownerId);

    void deleteOwner(int ownerId);

    Pet savePet(Pet pet);

    Visit saveVisit(Visit visit);

    PetType findPetTypeByName(String name);
}
