package com.nyc.cab.demo.persistence;

import com.nyc.cab.demo.persistence.entity.Trip;
import com.nyc.cab.demo.model.TripCountResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface TripRepository extends CrudRepository<Trip, String> {

    @Query("select new com.nyc.cab.demo.model.TripCountResponse(c.medallion, count(c)) \n" +
            "    from Trip c \n" +
            "    where c.pickupDateTime > ?2 \n" +
            "    and c.dropoffDateTime < ?3 \n" +
            "    and c.medallion in (?1)\n" +
            "    group by c.medallion")
    List<TripCountResponse> getCountOfCabTripsBetweenDate(Set<String> medallionList, LocalDate pickUpDateTime, LocalDate dropOffDateTime);
}
