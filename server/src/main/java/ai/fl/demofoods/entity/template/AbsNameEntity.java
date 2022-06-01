package ai.fl.demofoods.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class AbsNameEntity extends AbsEntity {
    @Column(nullable = false)
    private String name;
}
