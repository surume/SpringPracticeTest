package com.Chat.Controller;

import com.Chat.Dao.UserDao;
import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * ユーザコントローラー
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:38
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    /**
     * ロガー
     */
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    /**
     * ユーザDao
     */
    @Autowired
    private UserDao userDao;

    /**
     * ユーザリストを確認する
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome user!");
        model.addAttribute("userlist", userDao.getUserList());
        return "user/list";
    }

    /**
     * サインインしているかチェックする
     *
     * @return サインインしている場合はTrue
     */
    public boolean checkSigninUser(User user) {
        return null != userDao.getUser(user);
    }
}