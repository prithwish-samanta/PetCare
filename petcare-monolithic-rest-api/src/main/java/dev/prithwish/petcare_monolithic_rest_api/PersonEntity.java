package dev.prithwish.petcare_monolithic_rest_api;

import dev.prithwish.petcare_monolithic_rest_api.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class PersonEntity extends BaseEntity {
    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;
}
