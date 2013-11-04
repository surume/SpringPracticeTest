package com.Chat.Logic;

import com.Chat.Dao.UserDao;
import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

/**
 * UserLogic
 * User: miyamoto_s
 * Date: 2013/10/22
 * Time: 0:11
 */
public class UserLogic {
    /**
     * logger
     */
    Logger logger = Logger.getLogger(UserLogic.class.getName());

    /**
     * ユーザDao
     */
    @Autowired
    private UserDao userDao;

    /**
     * サインインしているユーザかチェックする
     *
     * @return サインインしている場合はTrue
     */
    public boolean checkSigninUser(User user) {
        boolean isSignin = false;

        if (!user.geteMail().isEmpty()){

        }

        return isSignin;
    }

}
