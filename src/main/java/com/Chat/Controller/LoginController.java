package com.Chat.Controller;

import com.Chat.Entity.User;
import com.Chat.Model.SigninFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class LoginController {
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    /**
     * ユーザーコントローラー
     */
    @Autowired
    private UserController userController;

    /**
     * ログインページを表示する
     * @param model モデル
     * @return LoginPage
     */
    @RequestMapping(value = "/login" )
    public String displayLoginPage(Model model) {
        SigninFormModel signinFormModel = new SigninFormModel();
        model.addAttribute("signinForm", signinFormModel);
        return "login";
    }

    /**
     * サインインしているか確かめる
     * @param signinFormModel サインインフォームモデル
     * @return
     */
    @RequestMapping(value = "/postSigninForm", method = RequestMethod.POST)
    public String postSigninForm(@ModelAttribute SigninFormModel signinFormModel) {

        logger.info("SigninFormModel.userName : " + signinFormModel.getUserName());
        logger.info("SigninFormModel.password : " + signinFormModel.getPassword());

        User user = new User(signinFormModel.getUserName());

        if (userController.checkSigninUser(user)){
            return "chat";
        }
        return "forward:/login";
    }
}