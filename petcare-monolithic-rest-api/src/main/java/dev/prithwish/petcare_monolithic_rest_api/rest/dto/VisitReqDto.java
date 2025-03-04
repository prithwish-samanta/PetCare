package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Schema(
        title = "Visit input message",
        description = "Editable fields of a vet visit."
)
public class VisitReqDto {
    @Schema(
            title = "Date",
            description = "The date of the visit.",
            format = "date",
            example = "2013-01-01"
    )
    @NotNull(message = "{date.notempty}")
    @FutureOrPresent(message = "{date.present.or.future.mismatch}")
    private LocalDate date;
    @Schema(
            title = "Description",
            description = "The description for the visit.",
            minLength = 1,
            maxLength = 255,
            example = "rabies shot"
    )
    @NotEmpty(message = "{description.notempty}")
    private String description;

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
