package local.ts3snet.booklibrary_test_webapp.entity.users;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {
    @Id
    private Long id;

    private String rolename;

    @ManyToMany(mappedBy = "roles")
    private Collection<UserEntity> users;

    public RoleEntity() {}

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    public RoleEntity(Long id) {
        this.id = id;
    }

    public RoleEntity(Long id, String rolename) {
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

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }
}