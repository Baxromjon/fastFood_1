package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Order;
import ai.fl.demofoods.entity.PayType;
import ai.fl.demofoods.entity.Payment;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.PaymentDTO;
import ai.fl.demofoods.repository.OrderRepository;
import ai.fl.demofoods.repository.PayTypeRepository;
import ai.fl.demofoods.repository.PaymentRepository;
import ai.fl.demofoods.repository.UserRepository;
import ai.fl.demofoods.security.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PayTypeRepository payTypeRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<?> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(UUID id) {
        Optional<Payment> byId = paymentRepository.findById(id);
        return byId.orElseGet(Payment::new);
    }

    public ApiResponce add(PaymentDTO paymentDTO, User user) {
        PayType payType = payTypeRepository.findById(paymentDTO.getPayTypeId()).orElseThrow(() -> new ResourceNotFoundException("Pay Type not found" + paymentDTO.getPayTypeId()));
        Order order = orderRepository.findById(paymentDTO.getOrderId()).orElseThrow(() -> new ResourceNotFoundException("Order not found" + paymentDTO.getOrderId()));
        boolean exists = paymentRepository.existsByAmountAndUserAndOrder(paymentDTO.getAmount(), user, order);
        if (exists)
            return new ApiResponce(false, "All ready payed");
        Payment payment = new Payment(
                user, payType, order, paymentDTO.getAmount(), LocalDate.now(), paymentDTO.getDescription()
        );
        paymentRepository.save(payment);
        return new ApiResponce(true, "Payed");
    }
}
