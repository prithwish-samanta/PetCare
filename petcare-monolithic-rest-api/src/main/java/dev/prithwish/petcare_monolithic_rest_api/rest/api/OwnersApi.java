package dev.prithwish.petcare_monolithic_rest_api.rest.api;

import dev.prithwish.petcare_monolithic_rest_api.rest.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owners")
@Tag(name = "owner", description = "Endpoints related to pet owners.")
public interface OwnersApi {
    @Operation(
            operationId = "addOwner",
            summary = "Adds a pet owner",
            description = "Records the details of a new pet owner."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "The pet owner was successfully added.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = OwnerResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request.",
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
    @PostMapping
    ResponseEntity<OwnerResDto> addOwner(
            @RequestBody @Valid OwnerReqDto owner
    );

    @Operation(
            operationId = "listOwners",
            summary = "Lists pet owners",
            description = "Returns an array of pet owners."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Owner details found and returned.",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = OwnerResDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No owners found in the registry",
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
    ResponseEntity<List<OwnerResDto>> listOwners(
            @Parameter(description = "Last name.", example = "Davis")
            @RequestParam(required = false) String lastName
    );

    @Operation(
            operationId = "getOwner",
            summary = "Get a pet owner by ID",
            description = "Returns the pet owner or a 404 error."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Owner details found and returned.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = OwnerResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Owner not found.",
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
    @GetMapping("/{ownerId}")
    ResponseEntity<OwnerResDto> getOwner(
            @Parameter(description = "The ID of the pet owner.", example = "1")
            @PathVariable int ownerId
    );

    @Operation(
            operationId = "updateOwner",
            summary = "Update a pet owner's details",
            description = "Updates the pet owner record with the specified details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Update successful.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = OwnerResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Owner not found.",
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
    @PutMapping("/{ownerId}")
    ResponseEntity<OwnerResDto> updateOwner(
            @RequestBody @Valid OwnerReqDto owner,
            @Parameter(description = "The ID of the pet owner.", required = true, example = "1")
            @PathVariable int ownerId
    );

    @Operation(
            operationId = "deleteOwner",
            summary = "Delete an owner by ID",
            description = "Returns the owner or a 404 error."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Owner deleted successfully.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema()
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Owner not found.",
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
    @DeleteMapping("/{ownerId}")
    ResponseEntity<Void> deleteOwner(
            @Parameter(description = "The ID of the owner.", example = "1")
            @PathVariable int ownerId
    );

    @Operation(
            operationId = "addPetToOwner",
            summary = "Adds a pet to an owner",
            description = "Records the details of a new pet."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "The pet was successfully added.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PetResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pet or Owner not found.",
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
    @PostMapping("/{ownerId}/pets")
    ResponseEntity<PetResDto> addPetToOwner(
            @Parameter(description = "The ID of the pet owner.", required = true, example = "1")
            @PathVariable int ownerId,
            @RequestBody @Valid PetReqDto pet
    );

    @Operation(
            operationId = "getOwnersPet",
            summary = "Get a pet by ID",
            description = "Returns the pet or a 404 error."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pet details found and returned.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PetResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pet or Owner not found.",
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
    @Parameters({
            @Parameter(name = "ownerId", description = "The ID of the pet owner.", required = true, example = "1"),
            @Parameter(name = "petId", description = "The ID of the pet.", required = true, example = "1"),
    })
    @GetMapping("/{ownerId}/pets/{petId}")
    ResponseEntity<PetResDto> getOwnersPet(@PathVariable int ownerId, @PathVariable int petId);

    @Operation(
            operationId = "updateOwnersPet",
            summary = "Update a pet's details",
            description = "Updates the pet record with the specified details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Update successful.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pet not found for this owner.",
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
    @Parameters({
            @Parameter(name = "ownerId", description = "The ID of the pet owner.", required = true, example = "1"),
            @Parameter(name = "petId", description = "The ID of the pet.", required = true, example = "1"),
    })
    @PutMapping("/{ownerId}/pets/{petId}")
    ResponseEntity<String> updateOwnersPet(@PathVariable int ownerId, @PathVariable int petId, @RequestBody @Valid PetReqDto pet);

    @Operation(
            operationId = "addVisitToOwner",
            summary = "Adds a vet visit",
            description = "Records the details of a new vet visit."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "The vet visit was successfully added.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VisitResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pet not found for this owner.",
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
    @Parameters({
            @Parameter(name = "ownerId", description = "The ID of the pet owner.", required = true, example = "1"),
            @Parameter(name = "petId", description = "The ID of the pet.", required = true, example = "1")
    })
    @PostMapping("/{ownerId}/pets/{petId}/visits")
    ResponseEntity<VisitResDto> addVisitToOwner(@PathVariable int ownerId, @PathVariable int petId, @RequestBody @Valid VisitReqDto visit);
}
