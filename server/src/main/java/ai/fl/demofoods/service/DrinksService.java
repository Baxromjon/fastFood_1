package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Attachment;
import ai.fl.demofoods.entity.Drinks;
import ai.fl.demofoods.entity.ValueMeasurement;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.DrinksDTO;
import ai.fl.demofoods.repository.AttachmentRepository;
import ai.fl.demofoods.repository.DrinksRepository;
import ai.fl.demofoods.repository.ValueMeasurementRepository;
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
 * 07.02.2022
 **/

@Service
public class DrinksService {
    @Autowired
    DrinksRepository drinksRepository;
    @Autowired
    ValueMeasurementRepository valueMeasurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Drinks> getAll() {
        return drinksRepository.findAll();
    }

    public Drinks getById(UUID id) {
        Optional<Drinks> optional = drinksRepository.findById(id);
        return optional.orElseGet(Drinks::new);
    }

    public ApiResponce save(DrinksDTO drinksDTO) {
        ValueMeasurement valueMeasurement = valueMeasurementRepository.findById(drinksDTO.getValueId()).orElseGet(ValueMeasurement::new);
        Boolean exists = drinksRepository.existsByNameAndValueMeasurement(drinksDTO.getName(), valueMeasurement);
        Attachment attachment = attachmentRepository.findById(drinksDTO.getPhotoId()).orElseGet(Attachment::new);
        if (exists) {
            return new ApiResponce(false, "AllReady exists");
        }
        Drinks drinks = new Drinks(
                drinksDTO.getName(), drinksDTO.getDescription(), drinksDTO.getPrice(), valueMeasurement, attachment
        );
        drinksRepository.save(drinks);
        return new ApiResponce(true, "Successfully saved");
    }

    public ApiResponce edit(UUID id, DrinksDTO drinksDTO) {
        ValueMeasurement valueMeasurement = valueMeasurementRepository.findById(drinksDTO.getValueId()).orElseGet(ValueMeasurement::new);
        Optional<Drinks> optional = drinksRepository.findById(id);
        Attachment attachment = attachmentRepository.findById(drinksDTO.getPhotoId()).orElseGet(Attachment::new);
        if (!optional.isPresent())
            return new ApiResponce(false, "Drinks not found by given Id");
        Drinks drinks = optional.get();
        drinks.setName(drinks.getName());
        drinks.setValueMeasurement(valueMeasurement);
        drinksRepository.save(drinks);
        drinks.setAttachment(attachment);
        return new ApiResponce(true, "Successfully saved");
    }

    public ApiResponce delete(UUID id) {
        try {
            drinksRepository.deleteById(id);
            return new ApiResponce(true, "Successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponce(false, "Error in delete");
    }
}
