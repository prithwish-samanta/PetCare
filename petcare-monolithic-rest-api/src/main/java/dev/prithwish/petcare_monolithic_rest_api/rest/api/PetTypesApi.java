package dev.prithwish.petcare_monolithic_rest_api.rest.api;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.ErrorRes;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.PetTypeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pettypes")
@Tag(name = "pettypes", description = "Endpoints related to pet types.")
public interface PetTypesApi {
    @Operation(
            operationId = "listPetTypes",
            summary = "Lists pet types",
            description = "Returns an array of pet types."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pet types found and returned",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PetTypeDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No pet types found in the registry",
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
    ResponseEntity<List<PetTypeDto>> listPetTypes();

    @Operation(
            operationId = "getPetType",
            summary = "Get a pet type by ID",
            description = "Returns the pet type or a 404 error."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pet type details found and returned.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PetTypeDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pet Type not found.",
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
    @GetMapping("/{petTypeId}")
    ResponseEntity<PetTypeDto> getPetType(
            @Parameter(description = "The ID of the pet type.", example = "1")
            @PathVariable int petTypeId
    );
}
