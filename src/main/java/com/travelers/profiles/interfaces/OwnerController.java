package com.travelers.profiles.interfaces;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.model.commands.CreateOwnerCommand;
import com.travelers.profiles.domain.services.IOwnerCommandService;
import com.travelers.profiles.infrastructure.persistence.jpa.IOwnerRepository;
import com.travelers.profiles.interfaces.rest.resources.AgencyResource;
import com.travelers.profiles.interfaces.rest.resources.CreateAgencyResource;
import com.travelers.profiles.interfaces.rest.resources.CreateOwnerResource;
import com.travelers.profiles.interfaces.rest.resources.OwnerResource;
import com.travelers.profiles.interfaces.rest.transform.AgencyResourceFromEntityAssembler;
import com.travelers.profiles.interfaces.rest.transform.CreateOwnerCommandFromResourceAssembler;
import com.travelers.profiles.interfaces.rest.transform.OwnerResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value="/api/v1/owner", produces = MediaType.APPLICATION_JSON_VALUE)
public class OwnerController {
    private final IOwnerRepository ownerRepository;
    private final IOwnerCommandService ownerCommandService;

    public OwnerController(IOwnerRepository ownerRepository, IOwnerCommandService ownerCommandService) {
        this.ownerRepository = ownerRepository;
        this.ownerCommandService = ownerCommandService;
    }

    @PostMapping
    public ResponseEntity<OwnerResource> createOwner(@RequestBody CreateOwnerResource resource) {
        // Crear un CreateOwnerCommand a partir del CreateOwnerResource
        CreateOwnerCommand command = CreateOwnerCommandFromResourceAssembler.toCommandFromResource(resource);

        // Manejar el comando para crear un Owner
        Optional<Owner> owner = ownerCommandService.handle(command);

        // Convertir el Owner a OwnerResource y devolverlo
        return owner.map(resp -> new ResponseEntity<>(OwnerResourceFromEntityAssembler.toResourceFromEntity(resp), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}