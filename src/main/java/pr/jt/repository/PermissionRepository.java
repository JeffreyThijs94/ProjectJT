package pr.jt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pr.jt.model.Permission;
import pr.jt.model.User;

/**
 * Created by User on 23/12/2015.
 */

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{
    @Query(value = "select p from User u left join u.roles r left join r.permissions  p where u=:usr")
    Iterable<Permission> findAllForUser(@Param("usr") User user);
    Permission findByName(String name);
}
