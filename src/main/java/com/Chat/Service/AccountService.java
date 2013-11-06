package com.Chat.Service;

import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * ログインロジック
 * User: miyamoto_s
 * Date: 2013/10/22
 */
@Service
public class AccountService {

    @Autowired
    private MailService mailService;

    /**
     * ロガー
     */
    private static final Logger logger = Logger.getLogger(AccountService.class.getName());

    @Autowired
    private UserService userService;

    /**
     * サインイン処理
     *
     * @param user サインインフォーム
     * @return 遷移先文字列
     */
    public String execSignup(User user) {
        if (user.checkNullField())
            return "redirect:/";

        if (userService.checkSigninUser(user))
            return "chat";

        int token = (int)(Math.random() * 9999);
//        userService.registUser(user);
        mailService.setText("まとめ登録確認" + token);
        mailService.create_mail();
        mailService.setTitle("まとめ登録確認メール");
        mailService.SendTo(user.geteMail());
        mailService.send();

        return "redirect:/";
    }
}
