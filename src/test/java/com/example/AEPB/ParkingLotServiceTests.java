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
    void should_parking_one_car_success_when_park_by_user_given_park1_have_twenty_cars() {
        ParkingLot parkingLot = ParkingLot.builder().quantity(20).carSet(new HashSet<>()).build();
        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

//        String message = parkingLotService.park(parkingLot, car);

//        Assertions.assertEquals("park success", message);
        Assertions.assertTrue(parkingLot.isParking(car));
        Assertions.assertEquals(19, parkingLot.getRemainCarQuantity());
    }

    @Test
    void should_parking_one_car_success_when_park_by_user_given_park2_have_twenty_five_cars() {
        ParkingLot parkingLot = ParkingLot.builder().quantity(25).carSet(new HashSet<>()).build();

        Car car = Car.builder().name("车辆1").plateNumber("车牌A").build();

//        Assertions.assertEquals("park success", parkingLotService.park(parkingLot, user, car));
//        Assertions.assertEquals(car, user.getVoucher().getCar());
//        Assertions.assertEquals(user, user.getVoucher().getUser());
        Assertions.assertEquals(9, parkingLot.getQuantity() - parkingLot.getCarSet().size());
    }

    @Test
    void parking_four_cars_when_have_two_park() {
//        ParkingLot parkingLot = ParkingLot.builder().quantity(20).carSet(new ArrayList<>()).build();
        for (int i = 0; i < 18; i++) {
//            parkingLot.getCarSet().add(new Car());
        }
        List<Car> carList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        for (Integer i = 1; i <= 4; i++) {
            carList.add(Car.builder().name("车辆"+i.toString()).plateNumber("车牌"+(char)('A'+i-1)).build());
            userList.add(User.builder().name("用户"+i.toString()).build());
        }

//        Assertions.assertEquals("park success", parkingLotService.park(parkingLot, userList.get(0), carList.get(0)));
        Assertions.assertEquals(carList.get(0), userList.get(0).getVoucher().getCar());
//        Assertions.assertEquals(userList.get(0), userList.get(0).getVoucher().getUser());
//        Assertions.assertEquals(1, parkingLot.getQuantity() - parkingLot.getCarSet().size());

//        Assertions.assertEquals("park success", parkingLotService.park(parkingLot, userList.get(1), carList.get(1)));
        Assertions.assertEquals(carList.get(1), userList.get(1).getVoucher().getCar());
//        Assertions.assertEquals(userList.get(1), userList.get(1).getVoucher().getUser());
//        Assertions.assertEquals(0, parkingLot.getQuantity() - parkingLot.getCarSet().size());

//        Assertions.assertEquals("park failing", parkingLotService.park(parkingLot, userList.get(0), carList.get(0)));

//        Assertions.assertEquals("park failing", parkingLotService.park(parkingLot, userList.get(0), carList.get(0)));
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
