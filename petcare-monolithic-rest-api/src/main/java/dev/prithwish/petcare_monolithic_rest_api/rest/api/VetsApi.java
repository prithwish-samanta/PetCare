package dev.prithwish.petcare_monolithic_rest_api.rest.api;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.ErrorRes;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/vets")
@Tag(name = "vet", description = "Endpoints related to vets.")
public interface VetsApi {
    @Operation(
            operationId = "listVets",
            summary = "Lists vets",
            description = "Returns an array of vets."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Vets found and returned",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VetDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No vets found in the registry",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRes.class)
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
    @GetMapping
    ResponseEntity<List<VetDto>> listVets();
}
