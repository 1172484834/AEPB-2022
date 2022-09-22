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

    public Integer getRemainCarQuantity() {
        return quantity - this.carSet.size();
    }

    public Boolean isParking(Car car) {
        return carSet.contains(car);
    }

    public Boolean pickCar(Car car) {
        if (carSet.contains(car)) {
            return carSet.remove(car);
        }
        return false;
    }

    public Boolean park(Car car) {
        if (carSet.size() == quantity) {
            return false;
        }
        carSet.add(car);
        return true;
    }

}
