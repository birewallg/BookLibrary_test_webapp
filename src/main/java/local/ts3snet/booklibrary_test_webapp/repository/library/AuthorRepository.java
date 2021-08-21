package local.ts3snet.booklibrary_test_webapp.repository.library;

import local.ts3snet.booklibrary_test_webapp.entity.library.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
