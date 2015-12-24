package pr.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr.jt.model.Role;
import pr.jt.repository.RoleRepository;

/**
 * Created by User on 23/12/2015.
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Role> findAllRoles(){
        return this.roleRepository.findAll();
    }

    public Role findRole(String name){
        return this.roleRepository.findByName(name);
    }

    public Role findRole(long id){
        return this.roleRepository.findOne(id);
    }


    public void addRole(final Role role){
        this.roleRepository.save(role);
    }

    public void deleteRole(final Role role){
        this.roleRepository.delete(role);
    }

    public void deleteRole(final long id){
        this.roleRepository.delete(id);
    }
}
