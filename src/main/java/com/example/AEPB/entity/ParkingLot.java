package com.example.AEPB.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    private Integer quantity;

    private List<Car> carList;

    public Boolean isUnoccupied() {
        return (quantity - carList.size()) >= 1;
    }

    public Boolean isNotEmpty() {
        return !carList.isEmpty();
    }

    public Boolean isParking(Voucher voucher){
        return carList.stream()
                .filter(car -> car.equals(voucher.getCar()))
                .findFirst()
                .orElse(null)
                != null;
    }

    public void PickCar(Voucher voucher){
        carList.removeIf(car -> car.equals(voucher.getCar()));
    }
}
