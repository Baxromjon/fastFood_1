package ai.fl.demofoods.projection;

import java.sql.Timestamp;

public interface OrderProjection {
    String getDrink();
    String getFood();
    Timestamp getCreatedAt();
    double getTotalPrice();
    String getMeasurement();
    String getMeasurementValue();
}
