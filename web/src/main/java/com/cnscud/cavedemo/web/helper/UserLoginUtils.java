package com.cnscud.cavedemo.web.helper;

import com.cnscud.cavedemo.web.MsgConstants;
import com.cnscud.xpower.utils.Md5;

/**
 * Utils for User Login misc.
 *
 * @author Felix Zhang 2021-08-07 18:37
 * @version 1.0.0
 */
public class UserLoginUtils {

    public static String shadowPassword(String salt, String password){
        return Md5.crypt(MsgConstants.saltPrefix + salt + password);
    }
}
