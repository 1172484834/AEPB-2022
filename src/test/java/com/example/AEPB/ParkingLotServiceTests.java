package com.example.AEPB;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.User;
import com.example.AEPB.entity.Voucher;
import com.example.AEPB.service.Impl.ParkingLotServiceImpl;
import com.example.AEPB.service.ParkingLotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ParkingLotServiceTests {
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
        List<ParkingLot> parkingLots = List.of(ParkingLot.builder()
                        .quantity(20)
                        .parkingLotName("停车场1")
                        .carSet(new HashSet<>()).build(),
                ParkingLot.builder()
                        .quantity(25)
                        .parkingLotName("停车场2")
                        .carSet(new HashSet<>()).build());
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

        Boolean parkResult = parkingLotService.parkByParker(parkingLots, car);

        Assertions.assertTrue(parkResult);
        Assertions.assertEquals(19, parkingLots.get(0).getRemainCarQuantity());
        Assertions.assertEquals(25, parkingLots.get(1).getRemainCarQuantity());
    }

    @Test
    void parking_one_car_success_when_park_by_parker_given_park1_park_full_but_park2_is_empty() {

    }

    @Test
    void should_parking_car_failed_when_dont_have_park() {
//        ParkingLot parkingLot = ParkingLot.builder().quantity(20).carSet(new ArrayList<>()).build();
        for (int i = 0; i < 20; i++) {
//            parkingLot.getCarSet().add(new Car());
        }
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        User user = User.builder().name("用户1").build();

//        Assertions.assertEquals("park failing", parkingLotService.park(parkingLot, user, car));
    }

    @Test
    void should_pick_car_success_when_have_correct_voucher() {
//        ParkingLot parkingLot = ParkingLot.builder().quantity(20).carSet(new ArrayList<>()).build();

        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        User user = User.builder().name("用户1").build();
//        parkingLotService.park(parkingLot, user, car);

//        Assertions.assertEquals("pick success", parkingLotService.pick(parkingLot, user));
//        Assertions.assertEquals(20, parkingLot.getQuantity() - parkingLot.getCarSet().size());


    }

    @Test
    void should_pick_car_failed_when_dont_have_car() {
//        ParkingLot parkingLot = ParkingLot.builder().quantity(20).carSet(new ArrayList<>()).build();

        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        User user = User.builder().name("用户1").build();
//        Voucher voucher = Voucher.builder().user(user).car(car).build();
//        user.setVoucher(voucher);

//        Assertions.assertEquals("pick failing", parkingLotService.pick(parkingLot, user));
        Assertions.assertNull(user.getVoucher());
//        Assertions.assertEquals(20, parkingLot.getQuantity() - parkingLot.getCarSet().size());
    }

    @Test
    void should_pick_car_failed_when_dont_have_voucher() {
//        ParkingLot parkingLot = ParkingLot.builder().quantity(20).carSet(new ArrayList<>()).build();

        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();
        User user = User.builder().name("用户1").build();
//        parkingLotService.park(parkingLot, user, car);
        user.setVoucher(null);

//        Assertions.assertEquals("pick failing", parkingLotService.pick(parkingLot, user));
        Assertions.assertEquals(null, user.getVoucher());
//        Assertions.assertEquals(19, parkingLot.getQuantity() - parkingLot.getCarSet().size());
    }

}
