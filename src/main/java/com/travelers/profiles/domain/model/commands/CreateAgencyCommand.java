package com.travelers.profiles.domain.model.commands;

import com.travelers.profiles.domain.model.valueobjects.AgencyType;

public record CreateAgencyCommand(String name, Long businessId, String streetAddress, Long latitude, Long longitude, AgencyType type) {



}
