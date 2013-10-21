package com.Chat.Controller;

import com.Chat.Model.Form.SigninFormModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * ログインコントローラー
 */
@Controller
@RequestMapping(value = "/Signup")
public class SignupController {

    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(SignupController.class.getName());

    /**
     * ログイン処理
     *
     * @param signinFormModel サインインフォームモデル
     * @return
     */
    @RequestMapping(value = "/postForm", method = RequestMethod.POST)
    public String postLoginForm(@ModelAttribute SigninFormModel signinFormModel) {
        return "forward:/";
    }

}