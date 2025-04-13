package com.samratalam.parking_lot_in_spring_boot;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.*;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.repository.ParkingSpotRepo;
import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ParkingLotInSpringBootApplication {

    private final ParkingSpotRepo parkingSpotRepo;

    public ParkingLotInSpringBootApplication(ParkingSpotRepo parkingSpotRepo) {
        this.parkingSpotRepo = parkingSpotRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(ParkingLotInSpringBootApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ParkingSpot parkingSpot = new CarParkingSpot(i + 100 * i);
            parkingSpot.setId(AppUtil.getUUID());
            ParkingSpot parkingSpot2 = new BikeParkingSpot(i + 200 * i);
            parkingSpot2.setId(AppUtil.getUUID());
            ParkingSpot parkingSpot3 = new TruckParkingSpot(i + 300 * i);
            parkingSpot3.setId(AppUtil.getUUID());
            parkingSpotList.addAll(List.of(parkingSpot, parkingSpot2, parkingSpot3));
        }

        List<ParkingSpotEntity> finalList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (ParkingSpot single : parkingSpotList) {
            ParkingSpotEntity entity = new ParkingSpotEntity();
            mapper.map(single, entity);
            finalList.add(entity);
        }

        parkingSpotRepo.saveAll(finalList);
    }
}
