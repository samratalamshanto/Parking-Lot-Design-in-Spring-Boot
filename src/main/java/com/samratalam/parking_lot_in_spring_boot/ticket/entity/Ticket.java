package com.samratalam.parking_lot_in_spring_boot.ticket.entity;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime parkingTime;

    Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingTime = AppUtil.getCurrentDateTime();
    }
}
