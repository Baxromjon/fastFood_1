package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.Order;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.OrderDTO;
import ai.fl.demofoods.projection.OrderProjection;
import ai.fl.demofoods.projection.OrderProjection1;
import ai.fl.demofoods.security.CurrentUser;
import ai.fl.demofoods.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAll")
    public List<?> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getById/{id}")
    public Order getById(@PathVariable UUID id) {
        return orderService.getById(id);
    }

    @GetMapping("/getAllByUserId/{userId}")
    public ApiResponce getAllOrderByUserId(@PathVariable UUID userId) {
        return orderService.getAllOrdersByUserId(userId);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody OrderDTO orderDTO) {
        ApiResponce apiResponce = orderService.addOrder(orderDTO);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody OrderDTO orderDTO) {
        ApiResponce edit = orderService.edit(id, orderDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
    }

    @GetMapping("/getByUserId/{userId}")
    public List<OrderProjection1> getByUserId(@PathVariable UUID userId) {
        return orderService.getByUserId(userId);
    }
}
