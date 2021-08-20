package local.ts3snet.booklibrary_test_webapp.repository;

import local.ts3snet.booklibrary_test_webapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
