package pr.jt.model;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23/12/2015.
 */

@Entity
public class User extends MyAbstractPersistable<Long>{

    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(name="USER_ROLE",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")}
    )

    private List<Role> roles;

    public User(){
        this.userName = "";
        this.password = "";
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.roles = new ArrayList<>();
    }

    public User(String userName, String password, List<Role> roles){
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
