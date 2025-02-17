package dev.prithwish.petcare_monolithic_rest_api.model;

import dev.prithwish.petcare_monolithic_rest_api.PersonEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_owners")
public class Owner extends PersonEntity {
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets;
}
