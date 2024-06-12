package com.travelers.profiles.application.internal.commandservices;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.services.IAgencyCommandService;
import com.travelers.profiles.infrastructure.persistence.jpa.IAgencyRepository;
import com.travelers.profiles.infrastructure.persistence.jpa.IOwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyCommandServiceImpl implements IAgencyCommandService {
    private final IAgencyRepository agencyRepository;
    private final IOwnerRepository ownerRepository;


    public AgencyCommandServiceImpl(IAgencyRepository agencyRepository, IOwnerRepository ownerRepository) {
        this.agencyRepository = agencyRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Optional<Agency> handle(CreateAgencyCommand command) {
        Owner owner = ownerRepository.findById(command.ownerId())
                .orElseThrow(() -> new EntityNotFoundException("Owner not found"));
        Agency agency = new Agency(command, owner);
        agencyRepository.save(agency);
        return Optional.of(agency);
    }
}
