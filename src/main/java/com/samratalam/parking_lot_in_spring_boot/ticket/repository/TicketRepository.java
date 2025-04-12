package com.samratalam.parking_lot_in_spring_boot.ticket.repository;

import com.samratalam.parking_lot_in_spring_boot.ticket.entity.Ticket;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CassandraRepository<Ticket, String> {
}
