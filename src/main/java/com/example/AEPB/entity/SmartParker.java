package com.example.AEPB.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class SmartParker extends Parker {

    public Boolean parkCarByRemain(List<ParkingLot> parkingLots, Car car) {
        return findMaxRemainParkingLot(parkingLots).park(car);
    }

    public ParkingLot findMaxRemainParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot maxRemainParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (maxRemainParkingLot.getRemainCarQuantity() < parkingLot.getRemainCarQuantity())
                maxRemainParkingLot = parkingLot;
        }
        return maxRemainParkingLot;
    }
}
