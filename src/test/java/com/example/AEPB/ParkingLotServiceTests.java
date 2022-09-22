package com.example.AEPB;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.Voucher;
import com.example.AEPB.service.Impl.ParkingLotServiceImpl;
import com.example.AEPB.service.ParkingLotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;


class ParkingLotServiceTests {
    private final ParkingLotService parkingLotService = new ParkingLotServiceImpl();

    @Test
    void should_parking_one_car_success_when_park_by_user_given_park1_have_zero_cars() {
        ParkingLot parkingLot = ParkingLot.builder()
                .quantity(20)
                .parkingLotName("停车场1")
                .carSet(new HashSet<>()).build();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

        Boolean parkResult = parkingLotService.park(parkingLot, car);

        Assertions.assertTrue(parkResult);
        Assertions.assertTrue(parkingLot.isParking(car));
        Assertions.assertEquals(19, parkingLot.getRemainCarQuantity());
    }

    @Test
    void should_parking_one_car_success_when_park_by_parker_given_park1_have_zero_cars() {
        List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

        Boolean parkResult = parkingLotService.parkByParker(parkingLots, car);

        Assertions.assertTrue(parkResult);
        Assertions.assertEquals(19, parkingLots.get(0).getRemainCarQuantity());
        Assertions.assertEquals(25, parkingLots.get(1).getRemainCarQuantity());
    }

    @Test
    void parking_one_car_success_when_park_by_parker_given_park1_park_full_but_park2_is_empty() {
        List<ParkingLot> parkingLots = getParkingLots();
        parkFull(parkingLots.get(0));
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

        final Boolean parkResult = parkingLotService.parkByParker(parkingLots, car);

        Assertions.assertTrue(parkResult);
        Assertions.assertEquals(0, parkingLots.get(0).getRemainCarQuantity());
        Assertions.assertEquals(24, parkingLots.get(1).getRemainCarQuantity());
        Assertions.assertTrue(parkingLots.get(1).getCarSet().contains(car));
    }

    @Test
    void should_pick_success_when_pick_car_by_user_given_park1_have_user_car() {
        final List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        parkingLots.get(0).park(car);
        final Voucher voucher = Voucher.builder().parkingLot(parkingLots.get(0)).car(car).build();

        final Boolean pickResult = parkingLotService.pick(parkingLots.get(0), voucher);

        Assertions.assertTrue(pickResult);
        Assertions.assertFalse(parkingLots.get(0).getCarSet().contains(car));
    }

    @Test
    void should_pick_car_success_when_pick_car_by_parker_given_park1_have_user_car() {
        final List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        parkingLots.get(0).park(car);
        final Voucher voucher = Voucher.builder().parkingLot(parkingLots.get(0)).car(car).build();

        final Boolean pickResult = parkingLotService.pickByParker(parkingLots, voucher);

        Assertions.assertTrue(pickResult);
        Assertions.assertFalse(parkingLots.get(0).getCarSet().contains(car));
    }

    @Test
    void should_pick_car_success_when_pick_car_by_parker_given_park2_have_user_car() {
        final List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        parkingLots.get(1).park(car);
        final Voucher voucher = Voucher.builder().parkingLot(parkingLots.get(0)).car(car).build();

        final Boolean pickResult = parkingLotService.pickByParker(parkingLots, voucher);

        Assertions.assertTrue(pickResult);
        Assertions.assertFalse(parkingLots.get(1).getCarSet().contains(car));
    }

    @Test
    void should_park_car_failed_when_park_by_user_given_park1_park_full() {
        final List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        parkFull(parkingLots.get(0));

        final Boolean parkResult = parkingLotService.park(parkingLots.get(0), car);

        Assertions.assertFalse(parkResult);
    }

    @Test
    void should_park_car_failed_when_park_by_parker_given_all_parking_lot_park_full() {
        final List<ParkingLot> parkingLots = getParkingLots();
        for (ParkingLot parkingLot : parkingLots) {
            parkFull(parkingLot);
        }
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

        final Boolean parkResult = parkingLotService.parkByParker(parkingLots, car);

        Assertions.assertFalse(parkResult);
    }

    @Test
    void should_pick_failed_when_pick_by_user_given_no_exist_car() {
        final List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        final Voucher voucher = Voucher.builder().car(car).parkingLot(parkingLots.get(0)).build();

        final Boolean pickResult = parkingLotService.pick(parkingLots.get(0), voucher);

        Assertions.assertFalse(pickResult);
    }

    @Test
    void should_pick_failed_when_pick_by_parker_given_no_exist_car() {
        final List<ParkingLot> parkingLots = getParkingLots();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        final Voucher voucher = Voucher.builder().car(car).parkingLot(parkingLots.get(0)).build();

        final Boolean pickResult = parkingLotService.pickByParker(parkingLots, voucher);

        Assertions.assertFalse(pickResult);
    }


    private void parkFull(ParkingLot parkingLot) {
        for (int i = 0; i < parkingLot.getQuantity(); i++) {
            parkingLot.park(Car.builder().name("+" + i + "").build());
        }
    }

    private List<ParkingLot> getParkingLots() {
        return List.of(ParkingLot.builder()
                        .quantity(20)
                        .parkingLotName("停车场1")
                        .carSet(new HashSet<>()).build(),
                ParkingLot.builder()
                        .quantity(25)
                        .parkingLotName("停车场2")
                        .carSet(new HashSet<>()).build());
    }
}
