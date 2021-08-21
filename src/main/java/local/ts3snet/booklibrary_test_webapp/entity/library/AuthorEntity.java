package local.ts3snet.booklibrary_test_webapp.entity.library;

import local.ts3snet.booklibrary_test_webapp.entity.users.UserEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany (mappedBy="author", fetch=FetchType.EAGER)
    private Collection<BookEntity> books;
    @OneToOne (mappedBy="isAuthor", optional=true)
    private UserEntity user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Collection<BookEntity> books) {
        this.books = books;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
