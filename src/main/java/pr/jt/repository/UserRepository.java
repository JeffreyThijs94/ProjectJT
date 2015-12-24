package pr.jt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pr.jt.model.User;

/**
 * Created by User on 23/12/2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUserName(String userName);
}
