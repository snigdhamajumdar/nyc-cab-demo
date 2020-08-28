package com.nyc.cab.demo.model;

import lombok.Data;
import java.util.Set;

@Data
public class TripCountRequest {
    private Set<String> cabIdList;
    private String pickUpDate;
    private boolean skipCache;
}
