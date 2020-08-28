package com.nyc.cab.demo.service;

import com.nyc.cab.demo.model.TripCountRequest;
import com.nyc.cab.demo.model.TripCountResponse;
import com.nyc.cab.demo.persistence.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<TripCountResponse> getCountOfTrips(TripCountRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUpDate = LocalDate.parse(request.getPickUpDate(), formatter);
        LocalDate drop = pickUpDate.plusDays(1);
        return tripRepository.getCountOfCabTripsBetweenDate(request.getCabIdList(), pickUpDate, drop);
    }
}
