package com.travelers.profiles.interfaces.rest.transform;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.interfaces.rest.resources.AgencyResource;

public class AgencyResourceFromEntityAssembler {
    public static AgencyResource toResourceFromEntity(Agency agency){
        return new AgencyResource(
                agency.getId(),
                agency.getName(),
                agency.getBusinessId(),
                agency.getStreetAddress(),
                agency.getLatitude(),
                agency.getLongitude(),
                agency.getType()
        );
    }

}
