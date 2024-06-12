package com.travelers.profiles.domain.services;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.model.commands.CreateOwnerCommand;

import java.util.Optional;

public interface IOwnerCommandService {
    Optional<Owner> handle(CreateOwnerCommand command);

}
