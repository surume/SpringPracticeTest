package com.Chat.Dao;

import com.Chat.Entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDaoクラス
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:20
 */
public class UserDao extends JdbcDaoSupport implements UserDaoImpl {

    /**
     * 全Userのリストを取得する
     * @return 全ユーザのリスト
     * @throws DataAccessException
     */
    public List<User> getUserList() throws DataAccessException {
        RowMapper<User> rowMapper = new UserRowMapper();
        return getJdbcTemplate().query("SELECT * FROM user", rowMapper);
    }


    /**
     * UserをキーにDBからエンティティを取得する
     * @param user ユーザー
     * @return @{user}
     * @throws DataAccessException
     */
    public User getUser(User user) throws DataAccessException {
        RowMapper<User> rowMapper = new UserRowMapper();
        List<User> userList = getJdbcTemplate().query(String.format( "select * from user where name = '%s'", user.getName()), rowMapper);

        if (userList.size() == 0)
            return null;

        return userList.get(0);

    }

    /**
     * User用Mapper
     */
    protected class UserRowMapper implements RowMapper<User> {

        private List<User> UserList = new ArrayList<User>();

        public List<User> getResults() {
            return UserList;
        }

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User User = new User();
            User.setId(rs.getInt("user_id"));
            User.setName(rs.getString("name"));
            User.seteMail("email");
            User.setPassword("password");
            User.setDeleteFlag(rs.getInt("delete_flag"));

            return User;
        }
    }
}
