package com.travelers.profiles.interfaces.rest.transform;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.interfaces.rest.resources.AgencyResource;
import com.travelers.profiles.interfaces.rest.resources.OwnerResource;

public class OwnerResourceFromEntityAssembler {
    public static OwnerResource toResourceFromEntity(Owner owner){
        return new OwnerResource(
                owner.getId(),
                owner.getName()

        );
    }
}
