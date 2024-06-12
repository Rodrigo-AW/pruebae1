package com.travelers.profiles.domain.model.commands;

import com.travelers.profiles.domain.model.aggregates.Owner;
import com.travelers.profiles.domain.model.valueobjects.AgencyType;

public record CreateAgencyCommand(String name, Long businessId, String streetAddress, Long latitude, Long longitude, AgencyType type, Long ownerId) {

    public String name() {
        return name;
    }

    public Long businessId() {
        return businessId;
    }

    public String streetAddress() {
        return streetAddress;
    }

    public Long latitude() {
        return latitude;
    }

    public Long longitude() {
        return longitude;
    }

    public AgencyType type() {
        return type;
    }

    public Long ownerId() {
        return ownerId;
    }
}
