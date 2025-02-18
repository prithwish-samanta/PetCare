package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import java.time.LocalDate;
import java.util.Set;

public class PetResDto {
    private int id;
    private String name;
    private LocalDate birthDate;
    private PetTypeDto petType;
    private Set<VisitResDto> visits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetTypeDto getPetType() {
        return petType;
    }

    public void setPetType(PetTypeDto petType) {
        this.petType = petType;
    }

    public Set<VisitResDto> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitResDto> visits) {
        this.visits = visits;
    }
}
