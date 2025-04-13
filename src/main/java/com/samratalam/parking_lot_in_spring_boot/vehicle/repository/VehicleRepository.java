package com.samratalam.parking_lot_in_spring_boot.vehicle.repository;

import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.VehicleEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CassandraRepository<VehicleEntity, String> {
}
