package com.javaPayment.ps.api.payment.repository;

import com.javaPayment.ps.api.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
