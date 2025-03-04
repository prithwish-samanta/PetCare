package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(
        title = "Visit output message",
        description = "A booking for a vet visit."
)
public class VisitResDto {
    @Schema(
            title = "ID",
            description = "The ID of the visit.",
            example = "1",
            minimum = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private int id;
    @Schema(
            title = "Date",
            description = "The date of the visit.",
            format = "date",
            example = "2013-01-01",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDate date;
    @Schema(
            title = "Description",
            description = "The description for the visit.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "rabies shot"
    )
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
