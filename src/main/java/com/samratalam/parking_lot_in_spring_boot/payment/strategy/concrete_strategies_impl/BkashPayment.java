package com.samratalam.parking_lot_in_spring_boot.payment.strategy.concrete_strategies_impl;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;
import com.samratalam.parking_lot_in_spring_boot.payment.strategy.PaymentStrategy;

public class BkashPayment implements PaymentStrategy {
    @Override
    public CommonResponse payParkingFees(Double feeAmount) {
        return new CommonResponse();
    }
}
