package com.samratalam.parking_lot_in_spring_boot.parking_spot.repository;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepo extends CassandraRepository<ParkingSpot, String> {
}
