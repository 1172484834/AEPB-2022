package com.example.AEPB.entity;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;

    private Voucher voucher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(voucher, user.voucher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, voucher);
    }
}
