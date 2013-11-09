package com.Chat.Common.Util;

import com.Chat.Entity.User;
import com.Chat.Form.SigninFormModel;

/**
 * コンバートUtil
 * User: miyamoto_s
 * Date: 2013/10/19
 * Time: 18:19
 */
public class ConvertUtil {
    public static User SigninFormToUser(SigninFormModel signinFormModel) {
        return new User(signinFormModel);
    }
}
