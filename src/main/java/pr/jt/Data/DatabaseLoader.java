package pr.jt.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pr.jt.model.Permission;
import pr.jt.model.Role;
import pr.jt.model.User;
import pr.jt.repository.PermissionRepository;
import pr.jt.repository.RoleRepository;
import pr.jt.repository.UserRepository;
import pr.jt.service.PermissionService;
import pr.jt.service.RoleService;
import pr.jt.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23/12/2015.
 */

@Service
@Profile("default")
public class DatabaseLoader {

    private final UserService userService;
    private final RoleService roleService;
    private final PermissionRepository permissionRepository;
    private List<Permission> permissions =  new ArrayList<>();

    @Autowired
    public DatabaseLoader(UserService userService, RoleService roleService, PermissionRepository permissionRepository){
        this.userService = userService;
        this.roleService = roleService;
        this.permissionRepository = permissionRepository;
    }

    @PostConstruct
    private void initializeDatabase(){

        Permission p_access = this.permissionRepository.findByName("access");
        if(p_access != null) {
            //Do nothing
        } else {
            p_access = new Permission("access");
            this.permissionRepository.save(p_access);
        }
        Permission p_VIPaccess = this.permissionRepository.findByName("VIPaccess");
        if(p_VIPaccess != null) {
            //Do nothing
        } else {
            p_VIPaccess = new Permission("VIPaccess");
            this.permissionRepository.save(p_VIPaccess);
        }
        Permission p_fullcontrol = this.permissionRepository.findByName("fullcontrol");
        if(p_fullcontrol != null) {
            //Do nothing
        } else {
            p_fullcontrol = new Permission("fullcontrol");
            this.permissionRepository.save(p_fullcontrol);
        }

        Role administrator = this.roleService.findRole("Administrator");
        if(administrator == null) {
            administrator = new Role("Administrator");
            permissions =  new ArrayList<>();
            permissions.add(p_access);
            permissions.add(p_VIPaccess);
            permissions.add(p_fullcontrol);
            administrator.setPermissions(permissions);
            this.roleService.addRole(administrator);
        }

        Role member = this.roleService.findRole("Member");
        if(member == null) {
            member = new Role("Member");
            permissions =  new ArrayList<>();
            permissions.add(p_access);
            member.setPermissions(permissions);
            this.roleService.addRole(member);
        }

        Role VIPmember = this.roleService.findRole("VIPmember");
        if(VIPmember == null) {
            VIPmember = new Role("VIPmember");
            permissions =  new ArrayList<>();
            permissions.add(p_access);
            permissions.add(p_VIPaccess);
            VIPmember.setPermissions(permissions);
            this.roleService.addRole(VIPmember);
        }

        if(this.userService.findUser("admin") == null) {
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassword("topkek");
            List<Role> roles = new ArrayList<>();
            roles.add(administrator);
            admin.setRoles(roles);
            this.userService.addUser(admin);
        }else{
            this.userService.deleteUser(this.userService.findUser("admin"));
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassword("topkek");
            List<Role> roles = new ArrayList<>();
            roles.add(administrator);
            admin.setRoles(roles);
            this.userService.addUser(admin);
        }

        if(this.userService.findUser("jef") == null) {
            User membr = new User();
            membr.setUserName("jef");
            membr.setPassword("topkek");
            List<Role> roles = new ArrayList<>();
            roles.add(member);
            membr.setRoles(roles);
            this.userService.addUser(membr);
        }else{
            this.userService.deleteUser(this.userService.findUser("jef"));
            User membr = new User();
            membr.setUserName("jef");
            membr.setPassword("topkek");
            List<Role> roles = new ArrayList<>();
            roles.add(member);
            membr.setRoles(roles);
            this.userService.addUser(membr);
        }
    }
}
