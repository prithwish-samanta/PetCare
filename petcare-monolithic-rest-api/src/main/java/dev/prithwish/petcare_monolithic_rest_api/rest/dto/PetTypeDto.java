package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(
        title = "Pet type",
        description = "A pet type."
)
public class PetTypeDto {
    @Schema(
            title = "ID",
            description = "The ID of the pet type.",
            example = "1"
    )
    private int id;
    @NotEmpty(message = "{name.notempty}")
    @Schema(
            title = "Name",
            description = "The name of the pet type.",
            example = "dog"
    )
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
