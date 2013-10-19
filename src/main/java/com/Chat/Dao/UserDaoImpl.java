package com.Chat.Dao;

import com.Chat.Entity.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * ユーザーDaoインターフェース
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:17
 */
public interface UserDaoImpl {
    List<User> getUserList() throws DataAccessException;

    User getUser(User user);

    public int insert(User completeUser);
}
