package pr.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr.jt.model.Permission;
import pr.jt.model.User;
import pr.jt.repository.PermissionRepository;

/**
 * Created by User on 23/12/2015.
 */
@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public Iterable<Permission> findAllPermissionsForUser(final User user){
        return this.permissionRepository.findAllForUser(user);
    }

    public Iterable<Permission> findAllPermissions(){
        return this.permissionRepository.findAll();
    }

    public Permission findPermission(String name){
        return this.permissionRepository.findByName(name);
    }

    public Permission findPermission(long id){
        return this.permissionRepository.findOne(id);
    }
}
