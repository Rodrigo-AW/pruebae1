package com.travelers.profiles.interfaces.rest.transform;

import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.interfaces.rest.resources.CreateAgencyResource;

public class CreateAgencyCommandFromResourceAssembler {
    public static CreateAgencyCommand toCommandFromResource(CreateAgencyResource resource){
        return new CreateAgencyCommand(
                resource.name(),
                resource.businessId(),
                resource.streetAddress(),
                resource.latitude(),
                resource.longitude(),
                resource.type()
        );
    }


}
