package ai.fl.demofoods.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyTypeDTO {
    private String name;
    private String description;
}
