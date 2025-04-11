package com.samratalam.parking_lot_in_spring_boot.utility;

import com.samratalam.parking_lot_in_spring_boot.base.dto.CommonResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class AppUtil {

    public static String getTimeZone() {
        return "Asia/Dhaka";
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now(ZoneId.of(getTimeZone()));
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(ZoneId.of(getTimeZone()));
    }

    public static CommonResponse successResponse(String msg, Object data) {
        return new CommonResponse(200, true, msg, data);
    }

    public static CommonResponse createdResponse(String msg, Object data) {
        return new CommonResponse(201, true, msg, data);
    }

    public static CommonResponse clientErrorResponse(String errorMsg) {
        return new CommonResponse(400, false, errorMsg, null);
    }

    public static CommonResponse serverErrorResponse(String errorMsg) {
        return new CommonResponse(500, false, errorMsg, null);
    }
}
