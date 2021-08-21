package local.ts3snet.booklibrary_test_webapp.dto;

import local.ts3snet.booklibrary_test_webapp.entity.users.UserEntity;

import java.io.Serializable;


public class UserDataTransferObject extends UserEntity implements Serializable {
    private static final long serialVersionUID = 4865903039190150223L;

    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
}