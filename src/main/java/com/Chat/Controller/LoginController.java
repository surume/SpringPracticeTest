package com.Chat.Controller;

import com.Chat.Form.SigninFormModel;
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

//        if (userController.checkLoginUser(signinFormModel))
//            return "chat";

        return "forward:/";
    }



    @RequestMapping(value = "/postLoginForm", method = RequestMethod.GET)
    public String postLoginForm() {
        return "redirect:/";
    }


    @RequestMapping(value = "/postSigninForm", method = RequestMethod.GET)
    public String postSigninForm() {
        return "redirect:/";
    }
}