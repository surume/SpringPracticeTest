package com.Chat.Controller;

import com.Chat.Form.SigninFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

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

    /**
     * indexページ表示
     * @param model モデル
     * @return 対象ページ
     */
    @RequestMapping(value = "/")
    public String displayIndexPage(ModelMap model) {
        model.addAttribute("signinForm", signinFormModel);
        return "index";
    }

}