package pr.jt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pr.jt.model.Role;

/**
 * Created by User on 23/12/2015.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByName(String name);
}
