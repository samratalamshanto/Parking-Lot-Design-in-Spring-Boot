package com.samratalam.parking_lot_in_spring_boot.parking_floor;

import com.samratalam.parking_lot_in_spring_boot.mapper.VehicleMapper;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.CarParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.repository.ParkingSpotRepo;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.service.ParkingSpotService;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingFloor {
    private final ParkingSpotService parkingSpotService;
    private final ParkingSpotRepo parkingSpotRepo;
    private List<ParkingSpot> parkingSpotList;
    private HashMap<String, ParkingSpot> parkingSpotMap = new HashMap<>();
    private int floorNumber;


}
