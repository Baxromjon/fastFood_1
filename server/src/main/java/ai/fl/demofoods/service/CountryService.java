//package ai.fl.demofoods.service;
//
//import ai.fl.demofoods.entity.Country;
//import ai.fl.demofoods.repository.CountryRepository;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
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
//@Service
//public class CountryService {
//    @Autowired
//    CountryRepository countryRepository;
//
//    public List<Country> getAllCountry() {
//        return countryRepository.findAll();
//    }
//
//    public Country getById(UUID id) {
//        return countryRepository.getById(id);
//    }
//}
