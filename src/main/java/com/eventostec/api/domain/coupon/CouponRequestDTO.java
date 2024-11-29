package com.eventostec.api.domain.coupon;

import org.springframework.web.multipart.MultipartFile;

public record CouponRequestDTO(String code, Integer discount, Long valid) {
}