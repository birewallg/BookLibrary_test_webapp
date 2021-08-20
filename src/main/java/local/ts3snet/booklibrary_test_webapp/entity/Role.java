package local.ts3snet.booklibrary_test_webapp.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    private Long id;

    private String rolename;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {}

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return rolename;
    }

    public void setRolename(String name) {
        this.rolename = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}