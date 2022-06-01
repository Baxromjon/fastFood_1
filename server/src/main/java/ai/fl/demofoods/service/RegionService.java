//package ai.fl.demofoods.service;
//
//import ai.fl.demofoods.entity.Country;
//import ai.fl.demofoods.entity.Region;
//import ai.fl.demofoods.payload.ApiResponce;
//import ai.fl.demofoods.payload.RegionDTO;
//import ai.fl.demofoods.repository.CountryRepository;
//import ai.fl.demofoods.repository.RegionRepository;
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
//public class RegionService {
//    @Autowired
//    RegionRepository regionRepository;
//    @Autowired
//    CountryRepository countryRepository;
//
//    public List<Region> getAll() {
//        return regionRepository.findAll();
//    }
//
//    public Region getById(UUID id) {
//        return regionRepository.getById(id);
//    }
//
//    public ApiResponce addRegion(RegionDTO regionDTO) {
//        Country country = countryRepository.getById(regionDTO.getCountryId());
//        Boolean exists = regionRepository.existsByNameAndCountry(regionDTO.getName(), country);
//        if (exists)
//            return new ApiResponce(false, "Region allReady exists");
//        Region region = new Region(
//                regionDTO.getName(),
//                country
//        );
//        regionRepository.save(region);
//        return new ApiResponce(true, "Successfully saved");
//    }
//
//    public ApiResponce edit(UUID id, RegionDTO regionDTO) {
//        Optional<Country> optional = countryRepository.findById(regionDTO.getCountryId());
//        Optional<Region> regionOptional = regionRepository.findById(id);
//        if (!optional.isPresent() || !regionOptional.isPresent())
//            return new ApiResponce(false, "Country or region id wrong!");
//        Region region = regionOptional.get();
//        region.setName(regionDTO.getName());
//        region.setCountry(optional.get());
//        regionRepository.save(region);
//        return new ApiResponce(true, "Successfully edited");
//    }
//
//    public ApiResponce delete(UUID id) {
//        try {
//            regionRepository.deleteById(id);
//            return new ApiResponce(true, "Successfully deleted");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new ApiResponce(false,"Error in delete");
//    }
//}
