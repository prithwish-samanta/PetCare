package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import jakarta.validation.constraints.NotEmpty;

public class PetTypeDto {
    private int id;
    @NotEmpty(message = "{name.notempty}")
    private String name;

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
}
