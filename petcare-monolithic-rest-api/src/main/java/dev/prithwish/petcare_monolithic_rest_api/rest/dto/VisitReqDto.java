package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VisitReqDto {
    @NotNull(message = "{date.notempty}")
    @FutureOrPresent(message = "{date.present.or.future.mismatch}")
    private LocalDate date;
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
