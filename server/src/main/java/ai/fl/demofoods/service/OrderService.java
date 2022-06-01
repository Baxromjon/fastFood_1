package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Drinks;
import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.entity.Order;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.entity.enums.OrderStatus;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.OrderDTO;
import ai.fl.demofoods.projection.OrderProjection;
import ai.fl.demofoods.projection.OrderProjection1;
import ai.fl.demofoods.repository.DrinksRepository;
import ai.fl.demofoods.repository.FoodRepository;
import ai.fl.demofoods.repository.OrderRepository;
import ai.fl.demofoods.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    DrinksRepository drinksRepository;
    @Autowired
    UserRepository userRepository;

    public List<?> getAllOrders() {
        return orderRepository.getAllOrder();
    }

    public Order getById(UUID id) {
        Optional<Order> byId = orderRepository.findById(id);
        return byId.orElseGet(Order::new);
    }

    public ApiResponce addOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId()).orElseGet(User::new);
        Food food = foodRepository.findById(orderDTO.getFoodId()).orElseGet(Food::new);
        Drinks drinks = drinksRepository.findById(orderDTO.getDrinksId()).orElseGet(Drinks::new);
        Order order = new Order(
                food, drinks, user, orderDTO.getTotalPrice(), OrderStatus.NEW
        );
        orderRepository.save(order);
        return new ApiResponce(true, "Successfully ordered");
    }

    public ApiResponce edit(UUID id, OrderDTO orderDTO) {
        Food food = foodRepository.findById(orderDTO.getFoodId()).orElseGet(Food::new);
        Drinks drinks = drinksRepository.findById(orderDTO.getDrinksId()).orElseGet(Drinks::new);
        Optional<Order> optional = orderRepository.findById(id);
        if (!optional.isPresent())
            return new ApiResponce(false, "Order not found by given Id");
        Order order = optional.get();
        order.setFood(food);
        order.setDrinks(drinks);
        order.setTotalPrice(order.getTotalPrice());
        order.setOrderStatus(OrderStatus.NEW);
        orderRepository.save(order);
        return new ApiResponce(true, "Successfully edited order");
    }

    public ApiResponce getAllOrdersByUserId(UUID userId) {
        return new ApiResponce(true, orderRepository.getAllOrdersByUserId(userId));
    }

    public List<OrderProjection1> getByUserId(UUID userId) {
        return orderRepository.getByUserId(userId);
    }
}
