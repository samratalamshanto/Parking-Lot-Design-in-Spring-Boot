package com.samratalam.parking_lot_in_spring_boot.payment.strategy;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;

public interface PaymentStrategy {
    CommonResponse payParkingFees(Double feeAmount);
}
