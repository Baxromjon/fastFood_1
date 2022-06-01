//package ai.fl.demofoods.controller;
//
//import ai.fl.demofoods.entity.Country;
//import ai.fl.demofoods.payload.CountryDTO;
//import ai.fl.demofoods.service.CountryService;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
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
//@RequestMapping("/api/country")
//public class CountryController {
//    @Autowired
//    CountryService countryService;
//
//    @GetMapping("/getAllCountry")
//    public List<Country> getAllCountry(){
//        return countryService.getAllCountry();
//    }
//
//    @GetMapping("/getById/{id}")
//    public Country getCountryById(@PathVariable UUID id){
//        return countryService.getById(id);
//    }
//
//}
