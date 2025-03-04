package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(
        title = "Error message",
        description = "The schema for all error responses."
)
public class ErrorRes {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp", example = "2024-11-23T13:59:21.3820407Z")
    private Instant timestamp;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "HTTP status code", example = "404")
    private int status;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "The error message.", example = "No static resource api/owner.")
    private Object error;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Full URL that originated the error response.", example = "/petcare/api/v1/oops")
    private String path;

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
