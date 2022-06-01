package ai.fl.demofoods.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * created by Baxromjon
 * 05.02.2022
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    private String name;
    private UUID regionId;
}
