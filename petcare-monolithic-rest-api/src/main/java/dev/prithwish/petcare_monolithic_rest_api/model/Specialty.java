package dev.prithwish.petcare_monolithic_rest_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_specialties")
public class Specialty extends NamedEntity {
}
