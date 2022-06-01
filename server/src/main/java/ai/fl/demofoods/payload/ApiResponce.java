package ai.fl.demofoods.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponce {
    private boolean isSuccess;
    private String message;
    private Object object;

    public ApiResponce(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ApiResponce(boolean isSuccess, Object object) {
        this.isSuccess = isSuccess;
        this.object = object;
    }

    public ApiResponce(String message, Object object) {
        this.message = message;
        this.object = object;
    }
}
