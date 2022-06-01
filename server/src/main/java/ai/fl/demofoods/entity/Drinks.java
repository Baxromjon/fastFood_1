package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * created by Baxromjon
 * 07.02.2022
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Drinks extends AbsEntity {
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private double price;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ValueMeasurement valueMeasurement;
    @OneToOne
    private Attachment attachment;
}
