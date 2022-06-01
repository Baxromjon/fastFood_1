package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.UserDTO;
import ai.fl.demofoods.repository.AttachmentRepository;
import ai.fl.demofoods.repository.UserRepository;
import ai.fl.demofoods.security.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AttachmentRepository attachmentRepository;

    public ApiResponce edit(UserDTO userDTO, User user) {
        if (passwordEncoder.matches(user.getPassword(), user.getPassword())){
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPassword(userDTO.getPassword());
            if (!user.getPhoneNumber().equals(user.getPhoneNumber())){
                if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber())){
                    return new ApiResponce(false, "Allready exists this phone");
                }
            }
            if (userDTO.getPhoto()!=null)
                user.setPhoto(attachmentRepository.findById(userDTO.getPhoto()).orElseThrow(() -> new ResourceNotFoundException("Photo not found"+userDTO.getPhoto())));
            user.setPhoneNumber(userDTO.getPhoneNumber());
            userRepository.save(user);
            return new ApiResponce(true,"Successfully edited");
        }else {
            return new ApiResponce(false,"Error in edit");
        }
    }

    public List<?> getAllUser() {
        return userRepository.findAll();
    }
}
