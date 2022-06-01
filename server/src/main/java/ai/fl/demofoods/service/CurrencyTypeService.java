package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.CurrencyType;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.CurrencyTypeDTO;
import ai.fl.demofoods.repository.CurrencyTypeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Service
public class CurrencyTypeService {
    @Autowired
    CurrencyTypeRepository currencyTypeRepository;

    public List<?> getAll() {
        return currencyTypeRepository.findAll();
    }

    public CurrencyType getById(UUID id) {
        Optional<CurrencyType> optional = currencyTypeRepository.findById(id);
        return optional.orElseGet(CurrencyType::new);
    }

    public ApiResponce add(CurrencyTypeDTO currencyTypeDTO) {
        boolean exists = currencyTypeRepository.existsByName(currencyTypeDTO.getName());
        if (exists)
            return new ApiResponce(false, "allReady exists");
        CurrencyType currencyType = new CurrencyType(
                currencyTypeDTO.getName(),
                currencyTypeDTO.getDescription()
        );
        currencyTypeRepository.save(currencyType);
        return new ApiResponce(true, "Successfully added");
    }

    public ApiResponce edit(UUID id, CurrencyTypeDTO currencyTypeDTO) {
        Optional<CurrencyType> optional = currencyTypeRepository.findById(id);
        if (!optional.isPresent())
            return new ApiResponce(false, "CurrencyType not found by given ID");
        CurrencyType currencyType = optional.get();
        currencyType.setName(currencyTypeDTO.getName());
        currencyType.setDescription(currencyTypeDTO.getDescription());
        currencyTypeRepository.save(currencyType);
        return new ApiResponce(true, "Successfully edited");
    }
}
