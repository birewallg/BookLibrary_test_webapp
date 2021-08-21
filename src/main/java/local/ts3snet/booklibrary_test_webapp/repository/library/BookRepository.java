package local.ts3snet.booklibrary_test_webapp.repository.library;

import local.ts3snet.booklibrary_test_webapp.entity.library.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByTitle(String title);
}
