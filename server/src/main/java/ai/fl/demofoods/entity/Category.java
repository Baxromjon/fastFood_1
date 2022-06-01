package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.template.AbsEntity;
import ai.fl.demofoods.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends AbsEntity {
    @Column(nullable = false)
    private String name;
    private String description;
}
