package com.eventostec.api.repositories;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
}
