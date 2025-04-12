package com.samratalam.parking_lot_in_spring_boot.ticket.entity;

import com.samratalam.parking_lot_in_spring_boot.mapper.ParkingSpotMapper;
import com.samratalam.parking_lot_in_spring_boot.mapper.VehicleMapper;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.ParkingSpotUDT;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import com.samratalam.parking_lot_in_spring_boot.vehicle.dto.VehicleUDT;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("ticket")
public class Ticket {
    @PrimaryKey
    private UUID id;
    private VehicleUDT vehicle;
    private ParkingSpotUDT parkingSpot;
    private LocalDateTime parkingStartTime;
    private LocalDateTime parkingEndTime;
    private Double ratePerHrs;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = VehicleMapper.mapToVehicleUDT(vehicle);
        this.parkingSpot = ParkingSpotMapper.mapToParkingSpotUDT(parkingSpot);
        this.parkingStartTime = AppUtil.getCurrentDateTime();
        this.ratePerHrs = vehicle.getRatePerHr();
    }
}
