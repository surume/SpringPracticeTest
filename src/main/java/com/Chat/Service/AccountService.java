package com.Chat.Service;

import com.Chat.Dao.UserDao;
import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * ログインロジック
 * User: miyamoto_s
 * Date: 2013/10/22
 */
@Service
public class AccountService {

    /**
     * ロガー
     */
    private static final Logger logger = Logger.getLogger(AccountService.class.getName());
    
    @Autowired
    private UserDao userDao;

    public List<User> findUser(){
        return userDao.findUser();
    }

//    public void addUser(User user) {
//        Session session = null;
//        Transaction transaction = null;
//
//
//        try {
//            session =  getSession();
//            transaction = session.beginTransaction();
//            new UserDao().addUser(session, user);
//            transaction.commit();
//        } catch (HibernateException e){
//            if (transaction != null){
//                try {
//                    transaction.rollback();
//                }catch (HibernateException ex){
//                    System.out.print("システムエラー" + ex);
//                }
//            }
//            throw e;
//        } finally {
//            if(session != null){
//                try {
//                    session.close();
//                } catch (HibernateException e){
//                    System.out.println("システムエラー：" + e);
//                }
//            }
//        }
//    }
//
//    private static SessionFactory sessionFactory = null;
//    private static synchronized SessionFactory getSessionFactory() throws HibernateException{
//        if (sessionFactory == null){
//            Configuration cfg = new Configuration();
//            cfg.configure();
//            sessionFactory = cfg.buildSessionFactory();
//        }
//        return sessionFactory;
//    }
//
//    private Session getSession() throws HibernateException{
//        SessionFactory sf = getSessionFactory();
//        return sf.openSession();
//    }
}
