package ai.fl.demofoods.controller;

import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.projection.AddressDTO;
import ai.fl.demofoods.projection.AddressProjection;
import ai.fl.demofoods.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 16.02.2022
 **/

@RestController
@RequestMapping("/api/deliveryAddress")
public class DeliveryAddressController {
    @Autowired
    DeliveryAddressService deliveryAddressService;

    @GetMapping("/getAllAddress")
    public List<?> getALl() {
        return deliveryAddressService.getAllAddress();
    }

    @GetMapping("/getByUserId/{userId}")
    public List<AddressProjection> getByUserId(@PathVariable UUID userId) {
        return deliveryAddressService.getByUserId(userId);
    }

    @PostMapping("/addAddress")
    public HttpEntity<?> saveAddress(@RequestBody AddressDTO addressDTO) {
        ApiResponce apiResponce = deliveryAddressService.saveAddress(addressDTO);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
    }
}
