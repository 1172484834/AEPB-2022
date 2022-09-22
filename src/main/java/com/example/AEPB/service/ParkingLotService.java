package com.example.AEPB.service;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.User;

import java.util.List;

public interface ParkingLotService {

    public Boolean park(ParkingLot parkingLot, Car car);

    public String pick(ParkingLot parkingLot, User user);

    Boolean parkByParker(List<ParkingLot> parkingLots, Car car);
}
