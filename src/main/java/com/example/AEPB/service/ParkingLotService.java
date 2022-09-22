package com.example.AEPB.service;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.User;

public interface ParkingLotService {

    public String Park(ParkingLot parkingLot, User user, Car car);

    public String Pick(ParkingLot parkingLot, User user);
}
