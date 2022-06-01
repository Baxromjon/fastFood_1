package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.DeliveryAddress;
import ai.fl.demofoods.projection.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, UUID> {
    @Query(nativeQuery = true, value = "select u.first_name   as firstName,\n" +
            "       u.last_name    as lastName,\n" +
            "       u.phone_number as phoneNumber,\n" +
            "       da.address     as address,\n" +
            "       da.city        as city,\n" +
            "       da.street      as street,\n" +
            "       da.home        as home\n" +
            "from delivery_address da\n" +
            "         inner join delivery_address_users dau on da.id = dau.delivery_address_id\n" +
            "         inner join users u on u.id = dau.user_id\n" +
            "where dau.user_id = :userId")
    List<AddressProjection> findByUsers(@PathVariable("userId") UUID userId);
}
