package pr.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pr.jt.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/","/home"})
    @PreAuthorize("hasRole('Member')")
    public String showHomepage(final ModelMap model){
        model.addAttribute("user", userService.findUser(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "test";
    }
}
