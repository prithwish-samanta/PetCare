package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class PetReqDto {
    @NotEmpty(message = "{name.notempty}")
    private String name;
    @PastOrPresent(message = "{date.present.or.past.mismatch}")
    private LocalDate birthDate;
    @NotEmpty(message = "{pettype.notempty}")
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
