package com.Chat.Controller;

import com.Chat.Dao.UserDao;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserDao userDao;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value="list", method= RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome user!");
        model.addAttribute("userlist", userDao.getUserList());
        return "user/list";
    }
}