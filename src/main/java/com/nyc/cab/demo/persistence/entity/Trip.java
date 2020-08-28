package com.nyc.cab.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "cab_trip_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    private String medallion;

    @Column(name = "hack_license")
    private String hackLicense;

    @Column(name = "vendor_id")
    private String vendorId;

    @Column(name = "rate_code")
    private Integer rateCode;

    @Column(name = "store_and_fwd_flag")
    private String storeAndFwdFlag;

    @Column(name = "pickup_datetime")
    private LocalDate pickupDateTime;

    @Column(name = "dropoff_datetime")
    private LocalDate dropoffDateTime;

    @Column(name = "passenger_count")
    private Integer passengerCount;

    @Column(name = "trip_time_in_secs")
    private Integer tripTimeInSecs;

    @Column(name = "trip_distance")
    private Double tripDistance;

    @Column(name = "pickup_longitude")
    private Double pickupLongitude;

    @Column(name = "pickup_latitude")
    private Double pickupLatitude;

    @Column(name = "dropoff_longitude")
    private Double dropoffLongitude;

    @Column(name = "dropoff_latitude")
    private Double dropoffLatitude;

}
