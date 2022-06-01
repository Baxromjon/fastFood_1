package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.ValueMeasurement;
import ai.fl.demofoods.projection.ValueMeasurementProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ValueMeasurementRepository extends JpaRepository<ValueMeasurement, UUID> {
    @Query(nativeQuery = true, value = "select cast(vm.id as varchar) as id, vm.name as name from value_measurement vm\n" +
            "where vm.measurement_id=:measurementId")
    List<ValueMeasurementProjection> getByMeasurementId(@PathVariable UUID measurementId);
}
