package pr.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import pr.jt.model.User;
import pr.jt.service.UserService;

/**
 * Created by User on 23/12/2015.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

}
