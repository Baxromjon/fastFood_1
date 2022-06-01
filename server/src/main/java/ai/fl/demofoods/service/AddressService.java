//package ai.fl.demofoods.service;
//
//import ai.fl.demofoods.entity.Address;
//import ai.fl.demofoods.entity.District;
//import ai.fl.demofoods.payload.AddressDTO;
//import ai.fl.demofoods.payload.ApiResponce;
//import ai.fl.demofoods.repository.AddressRepository;
//import ai.fl.demofoods.repository.DistrictRepository;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
///**
// * created by Baxromjon
// * 05.02.2022
// **/
//
//
//@Service
//public class AddressService {
//    @Autowired
//    AddressRepository addressRepository;
//    @Autowired
//    DistrictRepository districtRepository;
//
//    public List<Address> getAll() {
//        return addressRepository.findAll();
//    }
//
//    public Address getById(UUID id) {
//        return addressRepository.findById(id).get();
//    }
//
//    public ApiResponce add(AddressDTO addressDTO) {
//        District district = districtRepository.findById(addressDTO.getDistrictId()).orElseGet(District::new);
//        Address address = new Address(
//                addressDTO.getStreet(),
//                addressDTO.getHome(),
//                district
//        );
//        addressRepository.save(address);
//        return new ApiResponce(true, "Successfully saved");
//    }
//
//    public ApiResponce edit(UUID id, AddressDTO addressDTO) {
//        District district = districtRepository.findById(addressDTO.getDistrictId()).orElseGet(District::new);
//        Address address = addressRepository.findById(id).get();
//        address.setStreet(addressDTO.getStreet());
//        address.setHome(addressDTO.getHome());
//        address.setDistrict(district);
//        addressRepository.save(address);
//        return new ApiResponce(true, "Successfully edited");
//    }
//}
