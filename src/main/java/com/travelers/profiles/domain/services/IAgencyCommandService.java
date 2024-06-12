package com.travelers.profiles.domain.services;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;

import java.util.Optional;

public interface IAgencyCommandService {
    /*METHODS*/
    Optional<Agency> handle(CreateAgencyCommand command);
}
