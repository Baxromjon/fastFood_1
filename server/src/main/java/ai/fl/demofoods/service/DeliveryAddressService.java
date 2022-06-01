package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.DeliveryAddress;
import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.projection.AddressDTO;
import ai.fl.demofoods.projection.AddressProjection;
import ai.fl.demofoods.repository.DeliveryAddressRepository;
import ai.fl.demofoods.repository.FoodRepository;
import ai.fl.demofoods.repository.UserRepository;
import ai.fl.demofoods.security.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 16.02.2022
 **/

@Service
public class DeliveryAddressService {
    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;

    public List<?> getAllAddress() {
        return deliveryAddressRepository.findAll();
    }

    public List<AddressProjection> getByUserId(UUID userId) {
        return deliveryAddressRepository.findByUsers(userId);
    }

    public ApiResponce saveAddress(AddressDTO addressDTO) {
        User user = userRepository.findById(addressDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("userId" + addressDTO.getUserId()));
        Food food = foodRepository.findById(addressDTO.getFoodId()).orElseThrow(() -> new ResourceNotFoundException("foodId" + addressDTO.getFoodId()));
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setAddress(addressDTO.getAddress());
        deliveryAddress.setCity(addressDTO.getCity());
        deliveryAddress.setHome(addressDTO.getHome());
        deliveryAddress.setStreet(addressDTO.getStreet());
        deliveryAddress.setUsers((List<User>) user);
        deliveryAddress.setFoods((List<Food>) food);
        deliveryAddress.setLat(addressDTO.getLat());
        deliveryAddress.setLon(addressDTO.getLon());
        deliveryAddressRepository.save(deliveryAddress);
        return new ApiResponce(true, "Successfully saved");
    }
}
