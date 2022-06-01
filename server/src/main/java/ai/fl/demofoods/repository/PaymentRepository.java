package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Order;
import ai.fl.demofoods.entity.Payment;
import ai.fl.demofoods.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    boolean existsByAmountAndUserAndOrder(double amount, User user, Order order);
}
