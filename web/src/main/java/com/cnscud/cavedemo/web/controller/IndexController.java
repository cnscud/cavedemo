package com.cnscud.cavedemo.web.controller;

import com.cnscud.cavedemo.fundmain.model.Blog;
import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.web.MsgConstants;
import com.cnscud.cavedemo.web.feign.BlogServiceClient;
import com.cnscud.cavedemo.web.helper.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Index.
 *
 * @author Felix Zhang 2021-08-06 18:31
 * @version 1.0.0
 */
@Controller
public class IndexController {

    @Autowired
    private BlogServiceClient blogServiceClient;

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String indextest(Model model) {
        String name = "mars";

        model.addAttribute("name", name);

        return "/test";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "/index";
    }


    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    @LoginRequired
    public String home(Model model, HttpServletRequest request) {
        String name = "mars";

        model.addAttribute("name", name);
        //读取博客

        User user = (User) request.getAttribute(MsgConstants.CURRENT_USER_ATTRIBUTE);
        List<Blog> blogs = blogServiceClient.queryBlogsByUser(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("blogs", blogs);

        return "/home";
    }

}
