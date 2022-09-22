package com.example.AEPB.service.Impl;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.Parker;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.Voucher;
import com.example.AEPB.service.ParkingLotService;

import java.util.List;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final Parker parker = new Parker();

    @Override
    public Boolean park(ParkingLot parkingLot, Car car) {
        return parkingLot.park(car);
    }

    @Override
    public Boolean parkByParker(List<ParkingLot> parkingLots, Car car) {
        return parker.parkCar(parkingLots, car);
    }

    @Override
    public Boolean pick(ParkingLot currentParkLot, Voucher voucher) {
        if (currentParkLot.equals(voucher.getParkingLot())) {
            return voucher.getParkingLot().pickCar(voucher.getCar());
        }
        return false;
    }

    @Override
    public Boolean pickByParker(List<ParkingLot> parkingLots, Voucher voucher) {
        return parker.pickCar(parkingLots, voucher);
    }

}
