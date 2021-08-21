package local.ts3snet.booklibrary_test_webapp.repository.library;

import local.ts3snet.booklibrary_test_webapp.entity.library.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    GenreEntity findByName(String title);
}
