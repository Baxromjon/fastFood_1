package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeasurementRepository extends JpaRepository<Measurement, UUID> {
}
