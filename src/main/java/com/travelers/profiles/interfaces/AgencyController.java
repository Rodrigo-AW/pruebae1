package com.travelers.profiles.interfaces;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.services.IAgencyCommandService;
import com.travelers.profiles.infrastructure.persistence.jpa.IOwnerRepository;
import com.travelers.profiles.interfaces.rest.resources.AgencyResource;
import com.travelers.profiles.interfaces.rest.resources.CreateAgencyResource;
import com.travelers.profiles.interfaces.rest.transform.AgencyResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value="/api/v1/agencies", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgencyController {

    private final IAgencyCommandService agencyCommandService;
    private final IOwnerRepository ownerRepository;
    public AgencyController(IAgencyCommandService agencyCommandService, IOwnerRepository ownerRepository) {
        this.agencyCommandService = agencyCommandService;
        this.ownerRepository = ownerRepository;
    }

    @PostMapping
    public ResponseEntity<AgencyResource> createAgency(@RequestBody CreateAgencyResource resource){
        // Buscar el Owner por ID
        Optional<Owner> owner = ownerRepository.findById(resource.ownerId());
        // Crear el comando CreateAgencyCommand con el Owner encontrado
        CreateAgencyCommand command = new CreateAgencyCommand(
                resource.name(),
                resource.businessId(),
                resource.streetAddress(),
                resource.latitude(),
                resource.longitude(),
                resource.type(),
                owner.get().getId()
        );

        Optional<Agency> agency = agencyCommandService.handle(command);
        return agency.map(resp-> new ResponseEntity<>(AgencyResourceFromEntityAssembler
                        .toResourceFromEntity(resp),CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }











}
