package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.Payment;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.PaymentDTO;
import ai.fl.demofoods.security.CurrentUser;
import ai.fl.demofoods.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/getAll")
    public List<?> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Payment getById(@PathVariable UUID id) {
        return paymentService.getById(id);
    }

//    @PreAuthorize("hasAnyRole=('CLIENT')")
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody PaymentDTO paymentDTO, @CurrentUser User user) {
        ApiResponce add = paymentService.add(paymentDTO, user);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(add);
    }
//    @GetMapping("/getAllPaymentByUserId")
//    public List<UserProjection> getAll()

}
