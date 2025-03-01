package dev.prithwish.petcare_monolithic_rest_api.rest.api;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.ErrorRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "failing", description = "Endpoint which always returns an error.")
public interface CrashApi {
    @Operation(
            operationId = "failingRequest",
            summary = "Always fails",
            description = "Produces sample error response."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Never returned.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Server error",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRes.class)
                    )
            )
    })
    @GetMapping("/oops")
    ResponseEntity<String> failingRequest();
}
