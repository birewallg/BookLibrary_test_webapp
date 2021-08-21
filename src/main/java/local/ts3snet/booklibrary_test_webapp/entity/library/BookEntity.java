package local.ts3snet.booklibrary_test_webapp.entity.library;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;


    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="bookgenre_id")
    private GenreEntity genre;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="bookauthor_id")
    private AuthorEntity author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }
}
