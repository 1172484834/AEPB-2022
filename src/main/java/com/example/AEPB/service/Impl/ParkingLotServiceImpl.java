package com.example.AEPB.service.Impl;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.Parker;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.User;
import com.example.AEPB.service.ParkingLotService;

import java.util.List;
import java.util.Objects;

public class ParkingLotServiceImpl implements ParkingLotService {

    private Parker parker = new Parker();
    @Override
    public Boolean park(ParkingLot parkingLot, Car car) {
        return parkingLot.park(car);
    }

    @Override
    public String pick(ParkingLot parkingLot, User user) {
        return null;
    }

    @Override
    public Boolean parkByParker(List<ParkingLot> parkingLots, Car car) {
        parker.parkCar(parkingLots, car);
        return null;
    }

//    @Override
//    public String pick(ParkingLot parkingLot, User user) {
//        if (parkingLot.isNotEmpty() && Objects.nonNull(user.getVoucher()) && parkingLot.isParking(user.getVoucher())) {
////            parkingLot.PickCar(user.getVoucher());
//            user.setVoucher(null);
//            return "pick success";
//        }
//        user.setVoucher(null);
//        return "pick failing";
//    }
}
