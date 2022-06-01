//package ai.fl.demofoods.controller;
//
//import ai.fl.demofoods.entity.District;
//import ai.fl.demofoods.payload.ApiResponce;
//import ai.fl.demofoods.payload.DistrictDTO;
//import ai.fl.demofoods.service.DistrictService;
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
//@RequestMapping("/api/district")
//public class DistrictController {
//    @Autowired
//    DistrictService districtService;
//
//    @GetMapping("/getAll")
//    public List<District> getAll() {
//        return districtService.getAll();
//    }
//
//    @GetMapping("/getById/{id}")
//    public District getById(@PathVariable UUID id) {
//        return districtService.getById(id);
//    }
//
//    @PostMapping("/add")
//    public HttpEntity<?> add(@RequestBody DistrictDTO districtDTO) {
//        ApiResponce add = districtService.add(districtDTO);
//        return ResponseEntity.status(add.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(add);
//    }
//
//    @PutMapping("/edit/{id}")
//    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody DistrictDTO districtDTO) {
//        ApiResponce edit = districtService.edit(id, districtDTO);
//        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public HttpEntity<?> delete(@PathVariable UUID id) {
//        ApiResponce delete = districtService.delete(id);
//        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(delete);
//    }
//}
