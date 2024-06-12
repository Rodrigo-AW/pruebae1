package com.travelers.profiles.infrastructure.persistence.jpa;
import com.travelers.profiles.domain.model.aggregates.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAgencyRepository extends JpaRepository<Agency, Long>{
    /*LOGICA DE NEGOCIO*/

    public List<Agency>findByBusinessIdAndName( Long businessId, String name);
    public List<Agency>findByLatitudeAndLongitude( Long latitude, Long longitude);
    public List<Agency>findByStreetAddress(String streetAddress);

}
