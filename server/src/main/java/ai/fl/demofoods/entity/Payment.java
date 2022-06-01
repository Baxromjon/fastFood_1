package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends AbsEntity {
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private PayType payType;
    @ManyToOne(optional = false)
    private Order order;
    @Column(nullable = false)
    private double amount;
    private LocalDate payDate;
    private String description;

}
