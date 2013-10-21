package com.Chat.Model.Dao;

import com.Chat.Model.Entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

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
     *
     * @return 全ユーザのリスト
     * @throws DataAccessException
     */
    public List<User> getUserList() throws DataAccessException {
        RowMapper<User> rowMapper = new UserRowMapper();
        return getJdbcTemplate().query("SELECT * FROM user WHERE delete_flag = 0", rowMapper);
    }


    /**
     * UserをキーにDBからエンティティを取得する
     *
     * @param user ユーザー
     * @return @{user}
     * @throws DataAccessException
     */
    public User getUser(User user) throws DataAccessException {
        RowMapper<User> rowMapper = new UserRowMapper();
        List<User> userList = getJdbcTemplate().query(String.format("SELECT * FROM user WHERE delete_flag = 0 AND email = '%s'", user.geteMail()), rowMapper);

        if (userList.size() == 0)
            return null;

        return userList.get(0);
    }

    /**
     * MaxIdを取得する
     * @return UserテーブルのUser_idの最大値を取得する
     */
    public int getMaxId() {
        RowMapper<User> rowMapper = new UserRowMapper();
        List<User> userList = getJdbcTemplate().query("SELECT * " +
                "FROM user " +
                "WHERE  user_id = (SELECT MAX(user_id) FROM user);", rowMapper);
        if (userList.size() == 0)
            return 1;

        return userList.get(0).getId();
    }


    /**
     * UserをDBにインサートする
     * @param user ユーザエンティティ
     * @return 結果件数
     */
    @Transactional
    public int insert(User user) {
        return getJdbcTemplate().update(
                "insert into user values (?,?,?,?,?)",
                user.getId(),
                user.getName(),
                user.geteMail(),
                user.getPassword(),
                user.getDeleteFlag()
        );
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
            User.seteMail(rs.getString("email"));
            User.setPassword(rs.getString("password"));
            User.setDeleteFlag(rs.getInt("delete_flag"));

            return User;
        }
    }
}
