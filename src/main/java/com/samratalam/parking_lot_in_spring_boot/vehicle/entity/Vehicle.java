package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@NoArgsConstructor
@AllArgsConstructor
@Table("vehicle")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "CAR"),
        @JsonSubTypes.Type(value = Bike.class, name = "BIKE"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck")
})
public abstract class Vehicle {
    @PrimaryKey
    private UUID id;

    private String licensePlate;
  //  private String color;
    private String size;
    private String vehicleType;
    private Double ratePerHr;
    private Double totalBill;


    public Vehicle(String licensePlate, EVehicleColor color, EVehicleSize size, EVehicleType vehicleType, Double price) {
        this.licensePlate = licensePlate;
     //   this.color = color.name();
        this.size = size.name();
        this.vehicleType = vehicleType.name();
        this.ratePerHr = price;
    }
}
