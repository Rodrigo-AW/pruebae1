package com.travelers.profiles.domain.model.aggregates;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

    /*UN OWNER TIENE MUCHAS AGENCIAS */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agency> agencies = new ArrayList<>();

    public void addAgency(Agency agency) {
        agencies.add(agency);
        agency.setOwner(this);
    }

}
