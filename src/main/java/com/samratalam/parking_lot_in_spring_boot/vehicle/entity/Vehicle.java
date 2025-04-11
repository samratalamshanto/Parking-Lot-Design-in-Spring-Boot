package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleSize;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Data
@NoArgsConstructor  // Needed by Spring Data
@AllArgsConstructor
@Table("vehicle")
public abstract class Vehicle {
    @PrimaryKey
    private UUID id;

    private String licensePlate;
    private String color;
    private String size;
    private String vehicleType;
    private Double ratePerHr;
    private Double totalBill;


    public Vehicle(String licensePlate, EVehicleColor color, EVehicleSize size, EVehicleType vehicleType, Double price) {
        this.licensePlate = licensePlate;
        this.color = color.name();
        this.size = size.name();
        this.vehicleType = vehicleType.name();
        this.ratePerHr = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getRatePerHr() {
        return ratePerHr;
    }

    public void setRatePerHr(Double ratePerHr) {
        this.ratePerHr = ratePerHr;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }
}
