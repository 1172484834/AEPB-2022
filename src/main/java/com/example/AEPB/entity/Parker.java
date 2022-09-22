package com.example.AEPB.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class Parker {

    public Boolean parkCar(List<ParkingLot> parkingLots, Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.park(car)) {
                return true;
            }
        }
        return false;
    }

    public Boolean pickCar(List<ParkingLot> parkingLots, Voucher voucher) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.pickCar(voucher.getCar()))
                return true;
        }
        return false;
    }
}
