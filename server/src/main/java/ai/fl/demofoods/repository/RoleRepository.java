package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Role;
import ai.fl.demofoods.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findByRoleName(RoleName roleName);

//    List<Role> findAllByName(RoleName admin);
}
