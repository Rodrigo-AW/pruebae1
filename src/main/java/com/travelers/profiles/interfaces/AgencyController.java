package com.travelers.profiles.interfaces;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.services.IAgencyCommandService;
import com.travelers.profiles.interfaces.rest.resources.AgencyResource;
import com.travelers.profiles.interfaces.rest.resources.CreateAgencyResource;
import com.travelers.profiles.interfaces.rest.transform.AgencyResourceFromEntityAssembler;
import com.travelers.profiles.interfaces.rest.transform.CreateAgencyCommandFromResourceAssembler;
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

    public AgencyController(IAgencyCommandService agencyCommandService) {
        this.agencyCommandService = agencyCommandService;
    }

    @PostMapping
    public ResponseEntity<AgencyResource> createAgency(@RequestBody CreateAgencyResource resource){
        Optional<Agency> agency= agencyCommandService.handle(CreateAgencyCommandFromResourceAssembler
                .toCommandFromResource(resource));
        return agency.map(resp-> new ResponseEntity<>(AgencyResourceFromEntityAssembler
                        .toResourceFromEntity(resp),CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }












}
