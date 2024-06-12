package com.travelers.profiles.domain.model.aggregates;

import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Agency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long businessId;
    @Column(nullable = false)
    private String streetAddress;
    private Long latitude;
    private Long longitude;

    public Agency() {

    }

    public Agency(CreateAgencyCommand command){
        this.name=command.name();
        this.businessId=command.businessId();
        this.streetAddress=command.streetAddress();
        this.latitude=command.latitude();
        this.longitude=command.longitude();


    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }
}
