package dev.prithwish.petcare_monolithic_rest_api.model;

import dev.prithwish.petcare_monolithic_rest_api.PersonEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_vets")
public class Vet extends PersonEntity {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties;
}
