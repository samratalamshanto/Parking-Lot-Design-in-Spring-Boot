package com.samratalam.parking_lot_in_spring_boot.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private int code = 200;
    private boolean success = true;
    private String message = "Success";
    private Object data;
}
