package com.nyc.cab.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TripCountResponse {
    String cabId;
    Long count;
}
