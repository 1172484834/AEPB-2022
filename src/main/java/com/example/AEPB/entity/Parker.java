package com.example.AEPB.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parker {

    public Boolean parkCar(List<ParkingLot> parkingLots, Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.park(car)) {
                return true;
            }
        }
        return false;
    }
}
