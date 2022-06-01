package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Order;
import ai.fl.demofoods.projection.OrderProjection;
import ai.fl.demofoods.projection.OrderProjection1;
import ai.fl.demofoods.projection.OrderProjection2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query(value = "select d.name                       as drink,\n" +
            "       cast (vm.name as varchar )          as measurementValue,\n" +
            "       cast (m.name as varchar )           as measurement,\n" +
            "       f.name                       as food,\n" +
            "       o.created_at                as createdAt,\n" +
            "       o.total_price               as totalPrice\n" +
            "from orders o\n" +
            "         inner join drinks d on d.id = o.drinks_id\n" +
            "         inner join value_measurement vm on vm.id = d.value_measurement_id\n" +
            "         inner join measurement m on m.id = vm.measurement_id\n" +
            "         inner join food f on f.id = o.food_id\n" +
            "where o.user_id = :userId\n" +
            "order by o.created_at asc", nativeQuery = true)
    List<Object> getAllOrdersByUserId(@PathVariable("userId") UUID userId);

    @Query(nativeQuery = true, value = "select\n" +
            "       cast(o.total_price as varchar) as price,\n" +
            "       cast(o.created_at as varchar) as date,\n" +
            "       cast(f.name as varchar) as food,\n" +
            "       cast(f.photo_id as varchar) as photo,\n" +
            "       cast(d.name as varchar) as drinks,\n" +
            "       o.order_status as status\n" +
            "from orders o\n" +
            "inner join food f on f.id = o.food_id\n" +
            "inner join drinks d on d.id = o.drinks_id\n" +
            "where o.user_id=:userId")
    List<OrderProjection1> getByUserId(@PathVariable("userId") UUID userId);

    @Query(nativeQuery = true, value = "select CONCAT(u.first_name, ' ', u.last_name) AS fullName,\n" +
            "       f.name                                 as foodName,\n" +
            "       d.name                                 as drinkName,\n" +
            "       o.order_status                         as status,\n" +
            "       cast(o.created_at as date)             as createdAt\n" +
            "\n" +
            "from orders o\n" +
            "         inner join drinks d on d.id = o.drinks_id\n" +
            "         inner join food f on f.id = o.food_id\n" +
            "         inner join users u on u.id = o.user_id\n" +
            "order by o.created_at DESC")
    List<OrderProjection2> getAllOrder();
}
