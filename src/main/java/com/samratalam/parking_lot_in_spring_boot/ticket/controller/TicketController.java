package com.samratalam.parking_lot_in_spring_boot.ticket.controller;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;
import com.samratalam.parking_lot_in_spring_boot.ticket.entity.Ticket;
import com.samratalam.parking_lot_in_spring_boot.ticket.service.TicketService;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/create")
    public CommonResponse createTicket(Vehicle vehicle) {
        return ticketService.createTicket(vehicle);
    }

    @PostMapping("/get-fee")
    public CommonResponse getTotalFee(String ticketId) {
        return ticketService.getTotalFee(ticketId);
    }
}
