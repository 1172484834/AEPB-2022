package com.example.AEPB.entity;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    private ParkingLot parkingLot;

    private Car car;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return Objects.equals(parkingLot, voucher.parkingLot) && Objects.equals(car, voucher.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingLot, car);
    }
}
