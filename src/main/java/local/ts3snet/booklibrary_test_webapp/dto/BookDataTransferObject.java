package local.ts3snet.booklibrary_test_webapp.dto;


import local.ts3snet.booklibrary_test_webapp.entity.library.BookEntity;

import java.io.Serializable;

public class BookDataTransferObject extends BookEntity implements Serializable {
    private static final long serialVersionUID = 4865903039190150223L;

    private Long id;
    private String title;
}
