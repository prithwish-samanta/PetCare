package dev.prithwish.petcare_monolithic_rest_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_visits")
public class Visit extends BaseEntity {
    @Column(name = "visit_date", columnDefinition = "DATE")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
