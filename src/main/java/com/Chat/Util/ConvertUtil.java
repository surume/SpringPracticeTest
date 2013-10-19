package com.Chat.Util;

import com.Chat.Entity.User;
import com.Chat.Model.SigninFormModel;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/10/19
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */
public class ConvertUtil {
    public static User SigninFormToUser(SigninFormModel signinFormModel) {
        return new User(signinFormModel);
    }
}
