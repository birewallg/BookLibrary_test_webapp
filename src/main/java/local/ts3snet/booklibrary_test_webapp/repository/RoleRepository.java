package local.ts3snet.booklibrary_test_webapp.repository;

import local.ts3snet.booklibrary_test_webapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRolename(String rolename);
}
