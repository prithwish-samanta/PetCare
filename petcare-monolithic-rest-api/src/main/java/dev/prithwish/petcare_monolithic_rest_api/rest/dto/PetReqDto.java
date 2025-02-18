package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import java.time.LocalDate;

public class PetReqDto {
    private String name;
    private LocalDate birthDate;
    private String petType;

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

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
}
