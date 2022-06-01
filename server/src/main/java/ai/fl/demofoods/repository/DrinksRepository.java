package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Drinks;
import ai.fl.demofoods.entity.ValueMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DrinksRepository extends JpaRepository<Drinks, UUID> {
    Boolean existsByNameAndValueMeasurement(String name, ValueMeasurement valueMeasurement);
}
