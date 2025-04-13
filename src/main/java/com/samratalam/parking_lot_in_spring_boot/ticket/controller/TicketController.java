package com.samratalam.parking_lot_in_spring_boot.ticket.controller;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;
import com.samratalam.parking_lot_in_spring_boot.ticket.service.TicketService;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse createTicket(@RequestBody Vehicle vehicle) {

        return ticketService.createTicket(vehicle);
    }

    @PostMapping(value = "/get-fee", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getTotalFee(@RequestBody String ticketId) {
        return ticketService.getTotalFee(ticketId);
    }
}
