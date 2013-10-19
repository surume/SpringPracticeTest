package com.Chat.Controller;

import com.Chat.Model.SigninFormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * インデックスコントローラー
 */
@Controller
public class IndexController {

    /**
     * indexページ表示
     * @param model モデル
     * @return 対象ページ
     */
    @RequestMapping(value = "/")
    public String displayIndexPage(ModelMap model) {
        SigninFormModel signinFormModel = new SigninFormModel();
        model.addAttribute("signinForm", signinFormModel);

        return "index";
    }

}