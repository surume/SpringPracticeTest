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
     * ユーザDAO
     */
    @Autowired
    private UserDao userDao;

    /**
     * 有効でも無効でもない対象ユーザを検索する
     *
     * @param user 対象ユーザ
     * @return 有効でもない
     */
    public User findNeitherUser(User user) {
        User u = userDao.findUser(user.geteMail());
        return u != null ? u : null;
    }

    /**
     * サインインしているユーザかチェックする
     *
     * @return サインインしている場合はTrue
     */
    public boolean checkSigninUser(User checkUser) {
        User user = userDao.findValidUser(checkUser.geteMail());
        return user != null;
    }

    /**
     * ユーザを登録する
     *
     * @param user 登録対象ユーザ
     */
    public void registUser(User user) {
        userDao.insert(user);
    }
}
