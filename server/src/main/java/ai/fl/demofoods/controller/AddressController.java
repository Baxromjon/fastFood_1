//package ai.fl.demofoods.controller;
//
//import ai.fl.demofoods.entity.Address;
//import ai.fl.demofoods.payload.AddressDTO;
//import ai.fl.demofoods.payload.ApiResponce;
//import ai.fl.demofoods.service.AddressService;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
///**
// * created by Baxromjon
// * 05.02.2022
// **/
//
//
//@RestController
//@RequestMapping("/api/address")
//public class AddressController {
//    @Autowired
//    AddressService addressService;
//
//    @GetMapping("/getAll")
//    public List<Address> getAll() {
//        return addressService.getAll();
//    }
//
//    @GetMapping("/getById/{id}")
//    public Address getById(@PathVariable UUID id) {
//        return addressService.getById(id);
//    }
//
//    @PostMapping("/add")
//    public HttpEntity<?> add(@RequestBody AddressDTO addressDTO) {
//        ApiResponce add = addressService.add(addressDTO);
//        return ResponseEntity.status(add.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(add);
//    }
//
//    @PutMapping("/edit/{id}")
//    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody AddressDTO addressDTO) {
//        ApiResponce edit = addressService.edit(id, addressDTO);
//        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
//    }
//}
