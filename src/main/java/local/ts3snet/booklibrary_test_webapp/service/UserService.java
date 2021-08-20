package local.ts3snet.booklibrary_test_webapp.service;

import local.ts3snet.booklibrary_test_webapp.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}