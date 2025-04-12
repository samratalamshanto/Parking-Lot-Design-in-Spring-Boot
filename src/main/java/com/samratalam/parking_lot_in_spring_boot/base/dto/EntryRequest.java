package com.samratalam.parking_lot_in_spring_boot.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryRequest {
    private String carType;
    private String carModel;
    private String licensePlate;
}
