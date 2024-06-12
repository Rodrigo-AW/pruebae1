package com.travelers.profiles.interfaces.rest.resources;

import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.valueobjects.AgencyType;

public record CreateAgencyResource(String name, Long businessId, String streetAddress, Long latitude, Long longitude, AgencyType type, Long ownerId) {
}