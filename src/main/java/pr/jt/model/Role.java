package pr.jt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by User on 23/12/2015.
 */
@Entity
public class Role extends MyAbstractPersistable<Long>{

    private String name;

    @ManyToMany
    @JoinTable(
            name="ROLE_PERM",
            joinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="PERM_ID", referencedColumnName="ID")})
    private List<Permission> permissions;

    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
