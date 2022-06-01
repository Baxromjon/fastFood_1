package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Role;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.projection.UserProjection1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByPhoneNumber(String username);

    Optional<User> findByPhoneNumberAndRolesIn(String phoneNumber, List<Role> roles);

    boolean existsByPhoneNumber(String phoneNumber);
    @Query(nativeQuery = true, value = "select concat(u.first_name, ' ', u.last_name) as fullName,\n" +
            "       u.phone_number                         as phoneNumber,\n" +
            "       u.enabled                              as enable\n" +
            "from users u\n" +
            "where enabled = true\n" +
            "  and id in (select user_id from users_roles where role_id in (select id from role where name = :client))\n" +
            "order by created_at\n" +
            "limit :currentSize offset :currentPage")
    List<User> getUserListWithPageable(String client, int currentSize, int currentPage);
}
