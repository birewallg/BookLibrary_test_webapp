package local.ts3snet.booklibrary_test_webapp.repository;

import local.ts3snet.booklibrary_test_webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
