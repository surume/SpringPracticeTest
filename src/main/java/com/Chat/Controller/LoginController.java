package com.Chat.Controller;

import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/login")
public class LoginController {
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private UserController userController;

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
//        model.addAttribute("message", "Hello world!");
        User user = new User();
        user.setName("miyamoto");
        logger.info("SinginFlag : " + userController.checkSigninUser(user) );;
        return "login";
    }


}