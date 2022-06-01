//package ai.fl.demofoods.service;
//
//import ai.fl.demofoods.entity.District;
//import ai.fl.demofoods.entity.Region;
//import ai.fl.demofoods.payload.ApiResponce;
//import ai.fl.demofoods.payload.DistrictDTO;
//import ai.fl.demofoods.repository.DistrictRepository;
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
//public class DistrictService {
//    @Autowired
//    DistrictRepository districtRepository;
//    @Autowired
//    RegionRepository regionRepository;
//
//    public List<District> getAll() {
//        return districtRepository.findAll();
//    }
//
//    public District getById(UUID id) {
//        Optional<District> optional = districtRepository.findById(id);
//        return optional.get();
//    }
//
//    public ApiResponce add(DistrictDTO districtDTO) {
//        Optional<Region> optional = regionRepository.findById(districtDTO.getRegionId());
//        Boolean exists = districtRepository.existsByNameAndRegion(districtDTO.getName(), optional.get());
//        if (exists)
//            return new ApiResponce(false, "AllReady exists");
//        District district = new District(
//                districtDTO.getName(),
//                optional.get()
//        );
//        districtRepository.save(district);
//        return new ApiResponce(true, "Successfully saved");
//    }
//
//    public ApiResponce edit(UUID id, DistrictDTO districtDTO) {
//        Region region = regionRepository.findById(districtDTO.getRegionId()).orElseGet(Region::new);
//        Boolean exists = districtRepository.existsByNameAndRegion(districtDTO.getName(), region);
//        if (exists)
//            return new ApiResponce(false, "District not found");
//        District district = districtRepository.findById(id).get();
//        district.setName(districtDTO.getName());
//        district.setRegion(region);
//        districtRepository.save(district);
//        return new ApiResponce(true, "Successfully edited");
//    }
//
//    public ApiResponce delete(UUID id) {
//        try {
//            districtRepository.deleteById(id);
//            return new ApiResponce(true, "Successfully deleted");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return new ApiResponce(false, "Error in delete");
//    }
//}
