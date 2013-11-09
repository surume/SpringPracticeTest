package com.Chat.Service;

import com.Chat.Common.Define.MailDefine;
import com.Chat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

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

        User dbUser = userService.findNeitherUser(user);
        if(null != dbUser)
            user = dbUser;

        if (user.isValidFlag())
            return "chat";

        user.setTokenId(createNumberToken(4));
        user.setDeleteFlag(false);
        user.setValidFlag(false);

        createSendMailThread(user, request.getServerName()).start();

        userService.registUser(user);

        return "redirect:/";
    }

    /**
     * 指定した桁数の数列のTokenを生成する
     *
     * @param maxDigit 最大桁数
     * @return 数列のToken
     */
    private String createNumberToken(int maxDigit) {
        String strRand = new String();
        for (int i = 0; i < maxDigit; i++) {
            strRand += String.valueOf((int) (Math.random() * 10));
        }
        return strRand;
    }

    /**
     * メール送信スレッドを作成する
     *
     * @param user メール送信相手
     * @return メール送信スレッド
     */
    private Thread createSendMailThread(User user, String url) {
        return new Thread(new Runnable() {
            private User user;
            private String url;

            public Runnable init(User user, String url) {
                this.user = user;
                this.url = url;
                return this;
            }

            @Override
            public void run() {
                sendConfirmMail(user, url);
            }
        }.init(user, url));
    }

    /**
     * 登録確認メールを送る
     *
     * @param url URL
     * @param user targetUser
     */
    private void sendConfirmMail(User user, String url ) {
        String confirmText = String.format(MailDefine.confirmText, user.getTokenId(), url, user.getId(), user.getTokenId());
        mailService.setText(confirmText);
        mailService.create_mail();
        mailService.setTitle("まとめ登録確認メール");
        mailService.SendTo(user.geteMail());
        mailService.send();

    }
}
