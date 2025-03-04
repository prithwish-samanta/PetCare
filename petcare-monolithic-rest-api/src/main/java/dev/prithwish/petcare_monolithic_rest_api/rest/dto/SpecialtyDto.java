package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        title = "Specialty",
        description = "Fields of specialty of vets."
)
public class SpecialtyDto {
    @Schema(
            title = "ID",
            description = "The ID of the specialty.",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private int id;
    @Schema(
            title = "Name",
            description = "The name of the specialty.",
            example = "radiology",
            accessMode = Schema.AccessMode.READ_ONLY
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
