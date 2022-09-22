package com.example.AEPB.service.Impl;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.User;
import com.example.AEPB.entity.Voucher;
import com.example.AEPB.service.ParkingLotService;

import java.util.Objects;

public class ParkingLotServiceImpl implements ParkingLotService {


    @Override
    public String Park(ParkingLot parkingLot, User user, Car car) {
        if (parkingLot.isUnoccupied()) {
            Voucher voucher = Voucher.builder().user(user).car(car).build();
            parkingLot.getCarList().add(car);
            user.setVoucher(voucher);
            return "park success";
        }
        return "park failing";
    }

    @Override
    public String Pick(ParkingLot parkingLot, User user) {
        if (parkingLot.isNotEmpty() && Objects.nonNull(user.getVoucher()) && parkingLot.isParking(user.getVoucher())) {
            parkingLot.PickCar(user.getVoucher());
            user.setVoucher(null);
            return "pick success";
        }
        user.setVoucher(null);
        return "pick failing";
    }
}
