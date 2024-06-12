package com.travelers.profiles.infrastructure.persistence.jpa;

import com.travelers.profiles.domain.model.aggregates.Agency;
import com.travelers.profiles.domain.model.aggregates.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOwnerRepository   extends JpaRepository<Owner, Long> {
    Optional<Owner> findById(Long id);

}
