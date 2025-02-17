package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import java.time.LocalDate;

public class VisitResDto {
    private int id;
    private LocalDate date;
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
