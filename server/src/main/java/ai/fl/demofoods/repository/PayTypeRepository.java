package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.CurrencyType;
import ai.fl.demofoods.entity.PayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayTypeRepository extends JpaRepository<PayType, UUID> {
    boolean existsByNameAndCurrencyType(String name, CurrencyType currencyType);
}
