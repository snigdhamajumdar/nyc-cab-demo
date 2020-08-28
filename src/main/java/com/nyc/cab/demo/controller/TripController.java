package com.nyc.cab.demo.controller;

import com.nyc.cab.demo.model.TripCountRequest;
import com.nyc.cab.demo.model.TripCountResponse;
import com.nyc.cab.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trip")
public class TripController {
    @Autowired
    private TripService service;

    @PostMapping(value = "/countAll")
    @Cacheable(value = "tripcount", key = "new org.springframework.cache.interceptor.SimpleKey(#request.cabIdList)", condition = "#request.skipCache == false")
    public ResponseEntity<List<TripCountResponse>> getCountOfTrips(@RequestBody TripCountRequest request) {
        List<TripCountResponse> response = service.getCountOfTrips(request);
        return ResponseEntity.ok(response);
    }
}
