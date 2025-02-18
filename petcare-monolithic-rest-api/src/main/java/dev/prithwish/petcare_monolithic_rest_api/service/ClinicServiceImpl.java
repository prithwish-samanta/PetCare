package dev.prithwish.petcare_monolithic_rest_api.service;

import dev.prithwish.petcare_monolithic_rest_api.model.Owner;
import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.model.Visit;
import dev.prithwish.petcare_monolithic_rest_api.repository.OwnerRepository;
import dev.prithwish.petcare_monolithic_rest_api.repository.PetRepository;
import dev.prithwish.petcare_monolithic_rest_api.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VisitRepository visitRepository;

    public ClinicServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findOwnerByLastName(String lastName) {
        return ownerRepository.findOwnerByLastNameLikeIgnoreCase(lastName);
    }

    @Override
    public Owner findOwnerById(int ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public void deleteOwner(int ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }
}
