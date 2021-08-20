package local.ts3snet.booklibrary_test_webapp.repository;

import local.ts3snet.booklibrary_test_webapp.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRolename(String rolename);
}
