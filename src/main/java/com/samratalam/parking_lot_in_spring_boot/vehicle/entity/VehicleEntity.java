package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@NoArgsConstructor
@Table("vehicle")
public class VehicleEntity extends Vehicle {
    public VehicleEntity(UUID id, String licensePlate, String size, String vehicleType, Double ratePerHr, Double totalBill) {
        super(id, licensePlate, size, vehicleType, ratePerHr, totalBill, AppUtil.getCurrentDateTime(), null);
    }
}
