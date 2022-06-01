package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Role;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.entity.enums.RoleName;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.RegisterDto;
import ai.fl.demofoods.repository.RoleRepository;
import ai.fl.demofoods.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        return userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new UsernameNotFoundException("userId"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(s);
    }

    public ApiResponce register(RegisterDto registerDto) {
        List<Role> role = roleRepository.findByRoleName(RoleName.CLIENT);
        Optional<User> optional = userRepository.findByPhoneNumberAndRolesIn(registerDto.getPhoneNumber(), role);
        User user = optional.orElseGet(User::new);
        boolean exists = userRepository.existsByPhoneNumber(registerDto.getPhoneNumber());
        if (exists) {
            return new ApiResponce(false, "AllReady exists");
        }
        if (!optional.isPresent()) {
            user.setFirstName(registerDto.getFirstName());
            user.setLastName(registerDto.getLastName());
            user.setPhoneNumber(registerDto.getPhoneNumber());
            user.setRoles(role);
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        }
        userRepository.save(user);
        return new ApiResponce(true, "Successfully");

    }

    private String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
