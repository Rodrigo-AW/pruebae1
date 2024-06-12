package com.travelers.profiles.application.internal.commandservices;

import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.commands.CreateOwnerCommand;
import com.travelers.profiles.domain.services.IOwnerCommandService;
import com.travelers.profiles.infrastructure.persistence.jpa.IOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerCommandServiceImpl implements IOwnerCommandService {
        private final IOwnerRepository ownerRepository;

    public OwnerCommandServiceImpl(IOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Optional<Owner> handle(CreateOwnerCommand command) {
        Owner owner= new Owner(command);
        ownerRepository.save(owner);
        return Optional.of(owner);



    }
}
