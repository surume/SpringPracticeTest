package com.Chat.Service;

import com.Chat.Dao.UserDao;
import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * UserService
 * User: miyamoto_s
 * Date: 2013/10/22
 * Time: 0:11
 */
@Service
public class UserService {
    /**
     * logger
     */
    Logger logger = Logger.getLogger(UserService.class.getName());

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
