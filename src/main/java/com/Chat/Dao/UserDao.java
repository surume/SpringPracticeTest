package com.Chat.Dao;

import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDaoクラス
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:20
 */
@Repository
public class UserDao {


    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 全Userを取得する
     *
     * @return Userのリスト
     */
    public List<User> findUser() {
        return hibernateTemplate.find("from User");
    }

    /**
     * emailをキーにして有効なユーザを検索する
     *
     * @param email Eメール
     * @return User
     */
    public User findUser(String email) {
        List<User> userList = hibernateTemplate.find(
                "from User where eMail = ? " +
                        "and deleteFlag = ? " +
                        "and validFlag = ?", email, false, true);

        return 0 == userList.size() ? null : userList.get(0);
    }

    public void insert(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }
}
