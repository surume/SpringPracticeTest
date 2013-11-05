//package com.Chat.Controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Locale;
//import java.util.logging.Logger;
//
///**
// * Created with IntelliJ IDEA.
// * User: miyamoto_s
// * Date: 2013/10/21
// * Time: 1:45
// * To change this template use File | Settings | File Templates.
// */
//@Controller
//@RequestMapping(value = "account")
//public class accountController {
//
//    /**
//     * ロガー
//     */
//    private static final Logger logger = Logger.getLogger(UserController.class.getName());
//
//    @RequestMapping(value = "confirm_email")
//    public String confirmEmail(@RequestParam("id") String data,
//                               @RequestParam("pass") Integer count,
//                               Locale locale,
//                               Model model) {
//
//        // 受取りパラメータ「data」をjspに出力します。
//        model.addAttribute("data", data);
//
//        // 受取りパラメータ「count」をjspに出力します。
//        model.addAttribute("count", count);
//
//        return "account/completAccount";
//    }
//}
