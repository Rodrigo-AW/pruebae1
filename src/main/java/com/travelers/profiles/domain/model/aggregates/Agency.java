package com.travelers.profiles.domain.model.aggregates;

import com.travelers.profiles.domain.model.commands.CreateAgencyCommand;
import com.travelers.profiles.domain.model.valueobjects.AgencyType;
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
    //ejemplo Rod
    @Column(nullable = false)
    private AgencyType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Agency() {

    }

    public Agency(CreateAgencyCommand command){
        this.name=command.name();
        this.businessId=command.businessId();
        this.streetAddress=command.streetAddress();
        this.latitude=command.latitude();
        this.longitude=command.longitude();
        this.type=command.type();
        this.owner = command.owner();
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

    public AgencyType getType() {
        return type;
    }

    public void setOwner(Owner owner) {

    }
}
