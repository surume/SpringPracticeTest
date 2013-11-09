package com.Chat.Common.Define;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/11/08
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public class MailDefine {
    public static String confirmText = "<div >\n" +
            "\t<div style=\"font-weight: bold;font-size: 18px;padding-bottom: 10px;\">\t登録確認\n" +
            "\t</div>\n" +
            "\t<div style=\"padding: 20px;background-color: #cccccc;\">\n" +
            "\t\t<div style=\"text-align: center;padding: 10px;background-color: #ffffff;\">\n" +
            "\t\t\t<p>ボタンをクリックするとユーザー登録されます。</p>\n" +
            "\t\t\t<a href=\"%s/account/confirm_email/%s/%s\" style=\"display: inline-block;background-color: #0066ff;border-radius: 5px;padding: 10px;color: white;text-decoration: none;\">\n" +
            "\t\t\t\tユーザー登録\n" +
            "\t\t\t</a>\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "</div>";
}
