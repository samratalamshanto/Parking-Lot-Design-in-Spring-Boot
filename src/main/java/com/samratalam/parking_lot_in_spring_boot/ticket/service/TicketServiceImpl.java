package com.samratalam.parking_lot_in_spring_boot.ticket.service;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;
import com.samratalam.parking_lot_in_spring_boot.parking_floor.ParkingFloor;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.service.ParkingSpotService;
import com.samratalam.parking_lot_in_spring_boot.ticket.entity.Ticket;
import com.samratalam.parking_lot_in_spring_boot.ticket.repository.TicketRepository;
import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import com.samratalam.parking_lot_in_spring_boot.vehicle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ParkingFloor parkingFloor;
    private final ParkingSpotService parkingSpotService;
    private final VehicleService vehicleService;

    @Override
    public CommonResponse createTicket(Vehicle vehicle) {

        try {
            ParkingSpot parkingSpot = parkingFloor.parkVehicle(vehicle);
            parkingSpot.setId(AppUtil.getUUID());
            parkingSpotService.saveParkingSpot(parkingSpot);

            vehicle.setId(AppUtil.getUUID());
            vehicleService.saveVehicle(vehicle);

            Ticket ticket = new Ticket(vehicle, parkingSpot);
            ticket.setId(AppUtil.getUUID());
            ticketRepository.save(ticket);

            return AppUtil.createdResponse("Successfully created ticket.", ticket);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public CommonResponse getTotalFee(String ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            final double fee = ticket.get().getRatePerHrs() * AppUtil.getTotalHrs(ticket.get().getParkingStartTime());
            return AppUtil.successResponse("Total fee: $" + fee + ".", fee);
        }
        return null;
    }
}
