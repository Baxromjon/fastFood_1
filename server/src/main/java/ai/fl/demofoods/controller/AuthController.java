package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.LoginDTO;
import ai.fl.demofoods.payload.RegisterDto;
import ai.fl.demofoods.payload.UserDTO;
import ai.fl.demofoods.repository.UserRepository;
import ai.fl.demofoods.security.JwtTokenProvider;
import ai.fl.demofoods.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @PostMapping("/register")
    public HttpEntity<?> register(@Valid @RequestBody RegisterDto registerDto) {
        ApiResponce register = authService.register(registerDto);
        try {
            return ResponseEntity.status(register.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(register);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/login")
    public HttpEntity<?> checkLogin(@Valid @RequestBody LoginDTO userDTO) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            userDTO.getPhoneNumber(),
                            userDTO.getPassword()
                    ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = (User) authentication.getPrincipal();
            String token = jwtTokenProvider.generateToken(user.getId());
            return ResponseEntity.status(200).body(new ApiResponce(true, "Successfully", token));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ResponseEntity.status(409).body(new ApiResponce(false, "Bad Credentials"));
    }
}
