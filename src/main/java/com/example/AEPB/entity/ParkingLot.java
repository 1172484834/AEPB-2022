package com.example.AEPB.entity;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    private Integer quantity;

    private String parkingLotName;

    private Set<Car> carSet;

    public Boolean isUnoccupied() {
        return (quantity - carSet.size()) >= 1;
    }

    public Boolean isNotEmpty() {
        return !carSet.isEmpty();
    }

    public Integer getRemainCarQuantity() {
        return this.carSet.size() - quantity;
    }

    public Boolean isParking(Car car) {
        return carSet.contains(car);
    }

    public void PickCar(Car car) {
        carSet.remove(car);
    }

    public Boolean park(Car car) {
        if (carSet.size()==quantity) {
            return false;
        }
        carSet.add(car);
        return true;
    }
}
