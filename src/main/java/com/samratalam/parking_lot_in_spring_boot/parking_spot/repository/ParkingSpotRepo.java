package com.samratalam.parking_lot_in_spring_boot.parking_spot.repository;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpotEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParkingSpotRepo extends CassandraRepository<ParkingSpotEntity, String> {

    @Query(value = "select * from parking_spot where parkingspottype=:parkingSportType allow filtering")
    List<ParkingSpotEntity> findAllAvailableSpots(String parkingSportType);

    //Only set this slot as occupied IF it's still unoccupied at the moment of write
    @Query("update parking_spot set isoccupied=true where id=:spotId if isoccupied=false")
    boolean updateParkingSpot(UUID spotId);
}
