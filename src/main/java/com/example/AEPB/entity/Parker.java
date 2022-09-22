package com.example.AEPB.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parker {
    List<ParkingLot> parkingLots;

    private Boolean parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.park(car)) {
                return true;
            }
        }
        return false;
    }
}
