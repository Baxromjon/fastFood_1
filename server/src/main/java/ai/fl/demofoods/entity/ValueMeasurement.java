package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * created by Baxromjon
 * 07.02.2022
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ValueMeasurement extends AbsEntity {
    private String name;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Measurement measurement;
}
