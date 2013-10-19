package com.Chat.Controller;

import com.Chat.Model.SigninFormModel;
import com.Chat.Util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * ログインコントローラー
 */
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
     *
     * @param model モデル
     * @return LoginPage
     */
    @RequestMapping(value = "/login")
    public String displayLoginPage(Model model) {
        SigninFormModel signinFormModel = new SigninFormModel();
        model.addAttribute("signinForm", signinFormModel);
        return "login";
    }

    /**
     * ログイン処理
     *
     * @param signinFormModel サインインフォームモデル
     * @return
     */
    @RequestMapping(value = "/postLoginForm", method = RequestMethod.POST)
    public String postLoginForm(@ModelAttribute SigninFormModel signinFormModel) {
        //Log
        signinFormModel.printFieldLog(logger);

        if (userController.checkLoginUser(signinFormModel))
            return "chat";

        return "forward:/";
    }



    @RequestMapping(value = "/postLoginForm", method = RequestMethod.GET)
    public String postLoginForm() {
        return "redirect:/";
    }
    /**
     * サインイン処理
     *
     * @param signinFormModel サインインフォームモデル
     * @return
     */
    @RequestMapping(value = "/postSigninForm", method = RequestMethod.POST)
    public String postSigninForm(@ModelAttribute SigninFormModel signinFormModel) {
        //Log
        signinFormModel.printFieldLog(logger);

        if (signinFormModel.checkNullField()){
            logger.info("FormNull");
            return "redirect:/";
        }

        if (userController.checkSigninUser(signinFormModel.getEmail())) {
            logger.info("サインイン済み");
            //TODO: なおさんとあかん
            return "chat";
        }

        userController.registUser(ConvertUtil.SigninFormToUser(signinFormModel));


        return "redirect:/";
    }

    @RequestMapping(value = "/postSigninForm", method = RequestMethod.GET)
    public String postSigninForm() {
        return "redirect:/";
    }
}