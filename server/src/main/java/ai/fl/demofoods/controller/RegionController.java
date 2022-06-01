//package ai.fl.demofoods.controller;
//
//import ai.fl.demofoods.entity.Region;
//import ai.fl.demofoods.payload.ApiResponce;
//import ai.fl.demofoods.payload.RegionDTO;
//import ai.fl.demofoods.service.RegionService;
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
//@RequestMapping("/api/region")
//public class RegionController {
//    @Autowired
//    RegionService regionService;
//
//    @GetMapping("/getAllRegion")
//    public List<Region> getAll() {
//        return regionService.getAll();
//    }
//
//    @GetMapping("/getById/{id}")
//    public Region getById(@PathVariable UUID id) {
//        return regionService.getById(id);
//    }
//
//    @PostMapping("/add")
//    public HttpEntity<?> addRegion(@RequestBody RegionDTO regionDTO) {
//        ApiResponce apiResponce = regionService.addRegion(regionDTO);
//        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
//    }
//
//    @PutMapping("/edit/{id}")
//    public HttpEntity<?> editRegion(@PathVariable UUID id, @RequestBody RegionDTO regionDTO) {
//        ApiResponce edit = regionService.edit(id, regionDTO);
//        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(edit);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public HttpEntity<?> delete(@PathVariable UUID id) {
//        ApiResponce delete = regionService.delete(id);
//        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(delete);
//    }
//}
