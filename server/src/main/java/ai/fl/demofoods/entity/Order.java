package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.enums.OrderStatus;
import ai.fl.demofoods.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order extends AbsEntity {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Food food;
    @ManyToOne
    private Drinks drinks;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
