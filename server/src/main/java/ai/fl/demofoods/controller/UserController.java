package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.UserDTO;
import ai.fl.demofoods.projection.UserProjection1;
import ai.fl.demofoods.repository.UserRepository;
import ai.fl.demofoods.security.CurrentUser;
import ai.fl.demofoods.service.UserService;
import ai.fl.demofoods.utils.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/me")
    public HttpEntity<?> getUserMe(@CurrentUser User user) {
        return ResponseEntity.ok(new ApiResponce(true, "Success", user));
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody UserDTO userDTO, @CurrentUser User user) {
        ApiResponce edit = userService.edit(userDTO, user);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
    }

    @GetMapping("/getAllUser")
    public HttpEntity<?> getAllUser(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                              @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        List<User> client = userRepository.getUserListWithPageable("CLIENT", size, page * size);
        return ResponseEntity.ok(client);
    }
}
