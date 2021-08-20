package local.ts3snet.booklibrary_test_webapp.service;

import local.ts3snet.booklibrary_test_webapp.entity.Role;
import local.ts3snet.booklibrary_test_webapp.entity.User;
import local.ts3snet.booklibrary_test_webapp.repository.RoleRepository;
import local.ts3snet.booklibrary_test_webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private RoleRepository roleRepository;
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        //user.setRoles(Collections.singleton(roleRepository.findByRolename("ROLE_USER")));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setRoles( new HashSet<>(Collections.singleton(roleRepository.findByRolename("ROLE_USER"))));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
