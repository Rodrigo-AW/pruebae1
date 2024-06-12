package com.travelers.profiles.interfaces.rest.resources;

import com.travelers.profiles.domain.model.valueobjects.AgencyType;

public record AgencyResource( Long Id, String name, Long businessId, String streetAddress, Long latitude, Long longitude, AgencyType type) {
}
