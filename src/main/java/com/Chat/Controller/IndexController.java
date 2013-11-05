package com.Chat.Controller;

import com.Chat.Entity.User;
import com.Chat.Form.SigninFormModel;
import com.Chat.Service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * インデックスコントローラー
 */
@Controller
public class IndexController {

    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(IndexController.class.getName());

    /**
     * サインインフォームモデル
     */
    @Autowired
    private SigninFormModel signinFormModel;
    @Autowired
    private AccountService accountService;

    /**
     * indexページ表示
     * @param model モデル
     * @return 対象ページ
     */
    @RequestMapping(value = "/")
    public String displayIndexPage(ModelMap model) {
        User user = new User();
        user.setId(2);
        user.setName("miyamoto_s");
        user.seteMail("miyamoto_s@gmail.com");
        user.setPassword("pass");
        user.setDeleteFlag(0);

        accountService.addUser(user);
        model.addAttribute("signinForm", signinFormModel);

        return "index";
    }



}