package com.example.AEPB.service;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.Voucher;

import java.util.List;

public interface ParkingLotService {

    Boolean park(ParkingLot parkingLot, Car car);

    Boolean parkByParker(List<ParkingLot> parkingLots, Car car);

    Boolean pick(ParkingLot currentParkLot,Voucher voucher);

    Boolean pickByParker(List<ParkingLot> parkingLots, Voucher voucher);
}
