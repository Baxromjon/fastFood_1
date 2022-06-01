package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * created by Baxromjon
 * 14.02.2022
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeliveryAddress extends AbsEntity {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "delivery_address_users", joinColumns = {@JoinColumn(name = "delivery_address_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;
    @Column(nullable = false)
    private String address;
    private String city;
    private String street;
    private String home;
    private long lat;
    private long lon;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "delivery_address_foods", joinColumns = {@JoinColumn(name = "delivery_address_id")},
            inverseJoinColumns = {@JoinColumn(name = "food_id")})
    private List<Food> foods;
}
