package com.samratalam.parking_lot_in_spring_boot.ticket.service;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;
import com.samratalam.parking_lot_in_spring_boot.ticket.entity.Ticket;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;

public interface TicketService {
    CommonResponse createTicket(Vehicle vehicle);

    CommonResponse getTotalFee(String ticketId);
}
