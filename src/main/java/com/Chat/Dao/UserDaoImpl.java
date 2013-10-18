package com.Chat.Dao;

import com.Chat.Entity.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:17
 * To change this template UserDaoImpl File | Settings | File Templates.
 */
public interface UserDaoImpl {
    List<User> getUserList() throws DataAccessException;
}
