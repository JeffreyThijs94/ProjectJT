package pr.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr.jt.model.User;
import pr.jt.repository.UserRepository;

/**
 * Created by User on 23/12/2015.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(final User user){
        this.userRepository.save(user);
    }

    public void deleteUser(final User user){
        this.userRepository.delete(user);
    }

    public void deleteUser(final long id){
        this.userRepository.delete(id);
    }

    public User findUser(final String userName){
        return this.userRepository.findByUserName(userName);
    }

    public User findUser(final long id){
        return this.userRepository.findOne(id);
    }

    public Iterable<User> findAllUsers(){
        return this.userRepository.findAll();
    }


}
