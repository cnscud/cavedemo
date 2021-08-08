package com.cnscud.cavedemo.web;

import com.cnscud.xpower.utils.Md5;
import com.cnscud.xpower.utils.XBase64Utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * todo Description.
 *
 * @author Felix Zhang 2021-08-07 18:17
 * @version 1.0.0
 */
public class UserSignTest   {

    @Test
    public void testPassword(){
        String password = "abc123";
        String salt = "abc";

        String result = Md5.crypt(MsgConstants.saltPrefix + salt + password);

        Assert.assertEquals(result, "8262e062cfc7cb6ab11bf4eb43fe7c8d");


    }

    public static void main(String[] args) {
        String password = "abc123";
        String salt = "abc";

        System.out.println(Md5.crypt(MsgConstants.saltPrefix + salt + password));
    }
}
