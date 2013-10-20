package com.Chat.Controller;

import com.Chat.Dao.UserDao;
import com.Chat.Entity.User;
import com.Chat.Model.SigninFormModel;
import com.Chat.Util.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * ユーザコントローラー
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:38
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    /**
     * ロガー
     */
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    /**
     * ユーザDao
     */
    @Autowired
    private UserDao userDao;

    /**
     * ユーザリストを確認する
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome user!");

        model.addAttribute("userlist", userDao.getUserList());
        return "user/list";
    }

    /**
     * サインインしているユーザかチェックする
     *
     * @return サインインしている場合はTrue
     */
    public boolean checkSigninUser(String email) {
        User user = new User();
        user.seteMail(email);

        return null != getUser(user);
    }

    /**
     * Userエンティティを元にユーザを取得する
     * @param user
     * @return
     */
    private User getUser(User user) {
        User encryptUser = encryptUser(user);
        return decryptUser( userDao.getUser(encryptUser));
    }

    private User decryptUser(User user) {
        User resultUser = new User();

        resultUser.setId(user.getId());
        resultUser.setName(user.getName());
        resultUser.seteMail(Crypt.decrypt(user.geteMail()));
        resultUser.setPassword(Crypt.decrypt(user.getPassword()));
        resultUser.setDeleteFlag(user.getDeleteFlag());

        return resultUser;
    }


    /**
     * ログイン処理
     *
     * @param signinFormModel 入力フォーム
     * @return ログイン出来る場合はTrue
     */
    public boolean checkLoginUser(SigninFormModel signinFormModel) {

        User user = new User(signinFormModel);
        user = getUser(user);
        if (null == user)
            return false;

        return verifyPassword(signinFormModel.getPassword(), user.getPassword());
    }



    /**
     * パスワードが一致するか確かめる
     *
     * @param userpass1
     * @param userpass2
     * @return
     */
    private boolean verifyPassword(String userpass1, String userpass2) {
        return userpass1.equals(userpass2);
    }

    /**
     * Userを登録する
     *
     * @param user ユーザエンティティ
     */
    public void registUser(User user) {
        User completeUser = complementUser(user);

        completeUser = encryptUser(completeUser);

        userDao.insert(completeUser);
    }

    /**
     * ユーザの重要データを暗号化したデータを作成する
     * @param user
     * @return 暗号化されたデータ
     */
    private User encryptUser(User user) {
        User resultUser = new User();

        resultUser.setId(user.getId());
        resultUser.setName(user.getName());
        resultUser.seteMail(Crypt.encrypt(user.geteMail()));
        resultUser.setPassword((Crypt.encrypt(user.getPassword())));
        resultUser.setDeleteFlag(user.getDeleteFlag());

        return resultUser;
    }

    /**
     * Userのデータを補完する
     * @param user ユーザエンティティ
     */
    private User complementUser(User user) {
        User compUser;
        compUser = complementUserId(user);
        compUser.setDeleteFlag(false);

        return compUser;
    }

    /**
     * UserIdを保管する
     * @param user ユーザエンティティ
     */
    private User complementUserId(User user) {
        if (null == user.getId()) {
            user.setId(userDao.getMaxId() + 1);
        }

        return user;
    }
}