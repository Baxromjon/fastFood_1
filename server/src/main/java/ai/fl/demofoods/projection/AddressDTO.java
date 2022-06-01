package ai.fl.demofoods.projection;

import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.payload.FoodDTO;
import ai.fl.demofoods.payload.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 16.02.2022
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private UUID userId;
    private List<UserDTO> userList = new ArrayList<>();
    private String address;
    private String city;
    private String street;
    private String home;
    private long lat;
    private long lon;
    private UUID foodId;
    private List<FoodDTO> foodDTOList = new ArrayList<>();
}
