package com.travelers.profiles.interfaces.rest.transform;

import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.model.commands.CreateOwnerCommand;
import com.travelers.profiles.interfaces.rest.resources.CreateAgencyResource;
import com.travelers.profiles.interfaces.rest.resources.CreateOwnerResource;

public class CreateOwnerCommandFromResourceAssembler {

    public static CreateOwnerCommand toCommandFromResource(CreateOwnerResource resource){
        return new CreateOwnerCommand(
                resource.name()

        );
    }
}
