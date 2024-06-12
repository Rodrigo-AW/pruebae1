package com.travelers.profiles.domain.model.aggregates;

import com.travelers.profiles.domain.model.commands.CreateOwnerCommand;
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

    public Long getId() {
        return this.id;
    }
public Owner(){

}
    public String getName() {
        return name;
    }
    public Owner(CreateOwnerCommand command)
    {
        this.name=command.name();
    }
}
