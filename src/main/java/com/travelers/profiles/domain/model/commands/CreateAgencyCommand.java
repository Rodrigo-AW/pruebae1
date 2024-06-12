package com.travelers.profiles.domain.model.commands;

public record CreateAgencyCommand(String name, Long businessId, String streetAddress, Long latitude, Long longitude
) {



}
