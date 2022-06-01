package ai.fl.demofoods.payload;

import ai.fl.demofoods.utils.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidPassword(password = "password", prePassword = "prePassword")
public class RegisterDto {

    private UUID id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp = "\\(?\\+[0-9]{1,3}\\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{5}( ?-?[0-9]{3})? ?(\\w{1,10}\\s?\\d{1,6})?")
    private String phoneNumber;

    @NotBlank
    @Size(min = 6, max = 12)
    private String password;

    @NotBlank
    @Size(min = 6, max = 12)
    private String prePassword;
}
