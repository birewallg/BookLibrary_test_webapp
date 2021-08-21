package local.ts3snet.booklibrary_test_webapp.service;

import local.ts3snet.booklibrary_test_webapp.entity.users.UserEntity;

public interface UserService {
    void save(UserEntity user);
    UserEntity findByUsername(String username);
}