package dev.prithwish.petcare_monolithic_rest_api.service;

import dev.prithwish.petcare_monolithic_rest_api.model.Owner;
import dev.prithwish.petcare_monolithic_rest_api.model.Pet;
import dev.prithwish.petcare_monolithic_rest_api.model.PetType;
import dev.prithwish.petcare_monolithic_rest_api.model.Visit;
import dev.prithwish.petcare_monolithic_rest_api.repository.OwnerRepository;
import dev.prithwish.petcare_monolithic_rest_api.repository.PetRepository;
import dev.prithwish.petcare_monolithic_rest_api.repository.PetTypeRepository;
import dev.prithwish.petcare_monolithic_rest_api.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VisitRepository visitRepository;
    private final PetTypeRepository petTypeRepository;

    public ClinicServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository, VisitRepository visitRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.visitRepository = visitRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    @Transactional
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Owner> findOwnerByLastName(String lastName) {
        return ownerRepository.findByLastNameLikeIgnoreCase("%" + lastName + "%");
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findOwnerById(int ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    @Transactional
    public void deleteOwner(int ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    @Transactional
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    @Transactional
    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    @Transactional(readOnly = true)
    public PetType findPetTypeByName(String name) {
        return petTypeRepository.findByNameIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetType> findAllPetTypes() {
        return petTypeRepository.findAll();
    }

    @Override
    @Transactional
    public PetType savePetType(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    @Transactional(readOnly = true)
    public PetType findPetTypeById(int petTypeId) {
        return petTypeRepository.findById(petTypeId).orElse(null);
    }

    @Override
    @Transactional
    public void deletePetType(int petTypeId) {
        petTypeRepository.deleteById(petTypeId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findPetById(int petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    @Transactional
    public void deletePetById(int petId) {
        petRepository.deleteById(petId);
    }
}
