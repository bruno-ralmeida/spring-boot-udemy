package com.xxnbr.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum PaymentStatus {

    PENDING(1, "Pending"),
    CONFIRMED(2, "Confirmed"),
    CANCELED(3, "Canceled");

    private int code;
    private String description;

    public static PaymentStatus toEnum(Integer code) {
        if (code == null)
            return null;

        Optional<PaymentStatus> optionalPaymentStatus = Arrays.stream(PaymentStatus.values())
                .filter(customerType -> customerType.getCode() == code).findFirst();

        if (optionalPaymentStatus.isEmpty())
            throw new IllegalArgumentException(String.format("ID: %d is invalid", code));

        return optionalPaymentStatus.get();
    }
}
