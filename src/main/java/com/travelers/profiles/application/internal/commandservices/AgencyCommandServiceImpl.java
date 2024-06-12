package com.travelers.profiles.application.internal.commandservices;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.services.IAgencyCommandService;
import com.travelers.profiles.infrastructure.persistence.jpa.IAgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyCommandServiceImpl implements IAgencyCommandService {
    private final IAgencyRepository agencyRepository;


    public AgencyCommandServiceImpl(IAgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Optional<Agency> handle(CreateAgencyCommand command) {
        List<Agency> existingAgenciesBussinesIdAndName = agencyRepository.findByBusinessIdAndName(command.businessId(), command.name());
    if(!existingAgenciesBussinesIdAndName.isEmpty()){
        throw new IllegalArgumentException("Agency exists with bussinesId and Name");
    }
        List<Agency>existingAgenciesLatitudeAndLongitude = agencyRepository.findByLatitudeAndLongitude(command.latitude(), command.longitude());
        if(!existingAgenciesLatitudeAndLongitude.isEmpty()){
            throw new IllegalArgumentException("Agency exists with latitude and Longitude");
        }
        List<Agency>existingAgenciesStreetAddress = agencyRepository.findByStreetAddress(command.streetAddress());
        if(!existingAgenciesStreetAddress.isEmpty()){
            throw new IllegalArgumentException("Agency exists with streetAddress");
        }

        Agency newAgency = new Agency(command);
        agencyRepository.save(newAgency);
        return Optional.of(newAgency);

    }
}
