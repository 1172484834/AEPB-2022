package com.example.AEPB.entity;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    private User user;

    private Car car;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return Objects.equals(user, voucher.user) && Objects.equals(car, voucher.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, car);
    }
}
