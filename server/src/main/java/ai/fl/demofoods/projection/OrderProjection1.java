package ai.fl.demofoods.projection;

import java.util.Date;
import java.util.UUID;

public interface OrderProjection1 {
    String getPrice();
    String getDate();
    String getFood();
    String getDrinks();
    String getStatus();
    String getPhoto();
}
