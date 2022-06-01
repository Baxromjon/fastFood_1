package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.CurrencyType;
import ai.fl.demofoods.entity.PayType;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.PayTypeDTO;
import ai.fl.demofoods.repository.CurrencyTypeRepository;
import ai.fl.demofoods.repository.PayTypeRepository;
import ai.fl.demofoods.security.ResourceNotFoundException;
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
public class PayTypeService {
    @Autowired
    PayTypeRepository payTypeRepository;
    @Autowired
    CurrencyTypeRepository currencyTypeRepository;

    public List<?> getAll() {
        return payTypeRepository.findAll();
    }

    public PayType getById(UUID id) {
        Optional<PayType> optional = payTypeRepository.findById(id);
        return optional.orElseGet(PayType::new);
    }

    public ApiResponce add(PayTypeDTO payTypeDTO) {
        Optional<CurrencyType> currencyTypeOptional = currencyTypeRepository.findById(payTypeDTO.getCurrencyTypeId());
        if (!currencyTypeOptional.isPresent())
            return new ApiResponce(false, "Currency Type not found");
        PayType payType = new PayType(
                payTypeDTO.getName(), currencyTypeOptional.get()
        );
        payTypeRepository.save(payType);
        return new ApiResponce(true, "Successfully added");
    }

    public ApiResponce edit(UUID id, PayTypeDTO payTypeDTO) {
        CurrencyType currencyType = currencyTypeRepository.findById(payTypeDTO.getCurrencyTypeId()).orElseThrow(() -> new ResourceNotFoundException("Currency Type not found by given id" + payTypeDTO.getCurrencyTypeId()));
        Optional<PayType> payTypeOptional = payTypeRepository.findById(id);
        boolean exists = payTypeRepository.existsByNameAndCurrencyType(payTypeDTO.getName(), currencyType);
        if (exists)
            return new ApiResponce(false, "All Ready exists");
        PayType payType = payTypeOptional.get();
        payType.setName(payTypeDTO.getName());
        payType.setCurrencyType(currencyType);
        payTypeRepository.save(payType);
        return new ApiResponce(true, "Successfully edited");
    }

    public ApiResponce delete(UUID id) {
        try {
            payTypeRepository.deleteById(id);
            return new ApiResponce(true, "Successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponce(false, "Error in delete");
    }
}
