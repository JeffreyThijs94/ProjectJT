package pr.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pr.jt.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by User on 23/12/2015.
 */
@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails ud = null;
        User user = userService.findUser(userName);
        if(user != null){
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.addAll(StreamSupport.stream(permissionService.findAllPermissionsForUser(user).spliterator(), false)
                    .map(perm -> new SimpleGrantedAuthority(perm.getName())).collect(Collectors.toList()));


            ud = new org.springframework.security.core.userdetails.User(userName, user.getPassword(), true, true, true, true,authorities);

        }
        else throw new UsernameNotFoundException("No user with username '" + userName + "' found!");
        return ud;
    }
}
