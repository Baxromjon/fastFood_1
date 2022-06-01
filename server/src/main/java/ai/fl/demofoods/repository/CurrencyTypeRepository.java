package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, UUID> {
    boolean existsByName(String name);
}
