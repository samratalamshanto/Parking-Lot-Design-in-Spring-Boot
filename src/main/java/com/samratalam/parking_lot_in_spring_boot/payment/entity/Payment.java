package com.samratalam.parking_lot_in_spring_boot.payment.entity;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;
import com.samratalam.parking_lot_in_spring_boot.payment.strategy.PaymentStrategy;
import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Payment {
    private final Double amount;
    private final PaymentStrategy paymentStrategy;

    public Payment(Double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public CommonResponse processPayment() {
        if (this.amount > 0) {
            return paymentStrategy.payParkingFees(this.amount);
        } else {
            return AppUtil.clientErrorResponse("InValid Amount=" + this.amount);
        }
    }
}
