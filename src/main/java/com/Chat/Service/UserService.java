package com.Chat.Service;

import com.Chat.Dao.UserDao;
import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
     * ユーザDAO
     */
    @Autowired
    private UserDao userDao;


    public List<User> findUser(){
        return userDao.findUser();
    }


    /**
     * サインインしているユーザかチェックする
     *
     * @return サインインしている場合はTrue
     */
    public boolean checkSigninUser(User checkUser) {
        User user = userDao.findUser(checkUser.geteMail());
        return user != null;
    }

    public void registUser(User user) {
        userDao.insert(user);
    }
}
