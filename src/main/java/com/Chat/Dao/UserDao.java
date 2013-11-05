package com.Chat.Dao;

import com.Chat.Entity.User;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

/**
 * UserDaoクラス
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:20
 */
@Repository
public class UserDao  {

    public void addUser(Session session, User user){
        try {
            session.save(user);
            session.flush();
        } catch (ConstraintViolationException e){
            throw new DuplicateKeyException("プライマリーキーが重複しています");
        }
    }

//    // *** 検索 ***
//    @SuppressWarnings("unchecked")
//    public List<User> getSampleList()
//            throws DataAccessException {
//        return getHibernateTemplate().find(
//                "from User as user order by user.id");
//    }

//    @Override
//    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
//        return super.createHibernateTemplate(sessionFactory);    //To change body of overridden methods use File | Settings | File Templates.
//    }



    //    /**
//     * 全Userのリストを取得する
//     *
//     * @return 全ユーザのリスト
//     * @throws DataAccessException
//     */
//    public List<User> getUserList() throws DataAccessException {
//        RowMapper<User> rowMapper = new UserRowMapper();
//        return getJdbcTemplate().query("SELECT * FROM user WHERE delete_flag = 0", rowMapper);
//    }
//
//
//    /**
//     * UserをキーにDBからエンティティを取得する
//     *
//     * @param user ユーザー
//     * @return @{user}
//     * @throws DataAccessException
//     */
//    public User getUser(User user) throws DataAccessException {
//        RowMapper<User> rowMapper = new UserRowMapper();
//        List<User> userList = getJdbcTemplate().query(String.format("SELECT * FROM user WHERE delete_flag = 0 AND email = '%s'", user.geteMail()), rowMapper);
//
//        if (userList.size() == 0)
//            return null;
//
//        return userList.get(0);
//    }
//
//    /**
//     * MaxIdを取得する
//     * @return UserテーブルのUser_idの最大値を取得する
//     */
//    public int getMaxId() {
//        RowMapper<User> rowMapper = new UserRowMapper();
//        List<User> userList = getJdbcTemplate().query("SELECT * " +
//                "FROM user " +
//                "WHERE  user_id = (SELECT MAX(user_id) FROM user);", rowMapper);
//        if (userList.size() == 0)
//            return 1;
//
//        return userList.get(0).getId();
//    }
//
//
//    /**
//     * UserをDBにインサートする
//     * @param user ユーザエンティティ
//     * @return 結果件数
//     */
//    @Transactional
//    public int insert(User user) {
//        return getJdbcTemplate().update(
//                "insert into user values (?,?,?,?,?)",
//                user.getId(),
//                user.getName(),
//                user.geteMail(),
//                user.getPassword(),
//                user.getDeleteFlag()
//        );
//    }
////
////    public void setSessionFactory(SessionFactory sessionFactory) {
////        this.sessionFactory = sessionFactory;
////    }
////
////    public SessionFactory getSessionFactory() {
////        return sessionFactory;
////    }
//
//    /**
//     * User用Mapper
//     */
//    protected class UserRowMapper implements RowMapper<User> {
//
//        private List<User> UserList = new ArrayList<User>();
//
//        public List<User> getResults() {
//            return UserList;
//        }
//
//        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//            User User = new User();
//            User.setId(rs.getInt("user_id"));
//            User.setName(rs.getString("name"));
//            User.seteMail(rs.getString("email"));
//            User.setPassword(rs.getString("password"));
//            User.setDeleteFlag(rs.getInt("delete_flag"));
//
//            return User;
//        }
//    }
}
