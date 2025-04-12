package com.samratalam.parking_lot_in_spring_boot.mapper;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.ParkingSpotUDT;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import org.modelmapper.ModelMapper;

public final class ParkingSpotMapper {
    static ModelMapper modelMapper = new ModelMapper();

    public static ParkingSpotUDT mapToParkingSpotUDT(ParkingSpot parkingSpot) {
        ParkingSpotUDT parkingSpotUDT = new ParkingSpotUDT();
        modelMapper.map(parkingSpot, parkingSpotUDT);
        return parkingSpotUDT;
    }
}
