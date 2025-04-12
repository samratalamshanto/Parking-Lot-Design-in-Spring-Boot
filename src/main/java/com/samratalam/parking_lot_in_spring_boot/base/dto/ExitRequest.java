package com.samratalam.parking_lot_in_spring_boot.base.dto;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.payment.entity.Payment;
import com.samratalam.parking_lot_in_spring_boot.ticket.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExitRequest {
    private Ticket ticket;
    private ParkingSpot parkingSpot;
    private Payment payment;
}
